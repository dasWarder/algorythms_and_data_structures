package com.example.testing.sorting.selection;

import com.example.testing.sorting.array.Sorting;

//[3,4,5,1,6,2] --> [1,4,5,3,6,2] --> [1,4,5,2,6,3]
//[1,4,5,2,6,3] --> [1,2,5,4,6,3] --> [1,2,5,3,6,4]
//[1,2,5,3,6,4] --> [1,2,3,5,6,4] --> [1,2,3,4,6,5]
//[1,2,3,4,6,5] --> [1,2,3,4,6,5]
//[1,2,3,4,6,5] --> [1,2,3,4,5,6]
public class SelectionSort implements Sorting {

    @Override
    public void sort(long[] arr, int length) {
        for(int i = 0; i < length - 1; i++) {

            int min = i;

            for(int j = i + 1;j < length; j++) {

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
        System.out.println("Selection sorting strategy");
    }
}
