package com.example.menuManagement.beanCreation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AutomatedInstance {

    private LocalTime tm = LocalTime.now();

    public AutomatedInstance() {
        System.out.println("Automated bean is created " + tm);
    }

    @Override
    public String toString() {
        return "AutomatedInstance{" +
                "tm=" + tm +
                '}';
    }
}
