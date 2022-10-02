package com.codehustle.ems.exceptions;

public class ServiceException extends Exception{

    public ServiceException(){}

    public ServiceException(Exception e){
        super(e);
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(Exception e,String message){
        super(message,e);
    }
}
