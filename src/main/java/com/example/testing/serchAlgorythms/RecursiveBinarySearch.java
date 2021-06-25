package com.example.testing.serchAlgorythms;

public class RecursiveBinarySearch {

    private static int[] arr;

    public static void main(String[] args) {

        arr = new int[]{2,4,6,8,12,14,18,22};

        int result = doRecursiveBinarySearch(18, 0, arr.length - 1);

        System.out.println(result);
    }

    private static int doRecursiveBinarySearch(int element, int low, int height) {
        int mid = (low + height) / 2;

        if(arr[mid] == element) {
            return mid;
        }

        height = arr[mid] > element? mid - 1 : height;
        low = arr[mid] < element? mid + 1 : low;

        return doRecursiveBinarySearch(element, low, height);
    }
}
