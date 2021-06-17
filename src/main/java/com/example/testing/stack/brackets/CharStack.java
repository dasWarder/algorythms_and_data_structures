package com.example.testing.stack.brackets;

public class CharStack {
    private int maxSize;
    private char[] charStack;
    private int top;

    public CharStack(int maxSize) {
        this.maxSize = maxSize;
        this.charStack = new char[maxSize];
        this.top = -1;
    }

    public void push(char element) {
        if(!isFull()) {
            charStack[++top] = element;
        } else {
            throw new IndexOutOfBoundsException("The stack is full");
        }
    }

    public char pop() {
        return charStack[top--];
    }

    public char peek() {
        return charStack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top >= maxSize - 1;
    }
}
