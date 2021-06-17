package com.example.testing.sorting.bubble;

import com.example.testing.sorting.array.Sorting;


public class BubbleSort implements Sorting {

    @Override
    public void sort(long[] arr, int length) {
        for (int i = length - 1; i >= 1; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    @Override
    public void sortingName() {
        System.out.println("Bubble sorting strategy");
    }

    private void swap(long[] arr, int first, int second) {
        long firstElement = arr[first];
        arr[first] = arr[second];
        arr[second] = firstElement;
    }
}
