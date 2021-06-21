package com.example.testing.list;

import com.example.testing.list.linkedList.SortedLinkedList;

public class ListMain {

    public static void main(String[] args) {

        SortedLinkedList<Long> sortedList = new SortedLinkedList<>();

        sortedList.insert(25L);
        sortedList.insert(12L);
        sortedList.insert(35L);
        sortedList.insert(15L);

        sortedList.printAll();

        sortedList.remove(25L);

        sortedList.printAll();
    }
}
