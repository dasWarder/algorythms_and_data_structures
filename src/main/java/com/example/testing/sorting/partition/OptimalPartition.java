package com.example.testing.sorting.partition;

import static com.example.testing.sorting.quick.Util.swap;

public class OptimalPartition {

    public int parting(long[] arr, int left, int right, long pivot) {


        int result = partition(arr, left, right, pivot);

        return result;
    }

    protected int partition(long[] arr, int left, int right, long pivot) {

        int leftPtr = left;

        for(int i = left + 1; i < right - 1; i++) {

            if(arr[i] <= pivot) {
                leftPtr++;

                swap(arr, leftPtr, i);
            }

        }

        swap(arr, ++leftPtr, right - 1);

        return leftPtr;
    }

}
