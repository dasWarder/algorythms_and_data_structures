package com.example.testing.queue.common;

import com.example.testing.list.linkedList.DoublyLinkedList;
import com.example.testing.queue.CustomQueue;

public class LinkedListBasedQueue<T> implements CustomQueue<T> {

    private DoublyLinkedList<T> linkedList;

    private int length;

    public LinkedListBasedQueue() {
        this.linkedList = new DoublyLinkedList<>();
        this.length = 0;
    }

    @Override
    public void push(T element) {

        linkedList.insertTail(element);
        length++;
    }

    @Override
    public T pop() {

        if(!isEmpty()) {

            T removedElement = linkedList.removeHead();
            length--;

            return removedElement;
        }

        return null;
    }

    @Override
    public T peek() {

        return linkedList.getHead();

    }

    @Override
    public boolean isEmpty() {

        return length == 0;

    }

    public int size() {
        return length;
    }
}
