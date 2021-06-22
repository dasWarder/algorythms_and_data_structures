package com.example.testing.list;

import com.example.testing.list.linkedList.DoublyLinkedList;

public class ListMain {

    public static void main(String[] args) {
        DoublyLinkedList<Long> list = new DoublyLinkedList<>();

        list.insertHead(12L);
        list.insertHead(22L);
        list.insertTail(4L);
        list.insertHead(84L);
        list.insertHead(2L);

        list.printAll();

        System.out.println("<---------------------------------------->");

        list.printAllBackward();

    }
}
