package com.practice;

import com.practice.Dao.Flyer;
import com.practice.model.Flight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = com.practice.config.Config.class)
public class FlyerTest {

    @Autowired
    private Flight flight;

    @Test
    public void flyerTest() {
        assertTrue(flight instanceof Flight);
        System.out.println(flight.getId());
        System.out.println(flight.getCompany());

        System.out.println(flight.getClass().getName());

        assertTrue(flight instanceof Flyer);
        ((Flyer) flight).takeOff();
        ((Flyer) flight).fly();
        ((Flyer) flight).land();

        System.out.println(flight.getClass().getName());
        /*
         * com.practice.model.Flight$$EnhancerBySpringCGLIB$$1a98e2de
         * class is created at runtime by CGLIB
         *
         * And it can act as a flyer and as a flight
         *
         * */
    }
}
