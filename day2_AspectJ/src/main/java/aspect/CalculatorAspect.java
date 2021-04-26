package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class CalculatorAspect {

    Logger logger = Logger.getLogger(CalculatorAspect.class.getName());

    @Pointcut("execution(* *.*..add(..))")
    private void addOperation() {

    }

    @Pointcut("execution(* *.*..*(..))")
    private void allOperations() {

    }

    //    @Before("execution(* com.day2Intro.dao..add(..))")
    @Before("addOperation()")
    public void before(JoinPoint joinPoint) {

        System.out.println("\nBefore your service method");

        logger.info("The method: " + joinPoint.getSignature().getName()
                + "; \n" + "The arguments: "
                + Arrays.toString(joinPoint.getArgs()));
    }

    //    @After("execution(* *.*(..))")
    @After("addOperation()")
    public void after(JoinPoint joinPoint) {

        System.out.println("\nAfter your service method");
        System.out.println("The method: "
                + joinPoint.getSignature().getName()
                + ";\n" + "The arguments: "
                + Arrays.toString(joinPoint.getArgs()));
    }

    //    @AfterReturning("execution(* *.*(..))")
    @AfterReturning("addOperation()")
    public void afterReturn(JoinPoint joinPoint) {

        System.out.println("\nAfterReturning your service method");
        System.out.println("The method: "
                + joinPoint.getSignature().getName()
                + ";\n" + "The arguments: "
                + Arrays.toString(joinPoint.getArgs()));
    }

    //    @AfterReturning(returning = "result", pointcut = "execution(* com.day2Intro.dao..add(..))")
    @AfterReturning(returning = "result", pointcut = "addOperation()")
    public void afterReturnWithResult(JoinPoint joinPoint, Object result) {

        System.out.println("\nAfterReturning your service method with result");
        System.out.println("The method: "
                + joinPoint.getSignature().getName()
                + ";\n" + "The arguments: "
                + Arrays.toString(joinPoint.getArgs())
                + ";\n" + "The return: " + result);
    }

    //    @AfterThrowing("execution(* com.day2Intro.dao..*(..))")
    @Before("allOperations()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("The method: "
                + joinPoint.getSignature().getName()
                + ";\n" + "The arguments: "
                + Arrays.toString(joinPoint.getArgs()));
        System.err.println("Exception................");
    }

    //    @AfterThrowing(throwing = "throwable", pointcut = "execution(* com.day2Intro.dao..*(..))")
    @AfterThrowing(throwing = "throwable", pointcut = "allOperations()")
    public void afterThrowingWithResult(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("The method: "
                + joinPoint.getSignature().getName()
                + ";\n" + "The arguments: "
                + Arrays.toString(joinPoint.getArgs())
                + " Throws: " + throwable.getMessage());

        System.err.println("Exception................");
    }

//    @Around("addOperation()")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("The method: "
//                + joinPoint.getSignature().getName()
//                + ";\n" + "The arguments: "
//                + Arrays.toString(joinPoint.getArgs()));
//
//        Object result;
//
//        try {
//            result = joinPoint.proceed();
//        } catch (IllegalArgumentException ex) {
//            ex.printStackTrace();
//            throw ex;
//        }
//
//        return result;
//    }

}
