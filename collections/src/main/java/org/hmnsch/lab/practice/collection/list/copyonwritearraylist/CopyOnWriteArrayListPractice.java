package org.hmnsch.lab.practice.collection.list.copyonwritearraylist;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListPractice {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> cowalList = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<Integer> integers = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        // modifications are done on a copied list instead of the original list

        for (Integer integer : integers) {
//            System.out.println(integer);
            if (integer == 3) {
//                integers.set(2, 5);
//                integers.add(6);    // while we have added another element to the list but the loop will only run till the original list
            }
//            System.out.println(integers);
        }

//        System.out.println(integers);

        for (int i=0; i<integers.size();i++) {
//            System.out.println(integers.get(i));
            if (i == 2) {
//                integers.add(6);    // loop iteration will increase as the size increases
            }
//            System.out.println(integers);
        }

//        System.out.println(integers);


        CopyOnWriteArrayList<Integer> integers1 = new CopyOnWriteArrayList<>();

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

        System.out.println(integers1.size());   // this will result in 2000 because write operations are synchronized, multiple threads cannot write simultaneously

    }
}
