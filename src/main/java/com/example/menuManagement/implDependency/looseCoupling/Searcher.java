package com.example.menuManagement.implDependency.looseCoupling;

import java.util.Arrays;

public class Searcher implements SearchInt{

    public int binarySearch (int[] arr, int num) {
        int host = Arrays.binarySearch(arr,num);
        return host;
    }
}
