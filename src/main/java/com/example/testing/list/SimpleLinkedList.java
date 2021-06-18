package com.example.testing.list;

public class SimpleLinkedList {

    private class Link {
        private long value;
        private Link next;

        public Link(long value, Link next) {
            this.value = value;
            this.next = next;
        }

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }

        public Link getNext() {
            return next;
        }

        public void setNext(Link next) {
            this.next = next;
        }
    }

    private Link head;
    private int length;

    public void insert(long element) {
        if(length == 0) {
            head = new Link(element, null);
        } else {
            Link newElement = new Link(element, head);
            head = newElement;
        }
        length++;
    }

    public long remove() {
        long removedValue = head.value;
        head = head.next;
        length--;

        return removedValue;
    }

    public void printAll() {

        Link start = head;

        while(start != null) {
            System.out.println(start.getValue());
            start = start.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return length;
    }

}
