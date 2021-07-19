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
    public boolean delete(T data) {

        if (root == null) {
            return false;
        }

        Node<T> temp = root;
        Node<T> parent = null;
        boolean left = false;

        while(temp != null && temp.getData() != data) {

            parent = temp;

            if(temp.getData().compareTo(data) > 0) {

                temp = temp.getLeftNode();
                left = true;

            } else {

                temp = temp.getRightNode();
                left = false;
            }
        }

        if(temp == null ||
                            (temp.getLeftNode() == null && temp.getRightNode() == null)) {

            setNodeForParent(null, parent, left);
            return true;

        } else if (temp.getRightNode() == null) {

            setNodeForParent(temp.getLeftNode(), parent, left);
            return true;

        } else if (temp.getLeftNode() == null) {

            setNodeForParent(temp.getRightNode(), parent, left);
            return true;

        } else {

            Node<T> successor = getSuccessor(temp);

            setNodeForParent(successor, parent, left);

            successor.setLeftNode(temp.getLeftNode());

            return true;
        }
    }

    private Node getSuccessor(Node<T> delNode) {

        Node<T> successorParent = delNode;
        Node<T> successor = delNode;
        Node<T> current = delNode.getRightNode();

        while(current != null) {

            successorParent = successor;
            successor = current;
            current = current.getLeftNode();
        }

        if(successor != delNode.getRightNode()) {
            successorParent.setLeftNode(successor.getRightNode());
            successor.setRightNode(delNode.getRightNode());
        }

        return successor;
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

    private void setNodeForParent(Node<T> node, Node<T> parent, boolean left) {

        if(node == root) {

            root = node;

        } else if (left) {

            parent.setLeftNode(node);
        } else {

            parent.setRightNode(node);
        }
    }
}