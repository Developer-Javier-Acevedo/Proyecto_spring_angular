package com.proyecto.angular.demo.Service.Exceptions;


public class ServiceException extends Exception{
    

    private static final long serialVersionUID = -4587546295630758101L;

    
    public ServiceException(){

    }

    public ServiceException (String message){
        super(message);
    }

    public ServiceException(Throwable cause){
        super(cause);
    }
     
    public ServiceException (String message , Throwable cause){
        super( message, cause ); 
    }

    public ServiceException (String message, Throwable cause, boolean enableSuppresion, boolean writableStackTrace){
        super(message,cause,enableSuppresion,writableStackTrace);
    }

}
