package com.example.testing.tree;

import java.util.TreeMap;

public class SimpleBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    private Node<T> root;

    private TreeMap map = new TreeMap();

    private TreeTraversal<T> treeTraversal;

    public SimpleBinaryTree(TreeTraversal<T> treeTraversal) {
        this.treeTraversal = treeTraversal;
    }

    @Override
    public boolean find(T key) {

        boolean elementFound = recursionFindElement(key, root);

        return elementFound;
    }


    @Override
    public void insert(T data) {

        if (root == null) {

            root = new Node<>();
            root.setData(data);

        } else {

            Node<T> child = new Node<>();
            child.setData(data);

            Node<T> temp = getLastNode(data);

            if(temp.getData().compareTo(data) >= 0) {

                temp.setLeftNode(child);

            } else {

                temp.setRightNode(child);

            }

        }
    }

    @Override
    public void delete(T data) {

    }

    public void printAll() {

        treeTraversal.treeTraversal(root);
        
    }


    private boolean recursionFindElement(T key, Node<T> node) {

        if(node == null) {
            return false;
        }

        if (node.getData().compareTo(key) == 0) {
            return true;
        }


        return recursionFindElement(key, node.getLeftNode()) | recursionFindElement(key, node.getRightNode());
    }

    private Node<T> getLastNode(T data) {

        Node<T> temp = root;

        while(temp != null) {

            int comparingRes = temp.getData().compareTo(data);

            if(comparingRes >= 0 && temp.getLeftNode() != null) {

                temp = temp.getLeftNode();

            } else if (comparingRes < 0 && temp.getRightNode() != null) {

                temp = temp.getRightNode();

            } else {

                break;
            }
        }

        return temp;
    }
}