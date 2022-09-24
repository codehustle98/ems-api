package com.codehustle.ems.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<Object> handleServiceException(Exception e, WebRequest request){
        if(e.getMessage().contains("exists")){
            return new ResponseEntity<Object>(e.getMessage(),new HttpHeaders(), HttpStatus.BAD_REQUEST);
        } else if(e.getMessage().contains("not found")){
            return new ResponseEntity<Object>(e.getMessage(),new HttpHeaders(), HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<Object>(e.getMessage(),new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleGenericException(Exception e, WebRequest request){
        return new ResponseEntity<Object>(e.getMessage(),new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
