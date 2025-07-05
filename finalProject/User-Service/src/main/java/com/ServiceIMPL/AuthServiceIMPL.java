package com.ServiceIMPL;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.DTO.RegisterRequest;
import com.DTO.UserResponce;
import com.Entity.Role;
import com.Entity.User;
import com.Enums.KycStatusEnum;
import com.Enums.RolesEnum;
import com.Enums.UserStatusEnum;
import com.Exceptions.ResourceFoundException;
import com.Exceptions.RoleNotFoundException;
import com.Repository.RoleRepo;
import com.Repository.UserRepo;
import com.Service.AuthenticationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthServiceIMPL implements AuthenticationService {

	@Autowired
	private UserRepo ur;

	@Autowired
	private RoleRepo rr;

	@Override
	public UserResponce registerUser(RegisterRequest registerrequest) {

		log.info("User details from ui" + registerrequest);

		System.out.println(registerrequest);

		// User user = ur.findByEmail(request.getEmail()).orElseThrow(()-> new
		// ResourceFoundException("User already exist"));

		Optional<User> user = ur.findByEmail(registerrequest.getEmail());

		Optional<Role> roleFromDB = rr.findByName(registerrequest.getRole());

		System.out.println(roleFromDB);

		log.debug("User details after getting from DB :-" + user);

		System.out.println(user);

		User userToSave = new User();

		ModelMapper model = new ModelMapper();

		model.map(registerrequest, userToSave);

		if (user.isPresent()) {

			throw new ResourceFoundException("User already exist");

		} else if (!roleFromDB.isPresent()) { // In optional class if we are getting optional.empty at that time is
												// present method returns false. To return true here because i want to
												// execute role not found in if block thats why make false as true by
												// using not operator.

			throw new RoleNotFoundException("Role not found");

		} else {

			userToSave.setKycstatus(KycStatusEnum.PENDING);
			userToSave.setUserStatus(UserStatusEnum.ACTIVE);
			userToSave.setRole(roleFromDB.get());

			User u = ur.save(userToSave);
			log.debug("User details after saved " + u);

			UserResponce responce = new UserResponce();

			model.map(u, responce);

			return responce;

		}

	}

}
