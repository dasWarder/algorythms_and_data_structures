package com.example.testing.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class SimpleGraph {
    private int maxVertex = 16;
    private Vertex[] vertexList;
    private int adjMtx[][];
    private int nVertex;

    public SimpleGraph(int maxSize) {
        this.maxVertex = maxSize;
        this.vertexList = new Vertex[maxSize];
        this.adjMtx = new int[maxSize][maxSize];
        populateAdjMatrix();
    }

    public SimpleGraph() {
        this.vertexList = new Vertex[maxVertex];
        this.adjMtx = new int[maxVertex][maxVertex];
        populateAdjMatrix();
    }

    private void populateAdjMatrix() {

        for(int out = 0; out < maxVertex; out++) {
            for(int inner = 0; inner < maxVertex; inner++) {
                adjMtx[out][inner] = 0;
            }
        }
    }

    public void addVertex(String name) {
        vertexList[nVertex++] = new Vertex(name);
    }

    public void addEdge(int start, int end) {
        adjMtx[start][end] = 1;
        adjMtx[end][start] = 1;
    }

    public void displayVertex(int index) {
        System.out.println(vertexList[index].getName());
    }

    public void displayAllEdgesForVertex(int index) {

        System.out.println(vertexList[index].getName() + ":");
        int[] connections = adjMtx[index];

        for(int i = 0; i < connections.length; i++) {
            if(connections[i] != 0) {
                System.out.println(vertexList[i].getName());
            }
        }
    }

    public void deepFind() {

        LinkedList<Integer> stack = new LinkedList();

        vertexList[0].setVisited(true);
        displayVertex(0);
        stack.push(0);

        while(!stack.isEmpty()) {

            int v = findUnvisitedVertex(stack.peek());
            if(v == -1) {
                stack.pop();
            } else {
                vertexList[v].setVisited(true);
                displayVertex(v);
                stack.push(v);
            }
        }

        for(int j = 0; j < nVertex; j++) {
            vertexList[j].setVisited(false);
        }

    }

    public void breadthFind() {
        Queue<Integer> queue = new ArrayBlockingQueue<Integer>(nVertex);

        vertexList[0].setVisited(true);
        displayVertex(0);
        queue.add(0);
        int vertex;

        while(!queue.isEmpty()) {

            int prevVertex = queue.remove();

            while((vertex = findUnvisitedVertex(prevVertex)) != -1) {

                vertexList[vertex].setVisited(true);
                displayVertex(vertex);
                queue.add(vertex);
            }
        }

        for(int i = 0; i < nVertex; i++) {
            vertexList[i].setVisited(false);
        }
    }

    private int findUnvisitedVertex(int v) {

        for(int i = 0; i < nVertex; i++) {
            if(adjMtx[v][i] == 1 && vertexList[i].isVisited() == false) {
                return i;
            }
        }

        return -1;
    }
}
