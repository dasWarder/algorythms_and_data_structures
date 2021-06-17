package com.example.testing.queue;

public class QueueMain {

    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue(5);

        queue.insert(5);
        queue.insert(12);
        queue.insert(25);
        queue.insert(2);
        queue.insert(13);

        System.out.println(queue.peek());
        System.out.println(queue.isFull());
        System.out.println(queue.remove());

        for (int i = 0; i < 6; i++) {
            System.out.println(queue.remove());
        }

    }
}
