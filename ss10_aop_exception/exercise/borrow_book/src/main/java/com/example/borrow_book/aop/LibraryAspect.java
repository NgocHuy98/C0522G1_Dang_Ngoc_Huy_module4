package com.example.borrow_book.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LibraryAspect {
    int count = 0;
    @Pointcut("within(com.example.borrow_book.*)")
    public void allMethodPointCut(){
    }

    @Before("allMethodPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.out.printf("Start method name : "
        +joinPoint.getSignature().getName()
        +"Time: " + LocalDateTime.now());
    }

    @AfterReturning("allMethodPointCut()")
    public void afterThrowingCallMethod(JoinPoint joinPoint){
        count++;
        System.out.printf("End method name : "
                +joinPoint.getSignature().getName()
                +"Time: " + LocalDateTime.now()+" Number of interactions " +count);
    }

    @Pointcut("within( *com.example.borrow_book.Librarycontroller.*)")
    public void payAndBorrowMethodPointCut() {
    }

    @After("payAndBorrowMethodPointCut()")
    public void afterPayAndBorrowMethod(JoinPoint joinPoint) {
        System.err.println("Method name: " + joinPoint.getSignature().getName() + " | Time: " + LocalDateTime.now());
    }


}
