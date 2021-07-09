package com.example.testing.sorting.quick;

import com.example.testing.sorting.array.Sorting;
import com.example.testing.sorting.partition.OptimalPartition;
import com.example.testing.sorting.partition.Partition;

import static com.example.testing.sorting.partition.Partition.swap;

public class OptimalQuickSort  implements Sorting {

    private OptimalPartition partition = new OptimalPartition();

    @Override
    public void sort(long[] arr, int length) {
        recQuickSort(arr, 0, length - 1);
    }

    private void recQuickSort(long[] arr, int left, int right) {

        int size = right - left + 1;

        if(size <= 3) {
            manualSort(arr, left, right);
        } else {
            long median = medianOfThree(arr,left, right);
            int part = partition.parting(arr, left, right, median);
            recQuickSort(arr, left, part - 1);
            recQuickSort(arr, part + 1, right);
        }
    }


    private void manualSort(long[] arr, int left, int right) {

        int size = right - left + 1;

        if(size <= 1) {

            return;

        } else if (size == 2) {

            if(arr[left] > arr[right]) {

                swap(arr, left, right);

                return;
            }
        } else {

            swapThreeElement(arr, left, right, right - 1);

        }
    }

    private long medianOfThree(long[] arr, int left, int right) {

        int center = (left + right) / 2;

        swapThreeElement(arr, left, right, center);

        swap(arr, center, right - 1);

        return arr[right - 1];
    }



    private void swapThreeElement(long[] arr, int left, int right, int center) {

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



    @Override
    public void sortingName() {
        System.out.println("Optimal quick sort strategy");
    }
}
