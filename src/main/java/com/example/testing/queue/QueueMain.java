package com.example.testing.queue;

import com.example.testing.queue.common.LinkedListBasedQueue;

public class QueueMain {

    public static void main(String[] args) {
        LinkedListBasedQueue<Long> queue = new LinkedListBasedQueue<>();

        queue.push(1L);
        queue.push(2L);
        queue.push(3L);
        queue.push(4L);

        System.out.println("The size of queue: " + queue.size());
        System.out.println("The peek element: " + queue.peek());

        for(int i = 1; i <= 5; i++)  {

            System.out.println("Element #" + i + " is: " + queue.pop());

        }


    }
}
