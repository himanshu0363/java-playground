package org.hmnsch.lab.practice.collection.map.concurrentmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapPractice {
    public static void main(String[] args) throws InterruptedException {

        // synchronized hashmap
        // bucket level locking when addition happens
        // cas is used for updating values instead of locking
        // entire map is locked when resizing
        ConcurrentHashMap<String, Integer> stringIntegerConcurrentHashMap = new ConcurrentHashMap<>();
//        stringIntegerConcurrentHashMap.put("a", 1);
//        stringIntegerConcurrentHashMap.put("b", 1);
//        stringIntegerConcurrentHashMap.put("c", 1);

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringIntegerConcurrentHashMap.put(String.valueOf(i), 1);
            }
        });

        Thread thread1 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                stringIntegerConcurrentHashMap.put(String.valueOf(i), 1);
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        // as hashtable is synchronized, it will return 2000
        System.out.println(stringIntegerConcurrentHashMap.size());


    }
}
