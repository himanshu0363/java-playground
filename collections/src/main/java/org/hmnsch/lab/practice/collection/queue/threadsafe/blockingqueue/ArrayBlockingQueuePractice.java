package org.hmnsch.lab.practice.collection.queue.threadsafe.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueuePractice {
    public static void main(String[] args) {
        // thread safe
        // wait for queue to become non-empty
        // put --> waits for a space if the queue is full
        // take --> waits for a new element if the queue is empty
        // offer --> waits for a space if the queue is full for a specified time

        // capacity is fixed
        // uses circular array
        // uses single lock for enqueue and dequeue
        // low memory overhead
        // problem with more threads, wait can increase
        ArrayBlockingQueue<Integer> integers = new ArrayBlockingQueue<Integer>(5);

    }
}
