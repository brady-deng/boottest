package com.example.boottest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test2")
public class controller2 {

    @GetMapping("/exceptiontest")
    public void exceptiontest(){
        String ob = null;
//        try{
//            ob.equals("222");
//        }
//        catch (Exception e){
//            System.out.println("e.getMessage()");
//        }
        ob.equals("234");
    }
}
