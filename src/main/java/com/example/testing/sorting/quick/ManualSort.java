package com.example.testing.sorting.quick;

import static com.example.testing.sorting.quick.Util.swap;
import static com.example.testing.sorting.quick.Util.swapThreeElement;

public class ManualSort {


    public void manualSortWhenLessThenThree(long[] arr, int left, int right) {

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

    public void manualInsertSort(long[] arr, int left, int right) {

        for(int i = left + 1; i <= right; i++) {

            long temp = arr[i];
            int j = i;

            while(j > left
                            && arr[j - 1] >= temp) {

                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
