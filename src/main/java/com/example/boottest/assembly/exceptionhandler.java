package com.example.boottest.assembly;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(value = "com.example.boottest.controller")
public class exceptionhandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity errorhandler(Exception e){
        System.out.println(e.getMessage());
        System.out.println(e);
        e.printStackTrace();
        return new ResponseEntity("this is a error im's watching you", HttpStatus.BAD_GATEWAY);
    }

}
