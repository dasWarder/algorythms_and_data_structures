package com.example.testing.sorting.partition;

public class Partition {

    public int parting(long[] arr, int left, int right) {


        int result = partition(arr, left, right);

        return result;
    }

    private int partition(long[] arr, int left, int right) {

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

    private void swap(long[] arr, int inx1, int inx2) {

        long temp = arr[inx1];

        arr[inx1] = arr[inx2];

        arr[inx2] = temp;

    }
}
