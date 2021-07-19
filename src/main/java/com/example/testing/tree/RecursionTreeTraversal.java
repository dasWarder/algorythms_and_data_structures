package com.example.testing.tree;

public class RecursionTreeTraversal<T> implements TreeTraversal<T> {

    @Override
    public void treeTraversal(Node<T> root) {
        recursionTraversal(root);
    }


    private void recursionTraversal(Node<T> node) {

        if(node == null) {
            return;
        }

        recursionTraversal(node.getLeftNode());

        System.out.println(node.getData());

        recursionTraversal(node.getRightNode());
    }
}
