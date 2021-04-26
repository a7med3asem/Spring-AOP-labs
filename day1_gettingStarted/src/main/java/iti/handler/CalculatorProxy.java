package iti.handler;

import iti.aspect.advisor.CalculatorAdvice;
import iti.dao.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorProxy implements InvocationHandler {

    Calculator target;
    CalculatorAdvice advice;

    public CalculatorProxy() {
    }

    public CalculatorProxy(Calculator target, CalculatorAdvice advice) {
        this.target = target;
        this.advice = advice;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        double result = 0.0;
        double num1 = (Double) args[0];
        double num2 = (Double) args[1];

        switch (method.getName()) {
            case "add":
                try {
                    advice.before(num1, " + ", num2);

                    result = (double) method.invoke(target, args);

                    result = target.add(num1, num2);
                    advice.after(result);
                } catch (Exception exception) {
                    advice.afterThrowing(exception);
                }
                break;
        }
        return result;
    }
}
