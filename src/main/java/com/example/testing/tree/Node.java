package com.example.testing.tree;


import lombok.Data;

@Data
public class Node<T> {

    private T data;

    private Node<T> leftNode;

    private Node<T> rightNode;
}
