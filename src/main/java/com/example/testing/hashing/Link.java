package com.example.testing.hashing;

public class Link<T> {

    private T data;

    private Link next;

    public Link(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}
