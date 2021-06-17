package com.example.testing.sorting.array;

import com.example.testing.sorting.TestArray;
import com.example.testing.sorting.oddEven.OddEvenSort;

public class MainSort {

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
}
