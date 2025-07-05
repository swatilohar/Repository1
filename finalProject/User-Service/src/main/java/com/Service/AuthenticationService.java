package com.Service;

import org.springframework.util.MultiValueMap;

import com.DTO.RegisterRequest;
import com.DTO.UserResponce;

public interface AuthenticationService {

	UserResponce registerUser(RegisterRequest request);

}
