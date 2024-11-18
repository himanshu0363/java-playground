package org.hmnsch.lab.practice;

import java.util.ArrayList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> vector = new Vector<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                vector.add(i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                vector.add(i);
            }
        });

        thread2.start();
        thread.start();

        thread.join();
        thread2.join();

        Thread thread0 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i);
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i);
            }
        });

        thread0.start();
        thread3.start();

        thread0.join();
        thread3.join();

        // always give 2000 as vector is synchronized
        System.out.println(vector.size());

        // we cannot be sure what will be the answer as arraylist is not synchronized
        // also exception can occur
        /*
        Exception in thread "Thread-2" java.lang.ArrayIndexOutOfBoundsException: Index 375 out of bounds for length 366
	at java.base/java.util.ArrayList.add(ArrayList.java:455)
	at java.base/java.util.ArrayList.add(ArrayList.java:467)
	at org.hmnsch.lab.practice.Main.lambda$main$2(Main.java:30)
	at java.base/java.lang.Thread.run(Thread.java:842)
        */
        System.out.println(arrayList.size());
    }
}