package com.example.menuManagement.implDependency.looseCoupling;

import java.util.Arrays;

public class Method {
    private SortInt sortInt;
    private SearchInt searchInt;

    public Method(SortInt sortInt, SearchInt searchInt) {
        this.sortInt = sortInt;
        this.searchInt = searchInt;
    }


    public int sortSearch (int[] arr, int num) {
        sortInt.sortArr(arr);
        int host = searchInt.binarySearch(arr,num);
        return host;
    }
}
