package com.example.testing.sorting.quick;

public class Util {

    public static long findMedianOfThree(long[] arr, int left, int right) {

        int center = (left + right) / 2;

        swapThreeElement(arr, left, right, center);

        swap(arr, center, right - 1);

        return arr[right - 1];

    }

    public static void swapThreeElement(long[] arr, int left, int right, int center) {

        if(arr[left] > arr[center]) {
            swap(arr, left, center);
        }

        if(arr[left] > arr[right]) {
            swap(arr, left, right);
        }

        if(arr[center] > arr[right]) {
            swap(arr, center, right);
        }

    }

    public static void swap(long[] arr, int inx1, int inx2) {

        long temp = arr[inx1];

        arr[inx1] = arr[inx2];

        arr[inx2] = temp;

    }
}
