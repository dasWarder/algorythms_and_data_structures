package com.example.testing.list;

import com.example.testing.list.linkedList.SortedLinkedList;

public class ListMain {

    public static void main(String[] args) {

        SortedLinkedList<Long> sortedList = new SortedLinkedList<>();

        sortedList.insert(25L);
        sortedList.insert(12L);
        sortedList.insert(35L);
        sortedList.insert(15L);

        System.out.println("Get all before changing: ");
        sortedList.printAll();

        sortedList.remove(25L);

        System.out.println("Get all after changing: ");
        sortedList.printAll();

        System.out.println("Get head: " + sortedList.getHead());
        System.out.println("Get tail: " + sortedList.getTail());


    }
}
