package com.example.testing.list.linkedList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DoublyLinkedList<T> {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class Link<T> {

        private T value;

        private Link<T> prev;

        private Link<T> next;

        public Link(T value) {
            this.value = value;
        }
    }

    private Link<T> head;

    private Link<T> tail;

    private int length;

    public int indexOf(T element) {

        int index = length;

        for(Link<T> temp = tail; temp != null; temp = temp.getPrev()) {
            index--;
            if(temp.getValue().equals(element)) {
                return index;
            }
        }

        return -1;
    }

    public void insertHead(T element) {

        Link<T> newHead = new Link<T>(element);
        newHead.setNext(head);

        if (isEmpty()) {
            tail = newHead;
        } else {
            head.setPrev(newHead);
        }

        head = newHead;
        length++;
    }

    public void insertTail(T element) {

        Link<T> newTail = new Link<>(element);

        newTail.setPrev(tail);

        if(isEmpty()) {

            head = newTail;

        } else {

            tail.setNext(newTail);

        }

        tail = newTail;
        length++;
    }

    public T removeHead() {

        Link<T> nextLink = head.getNext();

        T removedValue = validationAndNullingLinks(nextLink, head);
        head = nextLink;

        length--;

        return removedValue;
    }

    public T removeTail() {

        Link<T> prevLink = tail.getPrev();

        T removedValue = validationAndNullingLinks(prevLink, tail);

        prevLink.setNext(null);
        tail = prevLink;

        length--;

        return removedValue;
    }

    public void printAll() {

        for(Link<T> temp = head; temp != null; temp = temp.getNext()){

            System.out.println(temp.getValue());

        }

    }

    public void printAllBackward() {

        for(Link<T> temp = tail; temp != null; temp = temp.getPrev()) {

            System.out.println(temp.getValue());
        }
    }

    public boolean isEmpty() {

        return head == null;
    }

    public int size() {
        return length;
    }

    private T validationAndNullingLinks(Link<T> newLink, Link oldLink) {

        if(!isEmpty()) {

            T value = (T) oldLink.getValue();

            if (tail == head) {

                tail = null;
                head = null;

            } else {
                oldLink.setNext(null);
                oldLink.setPrev(null);
                oldLink.setValue(null);
            }

            return value;

        }

        return null;
    }

    public T getHead() {

        return head == null?
                            null :
                            head.getValue();
    }

    public T getTail() {

        return tail == null?
                            null :
                            tail.getValue();
    }
}
