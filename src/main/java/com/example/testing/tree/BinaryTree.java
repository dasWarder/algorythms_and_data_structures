package com.example.testing.tree;

public interface BinaryTree<T> {

    boolean find(T key);

    void insert(T data);

    void delete(T data);
}
