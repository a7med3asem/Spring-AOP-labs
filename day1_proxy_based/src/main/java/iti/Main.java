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

        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");


        Calculator calc = (Calculator) context.getBean("calculatorProxy");

        calc.add(6, 3);
        calc.divide(6, 0);

    }
}