package com.example.testing.sorting.radix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {
    public static void main(String[] args) {

        int[] arr = new int[] {2, 193, 777, 121, 9, 14, 144, 20};
        radixSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {

        List<Integer>[] buckets = new ArrayList[10];

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        boolean isFinished = false;
        int temp = -1;
        int divisor = 1;

        while(!isFinished) {

            isFinished = true;

            for(Integer num : arr) {

                temp = num / divisor;
                buckets[temp % 10].add(num);

                if(isFinished && temp > 0) {
                    isFinished = false;
                }
            }

            int j = 0;

            for(int k = 0; k < 10; k++) {

                for(Integer numFromBucket : buckets[k]) {
                    arr[j++] = numFromBucket;
                }
                buckets[k].clear();
            }

            divisor *= 10;

        }
    }
}
