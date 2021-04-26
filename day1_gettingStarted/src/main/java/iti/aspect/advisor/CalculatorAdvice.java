package iti.aspect.advisor;

public class CalculatorAdvice {

    public CalculatorAdvice() {
        System.out.println("\nCalculatorAdvice()");
    }

    public void before(double num1, String operator, double num2) {
        System.out.println("Before : " + num1 + operator + num2);
    }

    public void after(double result) {
        System.out.println("After : return is " + result);
    }

    public void afterThrowing(Exception exception) {
        System.err.println(exception.getMessage());
    }
}

