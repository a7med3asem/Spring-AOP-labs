package com.practice.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(1)
public class LoggingAspect1 {
    private Logger logger = Logger.getLogger(LoggingAspect1.class.getName());

    @Before("execution(public int com.practice.model.Flight.getId())")
    private void loggingAdviceId() {
        logger.info("Flight getId method will be called");
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

        logger.info("LoggingAspect1");

        logger.info("call method " + methodName + "with args " + methodArgs[0]);

        Object result = thisJoinPoint.proceed();

        logger.info("Method " + methodName + " returns " + result);

        return result;
    }

    @AfterReturning("execution(public * *.print())")
    public void loggingAdvicePrint() {
        logger.warning("A print method has bean called");
    }

    @Pointcut("within(com.practice.model.Ticket)")
    public void allTicketMethods() {

    }

    @After("allTicketMethods()")
    public void loggingAdvice(JoinPoint joinPoint) {
        logger.info("A ticket method had been called.");
        logger.info(joinPoint.toString());
        logger.info(joinPoint.getTarget().toString());
    }
}
