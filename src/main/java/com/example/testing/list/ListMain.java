package com.example.testing.list;

import com.example.testing.iterator.CustomIterator;
import com.example.testing.iterator.ListIterator;
import com.example.testing.list.linkedList.DoublyLinkedList;

import java.util.Iterator;

public class ListMain {

    public static void main(String[] args) {
        DoublyLinkedList<Long> list = new DoublyLinkedList<>();

        list.insertHead(4L);
        list.insertHead(3L);
        list.insertHead(2L);

        list.printAllBackward();

        System.out.println("<---------------------------------------->");

        CustomIterator<Long> listIterator = list.getListIterator();

        CustomIterator<Long> secondIterator = list.getListIterator();


        if (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println("<---------------------------------------->");

        while (secondIterator.hasNext()) {

            System.out.println(secondIterator.next());
        }

    }
}
