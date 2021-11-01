package com.example.boottest.assembly;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(value = "com.example.boottest.controllertest")
public class exceptionhandler2 {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity errorhandler(NullPointerException e){

        return new ResponseEntity("i'm loving you", HttpStatus.BAD_GATEWAY);
    }

}
