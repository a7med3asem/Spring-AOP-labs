package com.day2Intro.dao.impl;

import com.day2Intro.dao.MaxCalculator;

public class MaxCalculatorImpl implements MaxCalculator {
    @Override
    public double max(double firstOperand, double secondOperand) {
        double result = (firstOperand >= secondOperand)
                ? firstOperand : secondOperand;

        System.out.println("The max is " + result);

        return result;
    }
}
