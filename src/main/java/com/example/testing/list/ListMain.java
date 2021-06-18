package com.example.testing.list;

import com.example.testing.list.linkedList.DoublyLinkedList;

import java.util.LinkedList;

public class ListMain {

    public static void main(String[] args) {

        DoublyLinkedList<Long> linkedList = new DoublyLinkedList<>();

        linkedList.insertHead(1L);
        linkedList.insertHead(2L);
        linkedList.insertHead(3L);

        System.out.println("Print all: ");
        linkedList.printAll();

        linkedList.insertTail(100L);
        linkedList.insertTail(101L);

        System.out.println("Print all after changing: ");
        linkedList.printAll();

        System.out.println("Index of element: " + linkedList.indexOf(1L));

        System.out.println("Removed head: " + linkedList.removeHead());
        linkedList.printAll();

        System.out.println("Removed tail: " + linkedList.removeTail());
        linkedList.printAll();



    }
}
