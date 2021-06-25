package com.example.testing.iterator;

import com.example.testing.list.linkedList.DoublyLinkedList;
import com.example.testing.list.linkedList.link.Link;
import lombok.Data;

public class ListIterator<T, E extends DoublyLinkedList> {

    private Link current;

    private Link previous;

    private E list;

    public ListIterator(E linkToTheList) {
        this.list = linkToTheList;
        reset();
    }

    public void reset() {

        current = list.getFirst();
        previous = null;
    }

    public void nextLink() {
        previous = current;
        current = current.getNext();
    }

    public boolean atEnd() {
        return current.getNext() == null;
    }

    public T getCurrent() {
        return (T) current.getValue();
    }

    public void insertAfterCurrent(T element) {

        Link insertLink = new Link(element);

        if (list.isEmpty()) {

            list.setHead(insertLink);
            current = insertLink;

        } else {

            insertLink.setNext(current.getNext());
            current.setNext(insertLink);
            nextLink();

        }
    }

    public void insertBeforeCurrent(T element) {

        Link insertLink = new Link(element);

        if (previous == null) {

            insertLink.setNext(list.getFirst());
            list.setHead(insertLink);
            reset();
        } else {

            insertLink.setNext(previous.getNext());
            previous.setNext(insertLink);
            current = insertLink;

        }
    }

    public T deleteCurrent() {

        T value = (T) current.getValue();

        if (previous == null) {

            list.setHead(current.getNext());
            reset();

        } else {

            previous.setNext(current.getNext());

            if(atEnd()) {

                reset();

            } else {

                current = current.getNext();
            }
        }

        return value;
    }

    public boolean isEnd() {
        return current == null;
    }
}
