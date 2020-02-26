package com.cts.swr.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.swr.exception.EmployeeException;



@RestControllerAdvice
public class ExceptionAdvicer {

		@ExceptionHandler(EmployeeException.class)
		public ResponseEntity<String> handleEmployeeExceptionAction(EmployeeException exp){
			return new ResponseEntity<String>(exp.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(Exception.class)
		public ResponseEntity<String> handleExceptionAction(Exception exp){
			return new ResponseEntity<String>(exp.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
