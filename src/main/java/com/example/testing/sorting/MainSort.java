package com.example.testing.sorting;

import com.example.testing.sorting.array.Sorting;
import com.example.testing.sorting.quick.OptimalQuickSort;

public class MainSort {

    public static void main(String[] args) {

        Sorting sort = new OptimalQuickSort();
        long[] arr = new long[] { 3, 2, 6, 4, 5, 11, 1};

        sort.sort(arr, arr.length);

    }
}
