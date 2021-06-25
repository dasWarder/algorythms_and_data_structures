package com.example.testing.serchAlgorythms;

public class BinarySearch {
    private static int[] arr;


    public static void main(String[] args) {
        arr = new int[]{2,4,5,8,12,14,22};
        System.out.println(doBinarySearch(8));
    }


    private static int doBinarySearch(int element) {
        int low = 0;
        int height = arr.length - 1;
        int mid;

        while(true) {

            mid = (low + height) / 2;

            if (arr[mid] == element) {

                return mid;
            }

            height = arr[mid] > element? mid - 1 : height;
            low = arr[mid] < element? mid + 1 : low;
        }
    }
}
