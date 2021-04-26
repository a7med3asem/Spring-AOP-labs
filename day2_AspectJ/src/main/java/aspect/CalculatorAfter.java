package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class CalculatorAfter {

    Logger logger = Logger.getLogger(CalculatorAfter.class.getName());

    @After("execution(* *.*(..))")
    public void after(JoinPoint joinPoint) {

        System.out.println("\nAfter your service method");
        System.out.println("The method: "
                + joinPoint.getSignature().getName()
                + ";\n" + "The arguments: "
                + Arrays.toString(joinPoint.getArgs()));
    }
}
