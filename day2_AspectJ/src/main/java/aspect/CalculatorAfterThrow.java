package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class CalculatorAfterThrow {

    @AfterThrowing("execution(* com.day2Intro.dao..*(..))")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("The method: "
                + joinPoint.getSignature().getName()
                + ";\n" + "The arguments: "
                + Arrays.toString(joinPoint.getArgs()));
        System.err.println("Exception................");
    }
}
