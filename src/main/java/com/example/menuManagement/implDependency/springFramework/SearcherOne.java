package com.example.menuManagement.implDependency.springFramework;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SearcherOne implements SearchIntOne{

    public int method (int[] arr, int num) {
        int host = Arrays.binarySearch(arr,num);
        return host;
    }
}
