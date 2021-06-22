package com.example.testing.iterator;

import com.example.testing.list.linkedList.DoublyLinkedList;
import com.example.testing.list.linkedList.link.Link;
import lombok.Data;

public class ListIterator<T, E extends DoublyLinkedList> {

    private Link current;

    private Link previous;

    private E list;

    public void reset() {

        current = list.getFirst();
        previous = null;
    }

    public void nextLink() {
        previous = current;
        current = current.getNext();
    }
}
