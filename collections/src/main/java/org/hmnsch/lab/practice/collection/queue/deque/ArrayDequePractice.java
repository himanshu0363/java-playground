package org.hmnsch.lab.practice.collection.queue.deque;

import java.util.ArrayDeque;

public class ArrayDequePractice {
    public static void main(String[] args) {
        // double ended queue
        // allows insertions and deletions from both ends
        // can act as stack or queue

        // uses Array internally
        // maintains head and tail to act as stack or queue
        ArrayDeque<Integer> integers = new ArrayDeque<>();

        // queue
        integers.addLast(2);
        integers.offerLast(1);

        System.out.println(integers);

        System.out.println(integers.removeFirst());
        System.out.println(integers.pollFirst());

        System.out.println(integers.peekFirst());
//        System.out.println(integers.getFirst());

        // stack
        integers.push(2); // pushes in front
        integers.addLast(1);
        integers.offerLast(3);
//        integers.push(5);

        System.out.println(integers);

        System.out.println(integers.pop()); // pops from the front
        System.out.println(integers.removeLast());
        System.out.println(integers.pollLast());

        System.out.println(integers.peek());    // peeks from the front
        System.out.println(integers.peekLast());
        System.out.println(integers.getLast());
    }
}
