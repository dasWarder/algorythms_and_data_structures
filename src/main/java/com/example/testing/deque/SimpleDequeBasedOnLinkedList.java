package com.example.testing.deque;

import com.example.testing.list.linkedList.DoublyLinkedList;

import java.util.NoSuchElementException;

public class SimpleDequeBasedOnLinkedList<T extends Comparable> {

    private DoublyLinkedList<T> innerLinkedList;

    private int length;

    public SimpleDequeBasedOnLinkedList() {
        innerLinkedList = new DoublyLinkedList<>();
        length = 0;
    }

    public void addFirst(T element) {

        try {

            innerLinkedList.insertHead(element);

        } catch (Exception e) {

            throw new IllegalStateException();

        }

    }

    public void addLast(T element) {

        try {

            innerLinkedList.insertHead(element);

        } catch (Exception e) {

            throw new IllegalStateException();

        }
    }

    public void add(T element) {

        try {

            innerLinkedList.insertTail(element);

        } catch (Exception e) {

            throw new IllegalStateException();

        }
    }

    public boolean offer(T element) {

        try {

            innerLinkedList.insertTail(element);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public boolean offerFirst(T element) {

        try {

            innerLinkedList.insertHead(element);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public boolean offerLast(T element) {

        try {

            innerLinkedList.insertTail(element);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public boolean remove() {

        checkListSizeAndThrowExceptionIfEmpty();

        T t = innerLinkedList.removeTail();

        return t == null?
                         false : true;
    }

    public boolean removeFirst() {

        checkListSizeAndThrowExceptionIfEmpty();

        T t = innerLinkedList.removeHead();

        return t == null?
                         false : true;
    }

    public boolean removeLast() {

        checkListSizeAndThrowExceptionIfEmpty();

        T t = innerLinkedList.removeTail();

        return t == null?
                        false : true;
    }

    public T poll() {

        boolean isEmpty = checkListSizeAndReturnFalseIfEmpty();

        if(!isEmpty) {

            T removedElementValue = innerLinkedList.removeTail();

            return removedElementValue;
        }

        return null;
    }

    public T pollFirst() {

        boolean isEmpty = checkListSizeAndReturnFalseIfEmpty();

        if(!isEmpty) {

            T removedElementValue = innerLinkedList.removeHead();

            return removedElementValue;
        }

        return null;
    }

    public T pollLast() {

        boolean isEmpty = checkListSizeAndReturnFalseIfEmpty();

        if(!isEmpty) {

            T removedElementValue = innerLinkedList.removeTail();

            return removedElementValue;
        }

        return null;
    }

    public T peek() {
        return innerLinkedList.getTail();
    }

    public T peekFirst() {
        return innerLinkedList.getHead();
    }

    public T peekLast() {
        return innerLinkedList.getTail();
    }

    public int size() {
        return innerLinkedList.size();
    }

    private void checkListSizeAndThrowExceptionIfEmpty() {

        if(innerLinkedList.size() == 0) {

            throw new NoSuchElementException();
        }
    }

    private boolean checkListSizeAndReturnFalseIfEmpty() {

        return innerLinkedList.size() == 0;
    }
}
