package com.example.testing.hashing;

public interface Hashable<T> {

    void insert(T element);

    boolean find(T element);

    void delete(T element);

    void printTable();
}
