package com.example.testing.sorting.merge;

import com.example.testing.sorting.array.Sorting;

import java.util.Arrays;

public class MergeRecursionSort implements Sorting {


    @Override
    public void sort(long[] arr, int length) {
        long[] workArea = new long[length];

        recursionSort(arr, workArea, 0, length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //[5,2,4,1,3] --> 1)[5,2,4,1,3], [0,0,0,0,0], 0, 4 --> 2) [5.2.4.1.3], [0,0,0,0,0], 0, 2 --> 3) [5,2,4,1,3], [0,0,0,0,0], 0, 1
    //4) [5,2,4,1,3], [0,0,0,0,0], 0, 0 --> 5) [5,2,4,1,3], [0,0,0,0,0], 1, 1
    private void recursionSort(long[] arr, long[] workArea, int low, int high) {

        //1) 0 != 4 --> 2) 0 != 2 --> 3) 0 != 1 --> 4) 0 == 0
        if (low == high) {

            return;

        } else {
            //mid = 1) (0 + 4) / 2 = 2 --> 2) (0 + 2) / 2 = 1  --> 3) (0 + 1) / 2 = 0
            int mid = (low + high) / 2;


            //1) [5.2.4.1.3], [0,0,0,0,0], 0, 2 --> 2) [5.2.4.1.3], [0.0,0,0,0], 0, 1 --> 3) [5,2,4,1,3], [0,0,0,0,0], 0, 0
            recursionSort(arr, workArea, low, mid);
            //4.1) [5,2,4,1,3], [0,0,0,0,0], 1 (0 + 1), 1
            recursionSort(arr, workArea, mid + 1, high);
            //5) [5,2,4,1,3], [0,0,0,0,0], 0, 1
            merge(arr, workArea, low, mid + 1, high);
        }
    }

    //1) [5,2,4,1,3], [0,0,0,0,0], 0, 1, 1
    private void merge(long[] theArray, long[] workSpace, int lowPtr, int highPtr, int upperBound) {

        int count = 0;
        int lowBound = lowPtr;
        int mid = highPtr - 1;
        int size = upperBound - lowBound + 1;

        //1) 0 <= 0 && 1 <= 1
        while(lowPtr <= mid && highPtr <= upperBound) {
            //1) 5 < 2?
            if(theArray[lowPtr] < theArray[highPtr]) {

                workSpace[count++] = theArray[lowPtr++];

            } else {
                //1) [2,0,0,0,0], count = 1, hightPtr = 2
                workSpace[count++] = theArray[highPtr++];
            }
        }

        //1) 0 <= 0?
        while(lowPtr <= mid) {
            //[2,5,0,0,0], count = 2, lowPtr = 1
            workSpace[count++] = theArray[lowPtr++];
        }

        //1) 2 <= 1?
        while(highPtr <= upperBound) {
            //
            workSpace[count++] = theArray[highPtr++];
        }
        //[2,5,4,1,3]
        for(count = 0; count < size; count++) {
            theArray[lowBound + count] = workSpace[count];
        }
    }


    @Override
    public void sortingName() {
        System.out.println("Merge sorting strategy");
    }
}
