package com.example.testing;


import com.example.testing.graph.SimpleGraph;

public class TestingApplication {


    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph(12);
        graph.addVertex("Pechory");
        graph.addVertex("Pskov");
        graph.addVertex("St Petersburg");
        graph.addVertex("Pustoshka");

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        graph.breadthFind();
    }


};

