package com.example.testing.list.linkedList;

import lombok.Data;

public class SortedLinkedList<T extends Comparable<? super T>> {

    @Data
    private class Link {

        private T value;

        private Link next;

        public Link(T value) {
            this.value = value;
        }
    }

    private Link head;

    private Link tail;

    private int length;


    public void insert(T element) {

        Link newLink = new Link(element);
        Link prev = null;
        Link next = head;


        if(isEmpty()) {

            head = newLink;
            tail = newLink;

        }

        while(next != null &&
                            element.compareTo(next.getValue()) > 0) {

            prev = next;
            next = next.getNext();
        }

        settingNewLinks(newLink, prev, next);

        length++;

    }

    public void remove(T element) {

        Link prev = null;
        Link temp = head;

        while(temp != null &&
                            !(temp.getValue().equals(element))) {
            prev = temp;
            temp = temp.getNext();
        }

        prev.setNext(temp.getNext());
        temp.setValue(null);
        temp.setNext(null);
    }

    public void printAll() {
        Link tempElement = head;

        while(tempElement != null) {
            System.out.println(tempElement.getValue());
            tempElement = tempElement.getNext();
        }
    }

    public boolean isEmpty() {
        return length == 0;
    }

    private void settingNewLinks(Link newLink, Link prev, Link next) {

        if(prev == null) {

            head = newLink;

        } else {

            prev.setNext(newLink);

        }

        if(next == null) {

            tail = newLink;

        }

        newLink.setNext(next);
    }

}
