package org.hmnsch.lab.practice.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueuePractice {
    public static void main(String[] args) {
        Queue<Integer> linkedListQueue = new LinkedList<>();

        // it might throw exception if capacity is not enough
        linkedListQueue.add(1);

        // it doesn't throw exception if capacity is not enough, returns false
        linkedListQueue.offer(2);
        System.out.println(linkedListQueue);

        // removes from the front, if no element then returns null
        System.out.println(linkedListQueue.poll());

        // removes from the front, if no element then exception
        /*
        * Exception in thread "main" java.util.NoSuchElementException
	at java.base/java.util.LinkedList.removeFirst(LinkedList.java:274)
	at java.base/java.util.LinkedList.remove(LinkedList.java:689)
	at org.hmnsch.lab.practice.collection.queue.LinkedListQueuePractice.main(LinkedListQueuePractice.java:12)
        * */
//        System.out.println(linkedListQueue.remove());


        // returns the element from the front, if no element then null
        System.out.println(linkedListQueue.peek());

        // returns the element from the front, if no element then exception
        /*
        * Exception in thread "main" java.util.NoSuchElementException
	at java.base/java.util.LinkedList.getFirst(LinkedList.java:248)
	at java.base/java.util.LinkedList.element(LinkedList.java:667)
	at org.hmnsch.lab.practice.collection.queue.LinkedListQueuePractice.main(LinkedListQueuePractice.java:24)
        * */
        System.out.println(linkedListQueue.element());
    }
}
