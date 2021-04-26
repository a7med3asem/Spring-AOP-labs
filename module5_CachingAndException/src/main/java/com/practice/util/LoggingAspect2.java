package com.practice.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(2)
public class LoggingAspect2 {
    private Logger logger = Logger.getLogger(LoggingAspect2.class.getName());

    @Around("allSetters()")
    public Object log(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        logger.info("LoggingAspect2");
        logger.info("call method " + methodName + "with args " + methodArgs[0]);

        Object result = thisJoinPoint.proceed();

        logger.info("Method " + methodName + " returns " + result);

        return result;
    }

    @AfterReturning("execution(public * *.print())")
    public void loggingAdvicePrint() {
        logger.warning("A print method has bean called");
    }

    @Pointcut("execution(public * *.set*(..))")
    public void allSetters() {

    }
//
//    @After("allTicketMethods()")
//    public void loggingAdvice(JoinPoint joinPoint) {
//        logger.info("A ticket method had been called.");
//        logger.info(joinPoint.toString());
//        logger.info(joinPoint.getTarget().toString());
//    }
}
