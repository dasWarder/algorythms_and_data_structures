package com.example.testing;

import com.example.testing.sorting.Sorting;
import com.example.testing.sorting.TestArray;
import com.example.testing.sorting.bubble.BubbleSort;
import com.example.testing.sorting.insertion.InsertionSort;
import com.example.testing.sorting.oddEven.OddEvenSort;
import com.example.testing.sorting.selection.SelectionSort;



public class TestingApplication {

    public static void main(String[] args) {
        Sorting sort = new OddEvenSort();

        TestArray testArray = new TestArray(5, sort);

        testArray.insert(54);
        testArray.insert(23);
        testArray.insert(57);
        testArray.insert(25);
        testArray.insert(7);

        testArray.getSortingStrategyName();
        testArray.print();
    }

};

