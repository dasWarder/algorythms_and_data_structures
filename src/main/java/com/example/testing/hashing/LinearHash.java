package com.example.testing.hashing;

import java.util.Arrays;

public class LinearHash implements Hashable<Integer> {

    private Item[] hashArray = new Item[16];
    private long size = hashArray.length;
    private long length = 0;
    private int capacity = (this.hashArray.length / 3) * 2;
    private Item deleteItem = new Item(null);

    public LinearHash() {
    }

    public LinearHash(int size) {
        this.hashArray = new Item[size];
        this.size = this.hashArray.length;
        this.capacity = (this.hashArray.length / 3) * 2;
    }

    public void insert(Integer element) {

        if(length >= capacity) {
            updateHashArray();
        }

        int hash = calculateHash(element);
        Item newItem = new Item(element);

        while(hashArray[hash] != null
                            && hashArray[hash].getKey() != null) {

            if(hashArray[hash].getKey() == element || hashArray[hash].getKey() == null) {
                hashArray[hash] = newItem;
                return;
            }
            ++hash;
            hash %= size;
        }

        hashArray[hash] = newItem;
        length++;
    }

    public boolean find(Integer element) {

        int hash = calculateHash(element);

        while(hashArray[hash] != null) {

            if(hashArray[hash].getKey() == element) {
                return true;
            }
            ++hash;
            hash %= size;
        }

        return false;
    }

    public void delete(Integer element) {

        int hash = calculateHash(element);

        while(hashArray[hash] != null) {

            Item hashElement = hashArray[hash];

            if(hashElement.getKey() == element) {
                hashArray[hash] = deleteItem;
            }
            ++hash;
            hash %= size;
        }
    }

    public void printTable() {

        Arrays.stream(hashArray)
                .filter(el -> el != null && el.getKey() != null)
                .forEach(el -> System.out.println(el.getKey()));
    }

    private int calculateHash(Integer key) {
        key = ((key >> 16) ^ key) * 0x45d9f3b;
        key = ((key >> 16) ^ key) * 0x45d9f3b;
        key = (key >> 16) ^ key;

        return (int) (key % size);
    }

    private void updateHashArray() {

        Item[] updatedArray = new Item[(hashArray.length * 2) + 1];
        System.arraycopy(hashArray, 0, updatedArray, 0, hashArray.length);

        hashArray = updatedArray;
        capacity = (hashArray.length / 3) * 2;
        size = hashArray.length;
    }



}
