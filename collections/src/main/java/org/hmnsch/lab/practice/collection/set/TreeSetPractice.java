package org.hmnsch.lab.practice.collection.set;

import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetPractice {
    public static void main(String[] args) throws InterruptedException {
        // sorted
        // like TreeMap with only keys
        TreeSet<Integer> integers = new TreeSet<>(Arrays.asList(2, 3, 1, 1, 1, 1, 5, 2, 3));

        // [1, 2, 3, 5]
//        System.out.println(integers);

        for (Integer i : integers) {
//            System.out.println(i);
            if (i == 1) {
                /*
                * Exception in thread "main" java.util.ConcurrentModificationException
	at java.base/java.util.TreeMap$PrivateEntryIterator.nextEntry(TreeMap.java:1486)
	at java.base/java.util.TreeMap$KeyIterator.next(TreeMap.java:1540)
	at org.hmnsch.lab.practice.collection.set.TreeSetPractice.main(TreeSetPractice.java:15)
                * */
//                integers.add(7);
            }
        }

        TreeSet<Integer> integers1 = new TreeSet<>();

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
        /*
        * Exception in thread "Thread-0" java.lang.NullPointerException: Cannot read field "left" because "r" is null
	at java.base/java.util.TreeMap.rotateLeft(TreeMap.java:2543)
	at java.base/java.util.TreeMap.fixAfterInsertion(TreeMap.java:2610)
	at java.base/java.util.TreeMap.addEntry(TreeMap.java:770)
	at java.base/java.util.TreeMap.put(TreeMap.java:828)
	at java.base/java.util.TreeMap.put(TreeMap.java:534)
	at java.base/java.util.TreeSet.add(TreeSet.java:255)
	at org.hmnsch.lab.practice.collection.set.TreeSetPractice.lambda$main$0(TreeSetPractice.java:33)
	at java.base/java.lang.Thread.run(Thread.java:842)
        * */
        System.out.println(integers1.size());
        System.out.println(integers1);

    }
}
