package org.hmnsch.lab.practice.collection.set;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetPractice {

    public static void main(String[] args) throws InterruptedException {
        // set doesn't have duplicates
        // unordered
        HashSet<Integer> integers = new HashSet<>(Arrays.asList(1, 1, 2, 3, 5, 5));
//        System.out.println(integers);

        for (Integer i : integers) {
//            System.out.println(i);
            if (i == 1) {
                /*
                * Exception in thread "main" java.util.ConcurrentModificationException
	at java.base/java.util.HashMap$HashIterator.nextNode(HashMap.java:1597)
	at java.base/java.util.HashMap$KeyIterator.next(HashMap.java:1620)
	at org.hmnsch.lab.practice.collection.set.HashSetPractice.main(HashSetPractice.java:13)
                * */
//                integers.add(7);
            }
        }

        HashSet<Integer> integers1 = new HashSet<>();

        Thread thread0 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                integers1.add(i);
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                integers1.add(i);
            }
        });

        thread0.start();
        thread3.start();

        thread0.join();
        thread3.join();

        // not thread safe, so result can be anything and can also contain duplicates
        System.out.println(integers1.size());
        System.out.println(integers1);
    }
}
