package com.example.testing.sorting.shell;

import com.example.testing.sorting.array.Sorting;

public class ShellsSort implements Sorting {


    @Override
    public void sort(long[] arr, int length) {
        doShellSort(arr, length);
    }

    private void doShellSort(long[] arr, int length) {

        int h = 1;

        while(h <= length/3) {
            h = h * 3 + 1;
        }
        //12,2,19,4,7,9,10,11,22,1
        while(h > 0) {

            for(int outer = h; outer < length; outer++) {

                long temp = arr[outer];
                int inner = outer;

                while(inner > h - 1 && arr[inner - h] >= temp) {

                    arr[inner] = arr[inner - h];
                    inner -= h;
                }

                arr[inner] = temp;
            }

            h = (h - 1) / 3;
        }

    }




    @Override
    public void sortingName() {
        System.out.println("Shell's sorting strategy");
    }
}
