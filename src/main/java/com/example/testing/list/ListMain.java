package com.example.testing.list;

public class ListMain {

    public static void main(String[] args) {
        SimpleLinkedList linkedList = new SimpleLinkedList();

        linkedList.insert(12);
        linkedList.insert(25);
        linkedList.insert(89);
        linkedList.insert(35);
        linkedList.insert(84);
        linkedList.insert(56);

        System.out.println("Initial size: " + linkedList.size());
        linkedList.printAll();

        for (int i = 0; i < 2; i++) {
            System.out.println("The element was removed: " + linkedList.remove());
        }

        System.out.println("The size after removing: " + linkedList.size());
        linkedList.printAll();
    }
}
