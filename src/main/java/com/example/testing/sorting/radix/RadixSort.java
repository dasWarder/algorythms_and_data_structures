package com.example.testing.sorting.radix;

import com.example.testing.sorting.array.Sorting;

import java.util.ArrayList;
import java.util.List;

public class RadixSort implements Sorting {

    @Override
    public void sort(long[] arr, int length) {
        radixSort(arr);
    }

    @Override
    public void sortingName() {
        System.out.println("Radix sorting strategy");
    }

    private static void radixSort(long[] arr) {

        List<Long>[] buckets = new ArrayList[10];

        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        boolean isFinished = false;
        long temp = -1;
        int divisor = 1;

        while(!isFinished) {

            isFinished = true;

            for(Long num : arr) {

                temp = num / divisor;
                buckets[(int) temp % 10].add(num);

                if(isFinished && temp > 0) {
                    isFinished = false;
                }
            }

            int j = 0;

            for(int k = 0; k < 10; k++) {

                for(Long numFromBucket : buckets[k]) {
                    arr[j++] = numFromBucket;
                }
                buckets[k].clear();
            }

            divisor *= 10;

        }
    }
}
