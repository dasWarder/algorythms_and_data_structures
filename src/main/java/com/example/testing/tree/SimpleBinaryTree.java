package com.example.testing.tree;

import java.util.TreeMap;

public class SimpleBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    private Node<T> root;

    private TreeMap map = new TreeMap();

    @Override
    public boolean find(T key) {

        Node<T> temp = root;
        int compareRes = 0;

        while(temp != null) {

            compareRes = temp.getData().compareTo(key);

            if(compareRes == 0) {

                return true;

            }

            if(compareRes >= 0 && temp.getLeftNode() != null) {

                temp = temp.getLeftNode();

            } else if (compareRes < 0 && temp.getRightNode() != null) {

                temp = temp.getRightNode();

            }
        }

        return false;
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