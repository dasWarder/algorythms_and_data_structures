package com.example.testing.hashing;

import java.util.Arrays;

public class DoubleHash implements Hashable<Integer> {

    private Item[] hashArray = new Item[16];
    private long size = hashArray.length;
    private long length = 0;
    private int capacity = (hashArray.length / 3) * 2;
    private Item deleteItem = new Item(null);

    public DoubleHash() {

    }

    public DoubleHash(int size) {
        this.hashArray = new Item[size];
        this.size = this.hashArray.length;
        this.capacity = (this.hashArray.length / 3) * 2;
    }

    @Override
    public void insert(Integer element) {
        if(length > capacity) {
            updateHashArray();
        }

        int firstHashing = calculateFirstHash(element);
        int secondHashing = calculateSecondHash(element);
        Item newItem = new Item(element);

        while(hashArray[firstHashing] != null
                && hashArray[firstHashing].getKey() != null) {

            if(hashArray[firstHashing].getKey() == element || hashArray[firstHashing].getKey() == null) {
                hashArray[firstHashing] = newItem;
                return;
            }
            firstHashing += secondHashing;
            firstHashing %= size;
        }

        hashArray[firstHashing] = newItem;
        length++;
    }

    @Override
    public boolean find(Integer element) {

        int hash = calculateFirstHash(element);
        int secondHash = calculateSecondHash(element);

        while(hashArray[hash] != null) {

            if(hashArray[hash].getKey() == element) {
                return true;
            }
            hash += secondHash;
            hash %= size;
        }

        return false;

    }

    @Override
    public void delete(Integer element) {

        int hash = calculateFirstHash(element);
        int secondHash = calculateSecondHash(element);

        while(hashArray[hash] != null) {

            Item hashElement = hashArray[hash];

            if(hashElement.getKey() == element) {
                hashArray[hash] = deleteItem;
            }

            hash += secondHash;
            hash %= size;
        }
    }

    @Override
    public void printTable() {

        Arrays.stream(hashArray).filter(el -> el != null && el.getKey() != null)
                .forEach(el -> System.out.println(el.getKey()));
    }

    private int calculateFirstHash(Integer key) {
        key = ((key >> 16) ^ key) * 0x45d9f3b;
        key = ((key >> 16) ^ key) * 0x45d9f3b;
        key = (key >> 16) ^ key;

        return (int) (key % size);
    }

    private int calculateSecondHash(Integer key) {

        return 5 - key % 5;
    }

    private void updateHashArray() {

        Item[] updatedArray = new Item[(hashArray.length * 2) + 1];
        System.arraycopy(hashArray, 0, updatedArray, 0, hashArray.length);

        hashArray = updatedArray;
        capacity = (hashArray.length / 3) * 2;
        size = hashArray.length;
    }
}
