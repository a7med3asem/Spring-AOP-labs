import com.day2Intro.dao.Calculator;
import com.day2Intro.dao.MaxCalculator;
import com.day2Intro.dao.MinCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Calculator calculator = context.getBean("calc", Calculator.class);
        System.out.println(calculator);
        calculator.add(5, 10);
        calculator.subtract(25, 8);

        MaxCalculator maxCalculator = (MaxCalculator) calculator;
        maxCalculator.max(4, 5);

        MinCalculator minCalculator = (MinCalculator) calculator;
        minCalculator.min(8, 6);

    }
}
