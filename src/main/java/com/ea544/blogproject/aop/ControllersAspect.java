package com.ea544.blogproject.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllersAspect {
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controller() {
    }

    @AfterReturning(pointcut = "controller()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        if (result instanceof ResponseEntity) {
            ResponseEntity responseEntity = (ResponseEntity) result;
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                System.out.println(joinPoint.getSignature() + " executed successfully");
            } else {
                System.out.println(joinPoint.getSignature() + " execution failed");
                Long.parseLong((String) result);
            }
        }
    }

//    @Around("execution(* com.ea544.blogproject.post.PostService.get(String))")
//    public void aroundTest(ProceedingJoinPoint pjp){
//        String name = (String) pjp.getArgs()[0];
//        name = "test";
//        pjp.proceed(name);
//    }
}

