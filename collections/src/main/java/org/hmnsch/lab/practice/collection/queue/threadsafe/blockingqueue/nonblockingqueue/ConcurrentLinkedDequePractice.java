package org.hmnsch.lab.practice.collection.queue.threadsafe.blockingqueue.nonblockingqueue;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequePractice {
    public static void main(String[] args) {
        // double ended queue, can add or remove from both sides
        // thread safe, non-blocking
        // cas is used for updates, which is lock free
        // put and take are non-blocking when the queue is full or empty resp

        ConcurrentLinkedDeque<Integer> integers = new ConcurrentLinkedDeque<>();
        integers.offerFirst(1);
        integers.offerFirst(2);
        integers.offerLast(3);
        integers.offerLast(4);
        integers.offerLast(5);
        // [2, 1, 3, 4, 5]
        System.out.println(integers);

    }
}
