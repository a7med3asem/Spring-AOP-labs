package com.practice.config;

import com.practice.aspects.FlightAspect;
import com.practice.model.Flight;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Config {

    @Bean
    public FlightAspect flightAspect() {
        return new FlightAspect();
    }

    @Bean
    public Flight flight() {
        Flight flight = new Flight();

        flight.setId(234);
        flight.setCompany("ABC Flights");

        return flight;
    }
}
