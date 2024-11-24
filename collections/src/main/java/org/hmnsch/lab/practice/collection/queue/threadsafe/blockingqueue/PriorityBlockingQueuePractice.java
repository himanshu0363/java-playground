package org.hmnsch.lab.practice.collection.queue.threadsafe.blockingqueue;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueuePractice {
    public static void main(String[] args) {
        // unbounded
        // binary heap as underlying ds
        // polled according to natural or custom order

        PriorityBlockingQueue<Integer> integers = new PriorityBlockingQueue<>();

        Producer producer = new Producer(integers);
        Thread thread = new Thread(producer);

        Consumer consumer = new Consumer(integers);
        Thread thread1 = new Thread(consumer);

        thread.start();
        thread1.start();
    }

    static class Producer implements Runnable {

        PriorityBlockingQueue<Integer> priorityBlockingQueue;

        public Producer(PriorityBlockingQueue<Integer> priorityBlockingQueue) {
            this.priorityBlockingQueue = priorityBlockingQueue;
        }

        @Override
        public void run() {
            for (int i = 10; i > 1; i--) {
                try {
                    // this will put the elements in the blocking queue if there is a space
                    // otherwise will wait if it is full
                    priorityBlockingQueue.put(i);
                    System.out.println("produced - " + priorityBlockingQueue);
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }


    static class Consumer implements Runnable {

        PriorityBlockingQueue<Integer> priorityBlockingQueue;

        public Consumer(PriorityBlockingQueue<Integer> priorityBlockingQueue) {
            this.priorityBlockingQueue = priorityBlockingQueue;
        }

        @Override
        public void run() {
            for (int i = 1; i < 10; i++) {
                try {
                    // this will take the elements from the blocking queue if there are elements
                    // otherwise will wait if it is empty
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " - consumed - " + priorityBlockingQueue.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

}
