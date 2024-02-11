package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.exception.NoRecordFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<String> handleInvalidIdException(InvalidIdException ex, WebRequest webRequest) {
	 //ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), webRequest.getDescription(false));
                
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
	

	
	@ExceptionHandler(NoRecordFoundException.class)
    public ResponseEntity<String> handleNoRecordFoundException(NoRecordFoundException ex, WebRequest webRequest) {
	 //ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), webRequest.getDescription(false));
                
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
	

}
