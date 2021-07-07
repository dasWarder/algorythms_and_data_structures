package com.example.testing;


import com.example.testing.sorting.array.Sorting;
import com.example.testing.sorting.array.TestArray;
import com.example.testing.sorting.quick.SimpleQuickSort;

public class TestingApplication {

    public static void main(String[] args) {
            Sorting sorting = new SimpleQuickSort();
        TestArray array = new TestArray(10, sorting);
        //long[] arr = new long[] {5,2,4,1,3,12,19,9,11,7};
        array.insert(5);
        array.insert(2);
        array.insert(4);
        array.insert(1);
        array.insert(3);
        array.insert(12);
        array.insert(19);
        array.insert(9);
        array.insert(11);
        array.insert(7);

        array.sort();

        array.print();

    }

};

