package com.example.testing.list;

import com.example.testing.list.linkedList.SimpleLinkedList;

public class ListMain {

    public static void main(String[] args) {
        SimpleLinkedList linkedList = new SimpleLinkedList();

        linkedList.insertFirst(12);
        linkedList.insertFirst(25);
        linkedList.insertFirst(89);

        System.out.println("Removed: " + linkedList.remove(89));

        linkedList.printAll();
    }
}
