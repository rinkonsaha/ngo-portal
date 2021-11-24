package com.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) 
	{
		ErrorDetails errorDetails = new ErrorDetails (LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<> (errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
