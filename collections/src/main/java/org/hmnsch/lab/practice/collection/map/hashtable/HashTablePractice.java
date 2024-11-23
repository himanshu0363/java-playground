package org.hmnsch.lab.practice.collection.map.hashtable;

import java.util.Hashtable;

public class HashTablePractice {
    public static void main(String[] args) throws InterruptedException {
        // synchronized
        // similar to hashmap
        // slower than hashmap due to synchronisation overhead
        // no null key or value
        // legacy
        // only linked list is used when collision occur

        Hashtable<String, Integer> stringIntegerHashtable = new Hashtable<>();
        /*
        * Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "key" is null
	at java.base/java.util.Hashtable.put(Hashtable.java:481)
	at org.hmnsch.lab.practice.collection.map.hashtable.HashTablePractice.main(HashTablePractice.java:12)
        * */
//        stringIntegerHashtable.put(null, 1);

        /*
        * Exception in thread "main" java.lang.NullPointerException
	at java.base/java.util.Hashtable.put(Hashtable.java:476)
	at org.hmnsch.lab.practice.collection.map.hashtable.HashTablePractice.main(HashTablePractice.java:19)
        * */
//        stringIntegerHashtable.put("a", null);


        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringIntegerHashtable.put(String.valueOf(i), 1);
            }
        });

        Thread thread1 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                stringIntegerHashtable.put(String.valueOf(i), 1);
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        // as hashtable is synchronized, it will return 2000
        System.out.println(stringIntegerHashtable.size());

    }
}
