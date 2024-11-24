package org.hmnsch.lab.practice.collection.queue.threadsafe.blockingqueue.nonblockingqueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueuePractice {
    public static void main(String[] args) {
        // thread safe, non-blocking
        // cas is used for updates, which is lock free
        // put and take are non-blocking when the queue is full or empty resp

        ConcurrentLinkedQueue<Integer> integers = new ConcurrentLinkedQueue<>();
//        integers.offer(1);
//        integers.offer(5);
//        integers.offer(3);
        System.out.println(integers);

        Thread thread = new Thread(() -> {
            for (int i = 0; i <5; i++) {
                integers.offer(i);
                System.out.println("produced - " + integers);
            }
        });
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i <5; i++) {
                System.out.println("consumed - " + integers.poll());
            }
        });

        thread.start();
        thread1.start();

        // this will not be empty as put and take doesn't wait for each other and may return false and null resp when the queue is full or empty
        System.out.println(integers);

    }
}
