package org.hmnsch.lab.practice.collection.queue.threadsafe.blockingqueue;

import java.util.concurrent.SynchronousQueue;

public class SynchronousBlockingQueuePractice {
    public static void main(String[] args) {
        // capacity of at most 1 element
        // every element inserted must be removed for new entry
        SynchronousQueue<Integer> integers = new SynchronousQueue<>();

        Thread thread = new Thread(() -> {
            try {
                for (int i = 0; i <5; i++) {
                    integers.put(i);
                    System.out.println("produced - " + i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread1 = new Thread(() -> {
            try {
                for (int i = 0; i <5; i++) {
                    Thread.sleep(5000);
                    System.out.println("consumed - " + integers.take());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread.start();
        thread1.start();
    }
}
