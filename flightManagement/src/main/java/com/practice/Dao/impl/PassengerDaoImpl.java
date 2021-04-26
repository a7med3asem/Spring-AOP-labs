package com.practice.Dao.impl;

import com.practice.Dao.PassengerDao;
import com.practice.annotation.Log;
import com.practice.model.Passenger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/*
 * Cannot be final
 * Cannot subclass final class com.practice.Dao.impl.PassengerDaoImpl
 * */
//public final class PassengerDaoImpl implements PassengerDao {

/*
 * to use CGLIB Proxy mechanism
 * make it concrete class and not to implement any interface
 * */
//public class PassengerDaoImpl { //} implements PassengerDao {

@Service("passengerDao")
public class PassengerDaoImpl implements PassengerDao {

    private static Map<Integer, Passenger> passengersMap = new HashMap<>();

    /*
     * If you do so
     * it cannot call before and after
     * it should not be final
     * */
//    public final Passenger getPassenger(int id) {

    @Log
    public Passenger getPassenger(int id) {

        // if exists
        if (passengersMap.get(id) != null) {
            return passengersMap.get(id);
        }

        if (id < 1) throw new RuntimeException("incorrect id");

        Passenger passenger = new Passenger(id);
        passengersMap.put(id, passenger);

        return passenger;
    }
}
