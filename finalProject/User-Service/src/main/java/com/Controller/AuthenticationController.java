package com.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.RegisterRequest;
import com.Service.AuthenticationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication APIS", description = "All APIS Are related to Authentication")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService as;
	
	@Operation(summary = "register a new user" , description = "register a new user with the provided details")
	@ApiResponses({@ApiResponse(responseCode = "201", description = "User registered successfully"), @ApiResponse(responseCode = "400", description = "Bad request-Invalid input")})
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@Valid @RequestBody RegisterRequest registerrequest){
		
		log.debug("register request : "+registerrequest);
		
		return new ResponseEntity(as.registerUser(registerrequest) ,HttpStatus.OK);
	}
}
