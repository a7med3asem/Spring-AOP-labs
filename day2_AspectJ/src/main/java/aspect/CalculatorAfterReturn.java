package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class CalculatorAfterReturn {

//    Logger logger = Logger.getLogger(CalculatorAfterReturn.class.getName());

    @AfterReturning("execution(* *.*(..))")
    public void afterReturn(JoinPoint joinPoint) {

        System.out.println("\nAfterReturning your service method");
        System.out.println("The method: "
                + joinPoint.getSignature().getName()
                + ";\n" + "The arguments: "
                + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "result", pointcut = "execution(* com.day2Intro.dao..add(..))")
    public void afterReturnWithResult(JoinPoint joinPoint, Object result) {

        System.out.println("\nAfterReturning your service method with result");
        System.out.println("The method: "
                + joinPoint.getSignature().getName()
                + ";\n" + "The arguments: "
                + Arrays.toString(joinPoint.getArgs())
                + ";\n" + "The return: " + result);
    }
}
