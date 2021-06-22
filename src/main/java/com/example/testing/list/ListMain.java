package com.example.testing.list;

import com.example.testing.list.linkedList.SortInsertionList;

import java.util.Arrays;

public class ListMain {

    public static void main(String[] args) {

        SortInsertionList<Long> sortedList = new SortInsertionList<>();

        sortedList.insert(25L);
        sortedList.insert(13L);
        sortedList.insert(44L);
        sortedList.insert(7L);
        sortedList.insert(82L);

        sortedList.printAll();

        System.out.println("Get indexOf: " + sortedList.indexOf(25L));
        System.out.println("<---------------------------------------->");

        Long[] arr = {24L, 25L, 17L, 88L, 19L, 2L};

        System.out.println(
                            Arrays.toString(arr));

        SortInsertionList<Long> list = new SortInsertionList<>(arr);
        System.out.println("<---------------------------------------->");

        list.printAll();

        for(int i = 0; i < arr.length; i++) {
            arr[i] = list.remove();
        }

        list.printAll();

        System.out.println("<---------------------------------------->");
        System.out.println(
                            Arrays.toString(arr));

    }
}
