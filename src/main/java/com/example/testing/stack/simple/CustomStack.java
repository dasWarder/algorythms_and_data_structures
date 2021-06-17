package com.example.testing.stack.simple;

public class CustomStack {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(long element) {
        if(!isFull()) {
            stackArray[++top] = element;
        } else {
            throw new ArrayIndexOutOfBoundsException("The size of stack is max");
        }
    }

    public long pop() {
        long lastElement = stackArray[top--];

        return lastElement;
    }

    public long peek() {
        long lastElement = stackArray[top];

        return lastElement;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top >= maxSize - 1;
    }




}
