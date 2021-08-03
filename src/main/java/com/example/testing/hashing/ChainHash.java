package com.example.testing.hashing;

import java.util.Arrays;

public class ChainHash<T extends Comparable> implements Hashable<T> {

    private SortedList<T>[] hashArray;
    private int size;
    private int length = 0;

    public ChainHash(int size) {
        this.hashArray = new SortedList[size];
        this.size = size;
        for(int i = 0; i < size; i++) {
            hashArray[i] = new SortedList<>();
        }
    }

    public ChainHash() {
        this.hashArray = new SortedList[16];
        this.size = 16;
        for(int i = 0; i < size; i++) {
            hashArray[i] = new SortedList<>();
        }
    }

    @Override
    public void insert(T element) {

        int hash = hash(element);
        hashArray[hash].insert(element);
    }

    @Override
    public boolean find(T element) {

        int hash = hash(element);
        T result = hashArray[hash].find(element);

        return result != null;
    }

    @Override
    public void delete(T element) {
        int hash = hash(element);
        hashArray[hash].delete(element);
    }

    @Override
    public void printTable() {
        Arrays.stream(hashArray)
                .filter(el -> el != null)
                .forEach(el -> el.printList());
    }

    private int hash(T key) {
        int i = key.hashCode() % size;

        return i;
    }
}
