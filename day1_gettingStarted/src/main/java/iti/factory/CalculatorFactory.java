package iti.factory;

import iti.aspect.advisor.CalculatorAdvice;
import iti.dao.Calculator;
import iti.dao.impl.CalculatorImpl;
import iti.handler.CalculatorProxy;

import java.lang.reflect.Proxy;

public class CalculatorFactory {

    private final Calculator target;
    private final Calculator targetWithAdvice;

    private CalculatorFactory() {
        target = new CalculatorImpl();
        CalculatorAdvice advice = new CalculatorAdvice();
        CalculatorProxy calculatorProxy = new CalculatorProxy(target, advice);

        Class[] interfaces = new Class[]{Calculator.class};

        targetWithAdvice =
                (Calculator) Proxy.newProxyInstance(new ClassLoader() {}, interfaces, calculatorProxy);
    }

}
