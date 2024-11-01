package com.example.menuManagement.implDependency.looseCoupling;

import java.util.Arrays;

public class Sorter implements SortInt{

    public void sortArr (int[] arr) {
        Arrays.sort(arr);
    }
}
