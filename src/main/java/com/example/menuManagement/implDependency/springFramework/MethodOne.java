package com.example.menuManagement.implDependency.springFramework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MethodOne {

    @Autowired
    private SortIntOne sortIntOne;
    @Autowired
    private SearchIntOne searchIntOne;

    public MethodOne(SortIntOne sortIntOne, SearchIntOne searchIntOne) {
        this.sortIntOne = sortIntOne;
        this.searchIntOne = searchIntOne;
    }

    public int searchSortedArray (int[] arr, int num) {
        return 0;
    }
}
