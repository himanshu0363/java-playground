package org.hmnsch.lab.practice.collection.queue;

import java.util.PriorityQueue;

public class PriorityQueuePractice {
    public static void main(String[] args) {
        // order elements based on their natural ordering (for primitives, lowest first)
        // custom comparator for custom ordering
        // no null elements
        // not sorted
        // min heap as internal working
        // unordered
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.offer(5);
        integers.offer(2);
        integers.offer(3);
        integers.offer(1);
        integers.offer(4);

        // [1, 2, 3, 5, 4]
        System.out.println(integers);
        while (!integers.isEmpty()) {
            /* elements are removed based on natural order, lowest first or custom order if given
            * 1
2
3
4
5
            * */
            System.out.println(integers.poll());
        }
    }
}
