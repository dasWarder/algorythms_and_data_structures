package com.example.testing.list;

import com.example.testing.list.linkedList.DoublyLinkedList;

public class ListMain {

    public static void main(String[] args) {
        DoublyLinkedList<Long> list = new DoublyLinkedList<>();

        list.insertHead(4L);
        list.insertHead(3L);
        list.insertHead(2L);

        list.printAllBackward();

        System.out.println("<---------------------------------------->");

        list.insertAfter(12L, 4L);

        list.printAll();

        System.out.println("<---------------------------------------->");

        System.out.println("Removed: " + list.remove(4L));

        list.printAllBackward();



    }
}
