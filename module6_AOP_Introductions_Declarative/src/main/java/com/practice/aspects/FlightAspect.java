package com.practice.aspects;

import com.practice.Dao.Flyer;
import com.practice.Dao.impl.FlyerImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class FlightAspect {

    /*
     * This means the flight field will have a new parent -> flyer interface
     * and its default implementation FlyerImpl object to delegate to it
     * */
    @DeclareParents(value = "com.practice.model.Flight", defaultImpl = FlyerImpl.class)
    private Flyer flyer;

}
