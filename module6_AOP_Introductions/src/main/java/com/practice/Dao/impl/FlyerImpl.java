package com.practice.Dao.impl;

import com.practice.Dao.Flyer;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class FlyerImpl extends DelegatingIntroductionInterceptor implements Flyer {
    @Override
    public void takeOff() {
        System.out.println("Taking off");
    }

    @Override
    public void fly() {
        System.out.println("FLying");
    }

    @Override
    public void land() {
        System.out.println("Landing");
    }
}
