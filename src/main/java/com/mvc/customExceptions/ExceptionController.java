package com.mvc.customExceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request, Exception exception) {
		System.out.println("Request: "+ request + " - Exception: " + exception);
		return "error";
	}
}
