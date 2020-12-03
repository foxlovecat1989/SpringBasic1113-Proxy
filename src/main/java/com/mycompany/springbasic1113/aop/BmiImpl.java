package com.mycompany.springbasic1113.aop;

import org.springframework.stereotype.Component;

@Component
public class BmiImpl implements Bmi{

    @Override
    public Double calc(Double height, Double weight) {
        return weight / Math.pow(height/100, 2);
    }
    
}
