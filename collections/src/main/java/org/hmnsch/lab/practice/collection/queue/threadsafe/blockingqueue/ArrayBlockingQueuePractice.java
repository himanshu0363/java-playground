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

        Producer producer = new Producer(integers);
        Thread thread = new Thread(producer);

        Consumer consumer = new Consumer(integers);
        Thread thread1 = new Thread(consumer);

        thread.start();
        thread1.start();

    }
}

class Producer implements Runnable {

    ArrayBlockingQueue<Integer> arrayBlockingQueue;

    public Producer(ArrayBlockingQueue<Integer> arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            try {
                // this will put the elements in the blocking queue if there is a space
                // otherwise will wait if it is full
                arrayBlockingQueue.put(i);
                System.out.println("produced - " + i);
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}


class Consumer implements Runnable {

    ArrayBlockingQueue<Integer> arrayBlockingQueue;

    public Consumer(ArrayBlockingQueue<Integer> arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            try {
                // this will take the elements from the blocking queue if there are elements
                // otherwise will wait if it is empty
                arrayBlockingQueue.take();
                System.out.println("consumed - " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
