package com.practice.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    //    @Before("execution(* *.*Passenger(..))")
    @Before("execution(* com.practice.Dao.impl.*.*(..))")
    private void before() {
        logger.info("Entering method");
    }

    @After("execution(* *.*Passenger(..))")
    private void after() {
        logger.info("Exiting method");
    }

//    @Around("execution(* *.*Passenger(..))")
    @Around("@annotation(com.practice.annotation.Log)")
    public Object log(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        logger.info("call method " + methodName + "with args " + methodArgs[0]);

        Object result = thisJoinPoint.proceed();

        logger.info("Method " + methodName + " returns " + result);

        return result;
    }
}
