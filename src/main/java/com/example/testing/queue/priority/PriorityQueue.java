package com.example.testing.queue.priority;

import com.example.testing.queue.CustomQueue;

public class PriorityQueue implements CustomQueue<Long> {
    private int maxSize;
    private long[] priorityQueueArray;
    private int length;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        priorityQueueArray = new long[maxSize];
        length = 0;
    }


    @Override
    public void push(Long element) {

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

    @Override
    public Long pop() {

        long element = priorityQueueArray[--length];
        priorityQueueArray[length] = 0;

        return element;
    }

    @Override
    public Long peek() {

        return priorityQueueArray[length - 1];
    }

    @Override
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
