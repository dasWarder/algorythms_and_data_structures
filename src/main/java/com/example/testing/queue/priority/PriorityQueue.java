package com.example.testing.queue.priority;

import java.util.Arrays;
import java.util.Comparator;

public class PriorityQueue {
    private int maxSize;
    private long[] priorityQueueArray;
    private int length;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        priorityQueueArray = new long[maxSize];
        length = 0;
    }


    public void insert(long element) {

        if (isFull()) {
            throw new IndexOutOfBoundsException("The max size of array was reached");
        }

        if(length == 0) {

            priorityQueueArray[length++] = element;

        } else {

            int index = compareAndSwapElementsOfArray(element);
            priorityQueueArray[index + 1] = element;
            length++;
        }
    }

    public long popRight() {

        long element = priorityQueueArray[--length];
        priorityQueueArray[length] = 0;

        return element;
    }


    public long peekRight() {

        return priorityQueueArray[length - 1];
    }


    public boolean isEmpty() {

        return length == 0;
    }


    public boolean isFull() {

        return length >= maxSize;
    }

    public int size() {

        return length;
    }


    private int compareAndSwapElementsOfArray(long element) {

        int index = 0;

        for(index = length - 1; index >= 0; index--) {

            if(element > priorityQueueArray[index]) {

                priorityQueueArray[index + 1] = priorityQueueArray[index];

            } else {

                break;

            }
        }
        
        return index;
    }

}
