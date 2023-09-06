package com.zuzex.crudappzuzex.handler;

import com.zuzex.crudappzuzex.exception.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<String> droneApplicationException(ApplicationException e){
        return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
}
