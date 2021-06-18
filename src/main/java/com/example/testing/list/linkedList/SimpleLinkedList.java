package com.example.testing.list.linkedList;

import lombok.AllArgsConstructor;
import lombok.Data;


public class SimpleLinkedList {

    @Data
    @AllArgsConstructor
    private class Link {

        private long value;

        private Link next;
    }

    private Link head;

    private int length;

    public void insertFirst(long element) {

        Link newElement = new Link(element, head);
        head = newElement;
        length++;

    }

    public long find(int index) {

        Link temp = head;

        if(index < length) {

            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }

            return temp.getValue();
        }

        return -1;
    }

    public long removeFirst() {

        if(!isEmpty()) {

            long removedValue = head.getValue();
            head = head.getNext();
            length--;

            return removedValue;
        }

        return -1;
    }

    public long remove(long value) {
        Link temp = head;
        Link prev = null;

        if(!isEmpty()) {

            while (temp != null) {

                if (checkEqualsToElement(temp, prev, value)) {

                    return temp.getValue();
                }

                prev = temp;
                temp = temp.getNext();
            }

            length--;

            return -1;
        }

        return -1;
    }

    public void printAll() {

        Link temp = head;

        while(temp != null) {

            System.out.println(temp.getValue());
            temp = temp.getNext();
            
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return length;
    }



    private boolean checkEqualsToElement(Link currentElement, Link prevElement, long value) {

        if(currentElement.getValue() == value) {

            setLinksToRemoveElement(currentElement, prevElement);

            return true;
        }

        return false;
    }

    private void setLinksToRemoveElement(Link current, Link prev) {

        if(prev == null) {

            head = current.getNext();

        } else {

            prev.setNext(current.getNext());

        }
    }

}
