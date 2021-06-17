package com.example.testing.sorting;

import com.example.testing.sorting.array.Sorting;

import java.util.Arrays;


public class TestArray {

    private long[] arr;
    private int length;
    private Sorting sorting;

    public TestArray(int max, Sorting sort) {
        this.sorting = sort;
        this.arr = new long[max];
        length = 0;
    }

    public void insert(long element) {
        arr[length] = element;
        length++;
        sort();
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }

    public void sort() {
        sorting.sort(arr, length);
    }

    public int find(long elementToSearch) {
        int start = 0;
        int end = length - 1;
        int mid;

        while(start <= end) {
            mid = (start + end) / 2;

            if(arr[mid] == elementToSearch) {
                return mid;
            }

            end = arr[mid] > elementToSearch? mid - 1 : end;
            start = arr[mid] < elementToSearch? mid + 1 : start;
        }

        return -1;
    }

    public void delete(long elementToDelete) {
        int index = find(elementToDelete);

        if(index == -1) {
            System.out.println("This element doesn't exist");
            return;
        }

        for(int i = index; i < length; i++) {
            if(i < length - 1) {
                arr[i] = arr[i + 1];
            }
        }

        arr[length - 1] = 0;
        length--;
    }

    public void setSorting(Sorting sorting) {
        this.sorting = sorting;
    }

    public void getSortingStrategyName() {
        sorting.sortingName();
    }
}
