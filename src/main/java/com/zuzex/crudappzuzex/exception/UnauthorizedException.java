package com.zuzex.crudappzuzex.exception;

import org.springframework.http.HttpStatus;

import java.net.http.HttpTimeoutException;

public  class UnauthorizedException extends ApplicationException{
    public UnauthorizedException(String message){
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.UNAUTHORIZED;
    }

}
