package com.example.testing.sorting.insertion;

import com.example.testing.sorting.Sorting;

public class InsertionSort implements Sorting {
    @Override
    public void sort(long [] arr, int length) {
        for(int i = 1; i < length; i++) {
            long temp = arr[i];
            int j = i;

            while(j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = temp;
        }
    }

    @Override
    public void sortingName() {
        System.out.println("Insertion sorting strategy");
    }
}
