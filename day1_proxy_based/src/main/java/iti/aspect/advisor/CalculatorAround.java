package iti.aspect.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

public class CalculatorAround implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("The method around : '" + methodInvocation.getMethod().getName() + "' with args " + Arrays.toString(methodInvocation.getArguments()));

        Object result = null;

        try{
            result = methodInvocation.proceed();
        } catch (IllegalArgumentException ex){
            ex.printStackTrace();
            throw ex;
        }
        return result;
    }
}
