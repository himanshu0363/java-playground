package org.hmnsch.lab.practice.collection.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapPractice {
    public static void main(String[] args) throws InterruptedException {
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        integerStringHashMap.put(1, "a");  // hashcode of 1 is calculated --> index of the bucket is calculated --> if 1 is not present using equals then new node is created with key value, otherwise the value is replaced
        integerStringHashMap.put(2, "b");  // hashcode of 2 is calculated --> index of the bucket is calculated --> if 1 is not present using equals then new node is created with key value, otherwise the value is replaced
        integerStringHashMap.put(3, "c");  // hashcode of 3 is calculated --> index of the bucket is calculated --> if 1 is not present using equals then new node is created with key value, otherwise the value is replaced
//        System.out.println(integerStringHashMap.get(1));
//        System.out.println(integerStringHashMap.containsKey(1));
//        System.out.println(integerStringHashMap.containsValue("a"));

        for (int i : integerStringHashMap.keySet()) {
//            System.out.println(i);
//            System.out.println(integerStringHashMap.get(i));
        }

        for (Map.Entry<Integer, String> i : integerStringHashMap.entrySet()) {
//            System.out.println(i.getKey());
//            System.out.println(i.getValue());
        }

        Alien alien = new Alien("abcd", 5);
        Alien alien2 = new Alien("xyz", 15);
        Alien alien3 = new Alien("xyz", 15);

        // this will return false as these are different objects, and we are using equals of Object class, which checks for address reference for equality
        // it is always recommeneded to override equals method and provide logic for equality
        // as we know that alien2 and alien3 has same name and distance then they should be same
        System.out.println(alien2.equals(alien3));

        HashMap<Alien, Integer> alienRanks = new HashMap<>();
        alienRanks.put(alien2, 1);  // alien2 will generate a different hashcode then alien3 as they are not equal according to Object.equals()
        alienRanks.put(alien3, 2);
        alienRanks.put(alien, 3);

        // it will return 3 as hashmap thinks all entries are unique based on hashcode
        // but if we override equals method for Alien class then it will think alien2 and alien3 are same
        // also override hashcode() method
        // hashcode should generate same code for objects that are equal
        // so hashcode() method should be related to equals()
        // hash should be generated based on the values used for equality
        System.out.println(alienRanks.size());


        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringIntegerHashMap.put(String.valueOf(i), 1);
            }
        });

        Thread thread1 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                stringIntegerHashMap.put(String.valueOf(i), 1);
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        // as hashtable is synchronized, it will return less than or equal to 2000
        System.out.println(stringIntegerHashMap.size());




    }

    static class Alien {
        String name;

        public Alien(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }

        int distance;

//        @Override
//        public int hashCode() {
//            return Objects.hash(name, distance);
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj) {
//                return true;
//            }
//            if (obj == null) {
//                return true;
//            }
//            Alien alien = (Alien) obj;
//            return alien.distance == distance && alien.name.equals(name);
//        }
    }
}
