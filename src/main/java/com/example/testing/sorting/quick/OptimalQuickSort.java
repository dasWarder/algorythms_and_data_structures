package com.example.testing.sorting.quick;

import com.example.testing.sorting.array.Sorting;
import com.example.testing.sorting.partition.OptimalPartition;

import static com.example.testing.sorting.quick.Util.findMedianOfThree;

public class OptimalQuickSort  implements Sorting {

    private OptimalPartition partition = new OptimalPartition();

    private ManualSort manualSort = new ManualSort();

    @Override
    public void sort(long[] arr, int length) {
        recQuickSort(arr, 0, length - 1);
    }

    private void recQuickSort(long[] arr, int left, int right) {

        int size = right - left + 1;

        if(size <= 3) {
            manualSort.manualSortWhenLessThenThree(arr, left, right);
        } else {
            long median = findMedianOfThree(arr,left, right);
            int part = partition.parting(arr, left, right, median);
            recQuickSort(arr, left, part - 1);
            recQuickSort(arr, part + 1, right);
        }
    }


    @Override
    public void sortingName() {
        System.out.println("Optimal quick sort strategy");
    }
}
