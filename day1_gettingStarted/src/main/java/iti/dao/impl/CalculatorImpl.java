package iti.dao.impl;

import iti.dao.Calculator;

public class CalculatorImpl implements Calculator {

    public CalculatorImpl() {
        System.out.println("\nCalculatorImpl()");
    }

    @Override
    public double add(double num1, double num2) {
        double result = num1 + num2;
        return result;
    }

    @Override
    public double subtract(double num1, double num2) {
        double result = num1 - num2;
        return result;
    }

    @Override
    public double multiply(double num1, double num2) {
        double result = num1 * num2;
        return result;
    }

    @Override
    public double divide(double num1, double num2) {
        double result = num1 / num2;
        return result;
    }
}
