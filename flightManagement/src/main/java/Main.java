import com.practice.model.Flight;
import com.practice.model.Passenger;
import com.practice.model.Ticket;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");

        Flight flight = (Flight) context.getBean("flight");

        flight.print();
        System.out.println(flight.getId());
        flight.setId(234);

        System.out.println(flight.getCompany());

        for (Passenger passenger : flight.getPassengers()) {
            System.out.println(passenger);
        }

        Ticket ticket = (Ticket) context.getBean("ticket");
        ticket.setNumber("343432");

        context.close();
    }
}
