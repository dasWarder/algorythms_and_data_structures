package com.example.testing.queue;

public interface CustomQueue<T> {

    void push(T element);

    T pop();

    T peek();

    boolean isEmpty();
}
