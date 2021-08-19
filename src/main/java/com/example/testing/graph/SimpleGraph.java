package com.example.testing.graph;

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

    public boolean findWayFromTo(int start, int end) {

        if(start >= nVertex || end >= nVertex) {
            System.out.println("There is no element like this!");
            return false;
        }

        System.out.println("Start: " + vertexList[start]);

        int[] startConnections = adjMtx[start];
        int[] endConnections = adjMtx[end];

        for(int i = 0; i < startConnections.length; i++) {

            if(startConnections[i] != 0) {

                if(startConnections[end] != 0) {
                    return true;
                }

                int ptr = 0;



            }
        }
    }

    private int findConnection() {

    }
}
