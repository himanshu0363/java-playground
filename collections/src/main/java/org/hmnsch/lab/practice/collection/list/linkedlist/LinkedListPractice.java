package org.hmnsch.lab.practice.collection.list.linkedlist;

import java.util.LinkedList;

public class LinkedListPractice {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.addFirst(5);
        linkedList.addLast(7);
        System.out.println(linkedList.indexOf(2));
        System.out.println(linkedList.get(3));
        linkedList.remove(0);
        linkedList.remove(Integer.valueOf(2));
        System.out.println(linkedList);
    }
}
