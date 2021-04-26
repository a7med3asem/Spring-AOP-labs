package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Order(1)
public class CalculatorBefore {

    Logger logger = Logger.getLogger(CalculatorBefore.class.getName());

    //    @Before("execution(* com.day2Intro.dao.impl..add(..))")
    @Before("execution(* com.day2Intro.dao..add(..))")
    public void before(JoinPoint joinPoint) {

        System.out.println("\nBefore your service method");

        logger.info("The method: " + joinPoint.getSignature().getName()
                + "; \n" + "The arguments: "
                + Arrays.toString(joinPoint.getArgs()));
    }
}
