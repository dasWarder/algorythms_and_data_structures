package com.example.testing;


import com.example.testing.tree.RecursionTreeTraversal;
import com.example.testing.tree.SimpleBinaryTree;
import com.example.testing.tree.TreeTraversal;

public class TestingApplication {

    public static void main(String[] args) {
        TreeTraversal<Long> traversalStrategy = new RecursionTreeTraversal<>();
        SimpleBinaryTree<Long> tree = new SimpleBinaryTree<>(traversalStrategy);

        tree.insert(12L);
        tree.insert(22L);
        tree.insert(2L);
        tree.insert(19L);
        tree.insert(3L);
        tree.insert(1L);


        System.out.println(tree.find(12L));
        System.out.println(tree.delete(2L));
        tree.printAll();
    }

};

