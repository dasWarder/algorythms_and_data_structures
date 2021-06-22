package com.example.testing.deque;

public class DequeMain {

    public static void main(String[] args) {
        SimpleDequeBasedOnLinkedList<Long> deque = new SimpleDequeBasedOnLinkedList<>();

        deque.add(2L);
        deque.add(14L);
        deque.add(8L);
        deque.add(18L);
        deque.add(12L);

        System.out.println("Size:" + deque.size());

        System.out.println("<------------------------------------------>");

        for(int i = 0; i < 5; i++) {
            System.out.println(deque.pollLast());
        }
    }
}
