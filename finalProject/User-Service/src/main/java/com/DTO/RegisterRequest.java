package com.DTO;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.Entity.Role;
import com.Enums.RolesEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Slf4j
@Validated
public class RegisterRequest {
	
	
	@NotBlank(message = "username should not be blank")
	@Schema(example = "jcilacad")
	@JsonProperty(value = "username")
	private String username;
	
	
	@Schema(example = "johnchristopherilacad27@gmail.com")
	@NotBlank(message = "email should not be blank")
	@Email(message = "email should be in proper format")
	@JsonProperty(value = "email")
	private String email;
	
	
	@Schema(example = "John")
	@NotBlank(message = "firstname should not be blank")
	@JsonProperty(value = "firstname")
	private String firstname;
	
	
	@Schema(example = "Ilacad")
	@NotBlank(message = "middlename should not be blank")
	@JsonProperty(value = "middlename")
	private String middlename;
	
	
	@NotBlank(message = "lastname should not be blank")
	@JsonProperty(value = "lastname")
	private String lastname;
	
	
	@Schema(example = "+6391234567891")
	@NotBlank(message = "mobileNumber should not be blank")
	@Pattern(regexp = "(^$|\\+\\d{1,3}\\s?\\d{1,14})", message = "Invalid contact number. Please provide a valid mobile number.")
	@JsonProperty(value = "mobileNumber")
	private String mobileNumber;
	
	
	@Schema(example = "Password123!")
	@NotBlank(message = "password should not blank")
	@Size(min = 8, message = "password must be atleast 8 characters long ")
	@JsonProperty(value = "password")
	private String password;
	
	
	//@NotNull(message = "Role should not be null")
	//@Enumerated(EnumType.STRING)
	private RolesEnum role;
	
	
	
	
	
	
	
	
	

}
