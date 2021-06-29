package com.example.testing.list.linkedList;

import com.example.testing.iterator.CustomIterator;
import com.example.testing.iterator.CustomListIterator;
import com.example.testing.list.linkedList.link.Link;
import lombok.Setter;

public class DoublyLinkedList<T> {

    @Setter
    private Link<T> head;

    @Setter
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

    public void insertAfter(T element, T elementToInsertAfter) {


        Link<T> next = head;

        while (next != null &&
                                !next.getValue().equals(elementToInsertAfter)) {
            next = next.getNext();
        }

        Link<T> insertLink = new Link<>(element);

        settingUpLinksForInserting(next, insertLink);
    }

    public T removeHead() {

        Link<T> temp = head;
        Link<T> nextLink = temp.getNext();

        T removedValue = validationAndNullingLinks(temp);
        head = nextLink;

        length--;

        return removedValue;
    }

    public T removeTail() {

        Link<T> prevLink = tail.getPrev();



        T removedValue = validationAndNullingLinks(tail);

        if(prevLink != null) {

            prevLink.setNext(null);
        }

        tail = prevLink;

        length--;

        return removedValue;
    }

    public T remove(T element) {

        Link<T> prev = null;
        Link<T> temp = head;

        while (temp != null &&
                                !temp.getValue().equals(element)) {
            prev = temp;
            temp = temp.getNext();
        }

        Link<T> nextAfterCurrent = temp.getNext();
        length--;

        if (prev == null) {

            return removeHead();

        } else if (nextAfterCurrent == null) {

            return removeTail();

        } else {

            prev.setNext(nextAfterCurrent);
            nextAfterCurrent.setPrev(prev);
            T value = validationAndNullingLinks(temp);

            return value;
        }
    }

    public void printAll() {
        print(head);
    }

    public void printAllBackward() {
        print(tail);
    }

    public boolean isEmpty() {

        return head == null;
    }

    public int size() {
        return length;
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

    public Link<T> getFirst() {
        return head;
    }

    public Link<T> getLast() {
        return tail;
    }



    private T validationAndNullingLinks(Link oldLink) {

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

    private void settingUpLinksForInserting(Link<T> next, Link<T> insertLink) {

        if(next == tail) {

            insertLink.setNext(null);
            tail = insertLink;

        } else {

            Link<T> nextAfterCurrent = next.getNext();
            insertLink.setNext(nextAfterCurrent);
            nextAfterCurrent.setPrev(insertLink);

        }

        insertLink.setPrev(next);
        next.setNext(insertLink);
    }

    private void print(Link<T> direction) {

        Link temp = direction;

        while (temp != null &&
                              temp.getValue() != null) {

            System.out.println(temp.getValue());

            Link nextElement = setNextElementByDirection(temp, direction);

            temp = nextElement;
        }
    }

    private Link<T> setNextElementByDirection(Link<T> temp, Link<T> direction) {

        if(direction == tail) {

            temp = temp.getPrev();

        } else if (direction == head) {

            temp = temp.getNext();

        }

        return temp;
    }

    public CustomIterator<T> getListIterator() {

        CustomIterator<T> litIterator = new CustomListIterator<>(this);

        return litIterator;
    }
}
