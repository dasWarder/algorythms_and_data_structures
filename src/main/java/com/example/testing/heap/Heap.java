package com.example.testing.heap;

import java.util.Arrays;

public class Heap<T extends Comparable> {

    private Node<T>[] heapArray;
    private int maxSize;
    private int currentSize = 0;

    public Heap(){
        this.heapArray = new Node[16];
        this.maxSize = 16;
        this.currentSize = 0;
    }

    public Heap(int maxSize) {
        this.heapArray = new Node[maxSize];
        this.maxSize = maxSize;
        this.currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(T key) {

        if(currentSize == maxSize) {
            return false;
        }

        Node insertNode = new Node<T>(key);
        heapArray[currentSize] = insertNode;
        trickleUp(currentSize++);

        return true;
    }

    private void trickleUp(int index) {
        //find  out a parent into bi-tree structure
        int parent = (index - 1) / 2;

        Node bottom = heapArray[index];

        while(index > 0 &&
                heapArray[parent].getData().compareTo(
                                                bottom.getData()) < 0) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }

        heapArray[index] = bottom;
    }

    public T remove() {

        Node root = heapArray[0];
        heapArray[0] = heapArray[currentSize--];
        trickleDown(0);
        return (T) root.getData();
    }

    private void trickleDown(int index) {

        int largeChild;
        Node<T> top = heapArray[index];

        while(index < currentSize/2) {

            int leftChild = 2*index + 1;
            int rightChild = leftChild + 1;

            if(rightChild < currentSize &&
                        heapArray[leftChild].getData().compareTo(
                                                    heapArray[rightChild].getData()) < 0) {
                largeChild = rightChild;
            } else {
                largeChild = leftChild;
            }

            if(top.getData().compareTo(heapArray[largeChild].getData()) >= 0) {
                break;
            }

            heapArray[index] = heapArray[largeChild];
            index = largeChild;
        }

        heapArray[index] = top;
    }

    public boolean change(int index, T value) {

        if(index < 0 || index >= currentSize) {
            return false;
        }

        T oldValue = heapArray[index].getData();
        heapArray[index].setData(value);

        if(oldValue.compareTo(value) < 0) {
            trickleUp(index);
        } else {
            trickleDown(index);
        }

        return true;
    }

    public void print() {

        int row = 1;

        for(int i = 0; i < currentSize; i++) {
            if(i == row) {
                System.out.println("\n");
                row += row;
            }
            System.out.print(heapArray[i].getData());
        }
    }


}
