package com.example.testing.hashing;

public class SortedList<T extends Comparable> {

    private Link<T> head;

    public void insert(T element) {

        Link prev = null;
        Link current = head;

        Link newLink = new Link(element);

        while(current != null && element.compareTo(current.getData()) > 0) {
            prev = current;
            current = current.getNext();
        }

        if(prev == null) {
            head = newLink;
        } else {
            prev.setNext(newLink);
        }

        if(current != null && element.compareTo(current.getData()) == 0) {
            Link next = current.getNext();
            current = newLink;

            if(prev != null) {
                prev.setNext(current);
            }

            current.setNext(next);
        } else {
            newLink.setNext(current);
        }


    }

    public void delete(T element) {

        Link prev = null;
        Link current = head;

        while(current != null && element.compareTo(current.getData()) != 0) {
            prev = current;
            current = current.getNext();
        }

        if(prev == null) {
            head = head.getNext();
        } else {
            prev.setNext(current.getNext());
        }
    }

    public T find(T element) {

        Link current = head;

        while(current != null && element.compareTo(current.getData()) >= 0) {

            if(element.compareTo(current.getData()) == 0) {
                return (T) current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public void printList() {

        Link current = head;

        while(current != null) {

            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
