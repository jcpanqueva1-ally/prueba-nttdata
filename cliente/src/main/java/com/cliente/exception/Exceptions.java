package com.cliente.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exceptions {

	@ExceptionHandler(Exception.class)
	public ResponseEntity <?> exceptions (Exception e){
		
		Map <String, Object> response = new HashMap<>();
		
		response.put("Message", "Upsss, aglo sucedió");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity <?> exceptionNotFound (Exception e){
		
		Map <String, Object> response = new HashMap<>();
		
		response.put("Message", "Upsss," + e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		
	}
	
}
