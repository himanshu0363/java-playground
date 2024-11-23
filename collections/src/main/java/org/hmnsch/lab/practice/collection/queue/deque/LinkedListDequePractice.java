package org.hmnsch.lab.practice.collection.queue.deque;

import java.util.Deque;
import java.util.LinkedList;

public class LinkedListDequePractice {
    public static void main(String[] args) {
        Deque<Integer> linkedListDeque = new LinkedList<>();

        linkedListDeque.offer(1);   // offers at the last
        linkedListDeque.offer(2);

        System.out.println(linkedListDeque);

        System.out.println(linkedListDeque.poll()); // polls from the front
    }
}
