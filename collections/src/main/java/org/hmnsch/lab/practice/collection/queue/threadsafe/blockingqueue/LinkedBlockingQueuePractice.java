package org.hmnsch.lab.practice.collection.queue.threadsafe.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueuePractice {
    public static void main(String[] args) {

        // uses linkedlist
        // capacity is optional
        // separate locks for enqueue and dequeue
        // suitable for more threads
        LinkedBlockingQueue<Integer> integers = new LinkedBlockingQueue<>();


        Producer producer = new Producer(integers);
        Thread thread = new Thread(producer);

        Consumer consumer = new Consumer(integers);
        Thread thread1 = new Thread(consumer);

        Consumer consumer2 = new Consumer(integers);
        Thread thread2 = new Thread(consumer2);

        thread.start();
        thread1.start();
        thread2.start();
    }

    static class Producer implements Runnable {

        LinkedBlockingQueue<Integer> linkedBlockingQueue;

        public Producer(LinkedBlockingQueue<Integer> linkedBlockingQueue) {
            this.linkedBlockingQueue = linkedBlockingQueue;
        }

        @Override
        public void run() {
            for (int i = 1; i < 10; i++) {
                try {
                    // this will put the elements in the blocking queue if there is a space
                    // otherwise will wait if it is full, will rarely wait as the space is unbounded
                    linkedBlockingQueue.put(i);
                    System.out.println("produced - " + i);
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }


    static class Consumer implements Runnable {

        LinkedBlockingQueue<Integer> linkedBlockingQueue;
        static final String lock="a";
        static int count=0;

        public Consumer(LinkedBlockingQueue<Integer> linkedBlockingQueue) {
            this.linkedBlockingQueue = linkedBlockingQueue;
        }

        @Override
        public void run() {
            while (count<9) {
                try {
                    // this will take the elements from the blocking queue if there are elements
                    // otherwise will wait if it is empty
                    System.out.println(Thread.currentThread().getName() + " - consumed - " + linkedBlockingQueue.take());
                    synchronized (lock){
                        count++;
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

}


