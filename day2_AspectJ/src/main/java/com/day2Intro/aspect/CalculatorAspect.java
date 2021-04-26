package com.day2Intro.aspect;

import com.day2Intro.dao.MaxCalculator;
import com.day2Intro.dao.MinCalculator;
import com.day2Intro.dao.impl.MaxCalculatorImpl;
import com.day2Intro.dao.impl.MinCalculatorImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class CalculatorAspect {

    @DeclareParents(defaultImpl = MaxCalculatorImpl.class,
        value = "com.day2Intro.dao.impl.CalculatorImpl")
    public MaxCalculator maxCalculator;

    @DeclareParents(defaultImpl = MinCalculatorImpl.class,
            value = "com.day2Intro.dao.impl.CalculatorImpl")
    public MinCalculator minCalculator;
}
