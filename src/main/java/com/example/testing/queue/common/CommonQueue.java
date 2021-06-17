package com.example.testing.queue.common;

public class CommonQueue {
    private int maxSize;
    private long[] queueArray;
    private int length;
    private int receiveIndex;
    private int insertIndex;

    public CommonQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new long[maxSize];
        length = 0;
        receiveIndex = 0;
        insertIndex = -1;
    }

    public void insert(long element) {

        if(isFull()) {
            throw new IndexOutOfBoundsException("The max size of the queue is reached");
        }

        if(insertIndex >= maxSize - 1) {

            insertIndex = -1;
        }

        queueArray[++insertIndex] = element;
        length++;
    }


    public long remove() {

        if(isEmpty()) {

            throw new NullPointerException("The queue is empty");
        }

        long elementToDelete = queueArray[receiveIndex];
        queueArray[receiveIndex] = 0;
        receiveIndex++;
        length--;

        if(receiveIndex >= maxSize) {

            receiveIndex = 0;
        }

        return elementToDelete;
    }


    public long peek() {

        long theEldestElement = queueArray[receiveIndex];

        return theEldestElement;
    }


    public boolean isEmpty() {

        return length == 0;
    }


    public boolean isFull() {

        return length == maxSize;
    }

    public int size() {

        return length;
    }
}
