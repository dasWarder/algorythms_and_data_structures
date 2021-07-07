package com.example.testing.sorting.quick;

import com.example.testing.sorting.array.Sorting;
import com.example.testing.sorting.partition.Partition;

public class SimpleQuickSort implements Sorting {

    private Partition partition = new Partition();

    @Override
    public void sort(long[] arr, int length) {

            quickSortRecursion(arr, 0, length - 1);
    }

    private void quickSortRecursion(long[] arr, int left, int right) {

        if(right - left <= 0) {
            return;
        } else {
            int position = partition.parting(arr, left, right);
            quickSortRecursion(arr, left, position - 1);
            quickSortRecursion(arr, position + 1, right);
        }
    }

    @Override
    public void sortingName() {
        System.out.println("Quick sorting strategy");
    }
}
