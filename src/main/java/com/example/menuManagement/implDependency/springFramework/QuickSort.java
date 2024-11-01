package com.example.menuManagement.implDependency.springFramework;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Primary
public class QuickSort implements SortIntOne{

    public void getSorted (int[] arr) {
        Arrays.sort(arr);
    }
}
