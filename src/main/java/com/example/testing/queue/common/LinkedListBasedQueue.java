package com.example.testing.queue.common;

import com.example.testing.list.linkedList.DoublyLinkedList;

public class LinkedListBasedQueue<T> {

    private DoublyLinkedList<T> linkedList;

    private int length;

    public LinkedListBasedQueue() {
        this.linkedList = new DoublyLinkedList<>();
        this.length = 0;
    }

    public void push(T element) {

        linkedList.insertTail(element);
        length++;
    }

    public T pop() {

        if(!isEmpty()) {

            T removedElement = linkedList.removeHead();
            length--;

            return removedElement;
        }

        return null;
    }

    public T peek() {

        return linkedList.getHead();

    }

    public boolean isEmpty() {

        return length == 0;

    }

    public int size() {
        return length;
    }
}
