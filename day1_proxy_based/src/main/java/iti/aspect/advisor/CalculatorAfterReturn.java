package iti.aspect.advisor;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class CalculatorAfterReturn implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object target) throws Throwable {
        System.out.println("The method afterReturning: '" + method.getName() + "' with args " + Arrays.toString(objects) +
                " with return : " + returnValue );
    }
}
