package iti.aspect.advisor;

import org.springframework.aop.ThrowsAdvice;

public class CalculatorAfterThrow implements ThrowsAdvice {

    public void afterThrowing(IllegalArgumentException exception) throws Throwable {
        System.err.println("Illegal agruments");
    }
}
