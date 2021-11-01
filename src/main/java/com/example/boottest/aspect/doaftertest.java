package com.example.boottest.aspect;



import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Slf4j
@Aspect
@Component
public class doaftertest {
    @Pointcut("execution(* com.example.boottest.controller.*.*(..))")
    public void pointcuttest(){

    }

    @Pointcut("execution(* com.example.boottest.service.*.*(..))")
    public void pointcutService(){

    }


    @Before(value = "pointcuttest()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("proxy service method before:{}",joinPoint.getSignature().getName());


    }

    @After(value = "pointcutService()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("proxy service method after:"+joinPoint.getSignature().getName());
    }


    @AfterReturning(value = "pointcuttest()",returning = "keys")
    public void doaftertest(JoinPoint joinPoint, Object keys){
        if (!ObjectUtils.isEmpty(keys)) {
            System.out.println(keys.toString());
        }
    }
}
