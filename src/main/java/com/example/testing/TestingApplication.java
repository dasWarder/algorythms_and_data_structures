package com.example.testing;

import com.example.testing.sorting.Sorting;
import com.example.testing.sorting.TestArray;
import com.example.testing.sorting.bubble.BubbleSort;
import com.example.testing.sorting.selection.SelectionSort;



public class TestingApplication {

    public static void main(String[] args) {
        Sorting bubbleSort = new BubbleSort();

        TestArray testArray = new TestArray(6, bubbleSort);

        testArray.insert(54);
        testArray.insert(23);
        testArray.insert(57);
        testArray.insert(25);
        testArray.insert(7);

        testArray.getSortingStrategyName();
        testArray.print();

        testArray.setSorting(new SelectionSort());
        testArray.getSortingStrategyName();
        testArray.insert(17);
        testArray.print();
    }

};

