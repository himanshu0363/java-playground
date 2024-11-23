package org.hmnsch.lab.practice.collection.set;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetPractice {
    public static void main(String[] args) throws InterruptedException {
        // thread safe
        // sorted
        ConcurrentSkipListSet<Integer> integers = new ConcurrentSkipListSet<>(Arrays.asList(2, 3, 1, 1, 1, 1, 5, 2, 3));

        // [1, 2, 3, 5]
        System.out.println(integers);

        // 7 will also be iterated
        for (Integer i : integers) {
            System.out.println(i);
            if (i == 1) {
                integers.add(7);
            }
        }


        ConcurrentSkipListSet<Integer> integers1 = new ConcurrentSkipListSet<>();

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

        // thread safe, so result will be 1000 as duplicates are removed
        System.out.println(integers1.size());
        System.out.println(integers1);

    }
}
