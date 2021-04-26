package com.day2Intro.dao.impl;

import com.day2Intro.dao.MinCalculator;

public class MinCalculatorImpl implements MinCalculator {
    @Override
    public double min(double firstOperand, double secondOperand) {
        double result = (firstOperand <= secondOperand)
                ? firstOperand : secondOperand;

        System.out.println("The min is " + result);
        return result;
    }
}
