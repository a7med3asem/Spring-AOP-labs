import com.practice.Dao.PassengerDao;
import com.practice.Dao.impl.PassengerDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");

        /*
         * Executing JDK Dynamic Proxy mechanism
         * */
//        PassengerDao passengerDao = context.getBean("passengerDao", PassengerDao.class);
//        System.out.println(passengerDao.getPassenger(1));

        /*
        * Test @Service
        * */
//        try {
        PassengerDao passengerDao = context.getBean("passengerDao", PassengerDao.class);
        System.out.println(passengerDao.getPassenger(0));
//        } catch (Exception e) {
//            System.err.println(e.getStackTrace());
//        }

        /*
        * Executing CGLIB Proxy mechanism
        * */
//        PassengerDaoImpl passengerDaoImpl = context.getBean("passengerDao", PassengerDaoImpl.class);
//        System.out.println(passengerDaoImpl.getPassenger(0));


        context.close();
    }
}
