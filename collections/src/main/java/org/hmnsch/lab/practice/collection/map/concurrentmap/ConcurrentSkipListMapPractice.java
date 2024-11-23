package org.hmnsch.lab.practice.collection.map.concurrentmap;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapPractice {
    public static void main(String[] args) throws InterruptedException {
        // thread safe alternative for TreeMap
        // uses skip list data structure, provide logn complexity for insert, search and delete operations
        // skip list is probabilistic data structure
        // levels are created with lower level with all the entries and the higher levels skipping some of the entries
        // key value pairs are stored in nodes, that also contains, next pointers to other nodes in each level and locks
        ConcurrentSkipListMap<String, Integer> stringIntegerConcurrentSkipListMap = new ConcurrentSkipListMap<>();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringIntegerConcurrentSkipListMap.put(String.valueOf(i), 1);
            }
        });

        Thread thread1 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                stringIntegerConcurrentSkipListMap.put(String.valueOf(i), 1);
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        // as hashtable is synchronized, it will return 2000
        System.out.println(stringIntegerConcurrentSkipListMap.size());

    }
}
