package org.hmnsch.lab.practice.collection.set;

import java.util.EnumSet;
import java.util.HashSet;

public class EnumSetPractice {
    public static void main(String[] args) throws InterruptedException {
        enum day {
            mon, tues, wed, thurs, fri, sat, sun
        }
        EnumSet<day> weekends = EnumSet.of(day.sat, day.sun, day.sun);
        weekends.add(day.fri);
        System.out.println(weekends);

        EnumSet<day> allDays = EnumSet.allOf(day.class);
        System.out.println(allDays);

        System.out.println(EnumSet.noneOf(day.class));

        // inclusive of range
        System.out.println(EnumSet.range(day.wed, day.fri));

        for (day i : weekends) {
            System.out.println(i);
            if (i == day.fri) {
                weekends.add(day.wed);
            }
        }
        System.out.println(weekends);

        EnumSet<day> integers1 = EnumSet.noneOf(day.class);

        Thread thread0 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                integers1.add(day.mon);
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                integers1.add(day.wed);
            }
        });

        thread0.start();
        thread3.start();

        thread0.join();
        thread3.join();

        System.out.println(integers1.size());
        System.out.println(integers1);

    }
}
