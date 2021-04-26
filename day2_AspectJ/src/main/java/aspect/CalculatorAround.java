package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class CalculatorAround {

    @Pointcut("execution(* *.*..add(..))")
    private void addOperation() {

    }

    @Around("addOperation()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.err.println("Around");
        System.out.println("The method: "
                + joinPoint.getSignature().getName()
                + ";\n" + "The arguments: "
                + Arrays.toString(joinPoint.getArgs()));

        Object result;

        try {
            result = joinPoint.proceed();
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return result;
    }
}
