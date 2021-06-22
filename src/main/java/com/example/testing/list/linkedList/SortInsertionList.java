package com.example.testing.list.linkedList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SortInsertionList<T extends Comparable> {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
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

    public SortInsertionList() {

    }

    public SortInsertionList(T[] initArray) {

        for(int i = 0; i < initArray.length; i++) {

            insert(initArray[i]);

        }
    }

    /**
     * Insert element into linked list. The mechanism of work is next:
     * 1) if the element the first, just add it into list and make head and tail bew equals to it
     * 2) if the element not the first, then need to iterate the list and find the position for inserting
     * 3) if inserting position is first (prev == null), then it will be a new head, if last (next == null),
     * then it will be a new tail.
     * 4) we must to set up a new links, i.e. if an element is a new first element, old head must be a next element for it
     * @param element an inserting element
     */
    public void insert(T element) {
        Link newLink = new Link(element);
        Link prev = null;
        Link next = head;

        if(isEmpty()) {

            head = newLink;
            tail = newLink;

        }

        while(next != null &&
                             element.compareTo(next.getValue()) >= 1) {

            prev = next;
            next = next.getNext();
        }

        settingNewLink(prev, next, newLink);

        length++;
    }

    /**
     * Remove element by its value
     * @param element Link.getValue that must be removed
     */
    public void remove(T element) {

        Link prev = null;
        Link next = head;

        while(next != null &&
                             !element.equals(next.getValue())) {
            prev = next;
            next = next.getNext();
        }

        settingNewLink(prev, next);
        length--;
    }

    /**
     * Remove a first element of this sorted list
     * @return value of the first link element and remove it
     */
    public T remove() {

        Link temp = head;
        head = head.getNext();

        return temp.getValue();
    }

    public int indexOf(T element) {

        int counter = 0;

        for(Link temp = head; temp != null; temp = temp.getNext()) {

            if(temp.getValue().equals(element)) {
                return counter;
            }

            counter++;
        }

        return -1;
    }

    public void printAll() {
        System.out.println("Print all elements: ");
        for(Link temp = head; temp != null; temp = temp.getNext()) {
            System.out.println(temp.getValue());
        }
    }

    public T getHead() {
        return head.getValue();
    }

    public T getTail() {
        return tail.getValue();
    }

    public boolean isEmpty() {
        return length == 0;
    }

    private void settingNewLink(Link prev, Link next, Link newLink) {

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

    private void settingNewLink(Link prev, Link next) {

        if(prev == null && next != null) {

            head = next.getNext();

        } else if(prev != null && next != null){

            prev.setNext(next.getNext());

        }

        if(next == null) {

            tail = prev;

        }

    }
}
