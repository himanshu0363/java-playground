package org.hmnsch.lab.practice.collection.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetPractice {
    public static void main(String[] args) throws InterruptedException {
        // ordered
        // like LinkedHashMap but with only keys
        LinkedHashSet<Integer> integers = new LinkedHashSet<>(Arrays.asList(2, 3, 1, 1, 1, 1, 5, 2, 3));

        // [2, 3, 1, 5]
//        System.out.println(integers);

        for (Integer i : integers) {
//            System.out.println(i);
            if (i == 1) {
                /*
                * Exception in thread "main" java.util.ConcurrentModificationException
	at java.base/java.util.LinkedHashMap$LinkedHashIterator.nextNode(LinkedHashMap.java:756)
	at java.base/java.util.LinkedHashMap$LinkedKeyIterator.next(LinkedHashMap.java:778)
	at org.hmnsch.lab.practice.collection.set.LinkedHashSetPractice.main(LinkedHashSetPractice.java:15)
                * */
//                integers.add(7);
            }
        }


        LinkedHashSet<Integer> integers1 = new LinkedHashSet<>();

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
