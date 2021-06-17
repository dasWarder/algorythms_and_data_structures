package com.example.testing.queue;

import com.example.testing.queue.priority.PriorityQueue;

public class QueueMain {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.insert(5);
        priorityQueue.insert(15);
        priorityQueue.insert(25);
        priorityQueue.insert(10);

        System.out.println(priorityQueue.size());

    }
}
