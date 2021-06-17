package com.example.testing.sorting.insertion;

import com.example.testing.sorting.array.Sorting;

//[3,4,2,5,1,6] --> i = 1, v = 4 --> 4 > 3;
//[3,4,2,5,1,6] --> i = 2, v = 2 --> 2 < 4 --> [3,4,4,5,1,6] --> 2 < 3 --> [3,3,4,5,1,6] --> [2,3,4,5,1,6];
//[2,3,4,5,1,6] --> i = 3, v = 5 --> 5 > 4;
//[2,3,4,5,1,6] --> i = 4, v = 1 --> 1 < 5 --> [2,3,4,5,5,6] --> 1 < 4 --> [2,3,4,4,5,6] --> 1 < 3 --> [2,3,3,4,5,6]
// --> [2,2,3,4,5,6] --> [1,2,3,4,5,6]
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
