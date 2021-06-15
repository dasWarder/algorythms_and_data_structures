package com.example.testing.sorting.selection;

import com.example.testing.sorting.Sorting;


public class SelectionSort implements Sorting {

    @Override
    //[1,2,3,4,5,6]
    public void sort(long[] arr, int length) {
        //[1,2,3,4,5] i = 1
        for(int i = 0; i < length - 1; i++) {
            //min = 1
            int min = i;
            //[2,3,4,5,6] j = 2
            for(int j = i + 1;j < length; j++) {
                //1 > 2? continuous : min = 2
                if(arr[min] > arr[j]) {
                    min = j;
                }
                long first = arr[i];
                arr[i] = arr[min];
                arr[min] = first;
            }
        }
    }

    @Override
    public void sortingName() {
        System.out.println("Selection strategy");
    }
}
