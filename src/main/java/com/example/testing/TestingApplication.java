package com.example.testing;


import com.example.testing.tree.SimpleBinaryTree;

public class TestingApplication {

    public static void main(String[] args) {
        SimpleBinaryTree<Long> tree = new SimpleBinaryTree<>();

        tree.insert(12L);
        tree.insert(22L);
        tree.insert(1L);
        tree.insert(19L);
        tree.insert(3L);


        System.out.println(tree.find(3L));
    }

};

