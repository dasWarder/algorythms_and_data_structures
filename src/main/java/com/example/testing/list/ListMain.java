package com.example.testing.list;

import com.example.testing.iterator.ListIterator;
import com.example.testing.list.linkedList.DoublyLinkedList;

public class ListMain {

    public static void main(String[] args) {
        DoublyLinkedList<Long> list = new DoublyLinkedList<>();

        list.insertHead(4L);
        list.insertHead(3L);
        list.insertHead(2L);

        list.printAllBackward();

        System.out.println("<---------------------------------------->");

        ListIterator<Long, DoublyLinkedList<Long>> iterator = list.getListIterator();

        ListIterator<Long, DoublyLinkedList<Long>> secondIterator = list.getListIterator();


        iterator.nextLink();
        System.out.println(iterator.getCurrent());

        System.out.println(secondIterator.getCurrent());


    }
}
