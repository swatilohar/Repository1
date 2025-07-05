package com.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.DTO.ErrorHandlingResponce;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	  @ExceptionHandler(ResourceFoundException.class)
	  public ResponseEntity<?> resourceFoundHandler(ResourceFoundException re){
	  
		  return new ResponseEntity(new ErrorHandlingResponce().builder().message(re.getMessage()).build(), HttpStatus.CONFLICT);
	  
	  }
	  
	 

	
	  @ExceptionHandler(RoleNotFoundException.class)
	  public ResponseEntity<?> roleNotFoundHandler(RoleNotFoundException e){
	  
		  return new ResponseEntity(new ErrorHandlingResponce().builder().message(e.getMessage()).build(), HttpStatus.CONFLICT);
	  
	  }
	  
 
}
