package iti;

import iti.aspect.advisor.CalculatorAdvice;
import iti.dao.Calculator;
import iti.dao.impl.CalculatorImpl;
import iti.handler.CalculatorProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");

//        Calculator calculator = (Calculator) context.getBean("calculator");
//        CalculatorAdvice calculatorAdvice = (CalculatorAdvice) context.getBean("calculatorAdvice");

        Calculator calculator = new CalculatorImpl();
        CalculatorAdvice calculatorAdvice = new CalculatorAdvice();

        Calculator calc = (Calculator) Proxy.newProxyInstance(Main.class.getClassLoader(),
                calculator.getClass().getInterfaces(), new CalculatorProxy(calculator, calculatorAdvice));

        calc.add(2, 3);


    }
}