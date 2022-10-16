package com.codehustle.ems.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ServiceException.class,NotFoundException.class})
    public ResponseEntity<Object> handleServiceException(Exception e){
        if(e.getMessage().contains("exists")){
            return new ResponseEntity<Object>(e.getMessage(),new HttpHeaders(), HttpStatus.BAD_REQUEST);
        } else if(e.getMessage().contains("not found")){
            return new ResponseEntity<Object>(e.getMessage(),new HttpHeaders(), HttpStatus.NOT_FOUND);
        }else if(e.getMessage().contains("invalid")){
            return new ResponseEntity<Object>(e.getMessage(),new HttpHeaders(),HttpStatus.UNAUTHORIZED);
        }
        else{
            return new ResponseEntity<Object>(e.getMessage(),new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if(ex.getFieldError() != null && ex.getFieldError().getDefaultMessage() != null){
            return new ResponseEntity<Object>(ex.getFieldError().getDefaultMessage(),headers,status);
        }else{
            return super.handleMethodArgumentNotValid(ex, headers, status, request);
        }
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleGenericException(Exception e){
        return new ResponseEntity<Object>(e.getMessage(),new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
