package com.example.testing.sorting;

import com.example.testing.sorting.array.Sorting;
import com.example.testing.sorting.array.TestArray;
import com.example.testing.sorting.merge.MergeRecursionSort;

public class MainSort {

    public static void main(String[] args) {

        Sorting sort = new MergeRecursionSort();
        long[] arr = new long[] {5,2,4,1,3};

        sort.sort(arr, arr.length);


    }
}
