package com.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class UserResponce {
	
	private String username;

	private String email;

	private String firstName;

	private String middleName;

	private String lastName;

	private String mobileNumber;

	private String password;



}
