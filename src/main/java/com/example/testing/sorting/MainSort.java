package com.example.testing.sorting;

import com.example.testing.sorting.array.Sorting;
import com.example.testing.sorting.quick.SimpleQuickSort;

public class MainSort {

    public static void main(String[] args) {

        Sorting sort = new SimpleQuickSort();
        long[] arr = new long[] {5,2,4,1,3,12,19,9,11,7};

        sort.sort(arr, arr.length);

    }
}
