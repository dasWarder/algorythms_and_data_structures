package com.example.testing;


import com.example.testing.sorting.array.Sorting;
import com.example.testing.sorting.array.TestArray;
import com.example.testing.sorting.shell.ShellsSort;

public class TestingApplication {

    public static void main(String[] args) {

        Sorting sorting = new ShellsSort();

        long[] arr = new long[]{12,2,19,4,7,9,10,11,22,1};

        sorting.sort(arr, arr.length);
    }

};

