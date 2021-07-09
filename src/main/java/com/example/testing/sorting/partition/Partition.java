package com.example.testing.sorting.partition;

import static com.example.testing.sorting.quick.Util.swap;

public class Partition {

    public int parting(long[] arr, int left, int right) {


        int result = partition(arr, left, right);

        return result;
    }

    protected int partition(long[] arr, int left, int right) {

        long pivot = arr[right];
        int leftPtr = left - 1;

        for(int i = left; i < right; i++) {

            if(arr[i] <= pivot) {
                leftPtr++;

                swap(arr, leftPtr, i);
            }

        }

        swap(arr, ++leftPtr, right);

        return leftPtr;
    }
}
