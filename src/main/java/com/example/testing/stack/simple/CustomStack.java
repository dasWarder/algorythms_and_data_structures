package com.example.testing.stack.simple;

import com.example.testing.queue.CustomQueue;

public class CustomStack implements CustomQueue<Long> {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new long[maxSize];
        top = -1;
    }

    @Override
    public void push(Long element) {
        if(!isFull()) {
            stackArray[++top] = element;
        } else {
            throw new ArrayIndexOutOfBoundsException("The size of stack is max");
        }
    }

    @Override
    public Long pop() {
        long lastElement = stackArray[top--];

        return lastElement;
    }

    @Override
    public Long peek() {
        long lastElement = stackArray[top];

        return lastElement;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top >= maxSize - 1;
    }




}
