package com.doctor.main.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EmptyData.class)
	public ResponseEntity<Object> Excep1(EmptyData ex, WebRequest request){
		
		ExceptionModel excp = new ExceptionModel(ex.getMsg(),request.getDescription(false));
		
		return new ResponseEntity<Object>(excp ,HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
	}
}
