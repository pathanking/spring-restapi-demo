package com.collabera.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handler(EmployeeNotFoundException excp) {

		return new ResponseEntity<String>(excp.getMessage(), HttpStatus.BAD_REQUEST);

	}
	
	
	
	/*
	 * @ExceptionHandler public ResponseEntity<String>
	 * handler2(InvalidEmployeeDataException excp) {
	 * 
	 * return new ResponseEntity<String>(excp.getMessage(), HttpStatus.BAD_REQUEST);
	 * 
	 * }
	 */
	 
	
	
	

}
