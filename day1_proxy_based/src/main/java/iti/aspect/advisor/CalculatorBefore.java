package iti.aspect.advisor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class CalculatorBefore implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object target) throws Throwable {
        System.out.println("The method before : '" + method.getName() + "' with args " + Arrays.toString(objects));
    }
}
