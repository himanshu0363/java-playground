package org.hmnsch.lab.practice.collection.list.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StackPractice {
    public static void main(String[] args) {
        List<Integer> stackList = new Stack<>();
        Stack<Integer> integers = new Stack<>();
        integers.push(1);
        integers.push(2);
        integers.push(3);
        integers.push(4);
        integers.push(5);
        System.out.println(integers);
        System.out.println(integers.pop()); // last element added will be returned and removed from the stack
        System.out.println(integers);
        System.out.println(integers.peek()); // last element added will be returned, but it is not removed from the stack
        System.out.println(integers);

        System.out.println(integers.isEmpty());
        System.out.println(integers.size());
        System.out.println(integers.search(3)); // search the place of the element from the last starting from 1, like if 3 is 2nd element from the last then it returns 2


        // using linkedlist
        LinkedList<Integer> linkedListStack = new LinkedList<>();
        linkedListStack.add(1); // acting as push in stack
        linkedListStack.add(2);
        linkedListStack.add(3);
        linkedListStack.add(4);
        linkedListStack.add(5);

        System.out.println(linkedListStack);
        System.out.println(linkedListStack.removeLast());   // acting as pop in stack
        System.out.println(linkedListStack);
        System.out.println(linkedListStack.getLast());  // acting as peek in stack
        System.out.println(linkedListStack);

        // using arraylist
        ArrayList<Integer> arrayListStack = new ArrayList<>();
        arrayListStack.add(1);
        arrayListStack.add(2);
        arrayListStack.add(3);
        arrayListStack.add(4);
        arrayListStack.add(5);

        System.out.println(arrayListStack);
        System.out.println(arrayListStack.remove(arrayListStack.size() - 1));
        System.out.println(arrayListStack);
        System.out.println(arrayListStack.get(arrayListStack.size() - 1));
        System.out.println(arrayListStack);
    }
}
