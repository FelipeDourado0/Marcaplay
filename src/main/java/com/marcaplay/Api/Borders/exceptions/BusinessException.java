package com.marcaplay.Api.Borders.exceptions;

public class BusinessException extends RuntimeException{

    public BusinessException(String message){super(message);}
    public BusinessException(Throwable cause){super(cause);}
    public BusinessException(Throwable cause, String message){super(message, cause);}
}
