package com.example.testing.tree;

public interface BinaryTree<T> {

    boolean find(T key);

    void insert(T data);

    boolean delete(T data);
}
