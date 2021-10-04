package com.lti.appl.vehicleloan.exception;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {

	// Handle empty input exceptions
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException)
	{
		
		return new ResponseEntity<String>("Input field is Empty..Please fill all input fields properly",HttpStatus.BAD_REQUEST);
		
	}
	
	
	// Handle Invalid Id Exception
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException)
	{
		
	
		return new ResponseEntity<String>("No value is present in DB with requested Id,Please check your request",HttpStatus.NOT_FOUND);
		
	}
	

	
	// Handle Method not supported exception
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		pageNotFoundLogger.warn(ex.getMessage());

		Set<HttpMethod> supportedMethods = ex.getSupportedHttpMethods();
		if (!CollectionUtils.isEmpty(supportedMethods)) {
			headers.setAllow(supportedMethods);
		}
		return new ResponseEntity<Object>("Request Method not supported..please change your http request method type",HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	//handle global exception
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception,WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(),"EmploymentDetails not found with given Id",request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
}
