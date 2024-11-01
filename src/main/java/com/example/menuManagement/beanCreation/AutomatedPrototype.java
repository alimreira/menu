package com.example.menuManagement.beanCreation;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AutomatedPrototype {

    private LocalTime tm = LocalTime.now();

    public AutomatedPrototype() {
        System.out.println("AutomatedPrototype bean is made " + tm);
    }

    @Override
    public String toString() {
        return "AutomatedPrototype{" +
                "tm=" + tm +
                '}';
    }
}
