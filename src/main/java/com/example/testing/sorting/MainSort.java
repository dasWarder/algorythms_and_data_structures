package com.example.testing.sorting;

import com.example.testing.sorting.array.Sorting;
import com.example.testing.sorting.quick.OptimalQuickSortWithManualInsertSort;

public class MainSort {

    public static void main(String[] args) {

        Sorting sort = new OptimalQuickSortWithManualInsertSort();
        long[] arr = new long[] { 3, 2, 6, 4, 5, 11, 1, 12, 22, 10, 7, 33, 9, 8, 14, 21, 17};

        sort.sort(arr, arr.length);

    }
}
