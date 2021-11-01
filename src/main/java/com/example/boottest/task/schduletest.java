package com.example.boottest.task;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class schduletest {

    @Scheduled(cron = "* * * * * *")
    private void schedule(){
        System.out.println("this is a scheduletest");
    }
}
