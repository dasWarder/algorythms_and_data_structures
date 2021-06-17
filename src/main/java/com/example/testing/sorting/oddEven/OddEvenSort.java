package com.example.testing.sorting.oddEven;

import com.example.testing.sorting.array.Sorting;

public class OddEvenSort implements Sorting {
    @Override
    public void sort(long[] arr, int length) {
        boolean isSorted = false;

        while(!isSorted) {
            isSorted = true;

            for (int i = 1; i < length - 1; i = i + 2) {
                if(arr[i] > arr[i + 1]) {
                    swap(i, i + 1, arr);
                    isSorted = false;
                }
            }

            for (int i = 0; i < length - 1; i = i + 2) {
                if(arr[i] > arr[i + 1]) {
                    swap(i, i + 1, arr);
                    isSorted = false;
                }
            }
        }
    }

    @Override
    public void sortingName() {
        System.out.println("OddEven sorting strategy");
    }

    private void swap(int first, int second, long[] arr) {
        long element = arr[first];
        arr[first] = arr[second];
        arr[second] = element;
    }
}
