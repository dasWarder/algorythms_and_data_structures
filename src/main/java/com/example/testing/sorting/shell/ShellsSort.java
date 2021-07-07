package com.example.testing.sorting.shell;

import com.example.testing.sorting.array.Sorting;

public class ShellsSort implements Sorting {


    @Override
    public void sort(long[] arr, int length) {
        doShellSort(arr, length);
    }

    private void doShellSort(long[] arr, int length) {

        int h = 1;

        while( h < length / 3) {
            h = h * 3 + 1;
        }

        for(int i = h; i < arr.length; i++) {
            long temp = arr[i];
            int j = i;

            while(j >= h && arr[j - h] >= temp) {

                arr[j] = arr[j - h];
                j -= h;
            }

            arr[j] = temp;
        }

        h = (h - 1) / 3;
    }



    @Override
    public void sortingName() {
        System.out.println("Shell's sorting strategy");
    }




}
