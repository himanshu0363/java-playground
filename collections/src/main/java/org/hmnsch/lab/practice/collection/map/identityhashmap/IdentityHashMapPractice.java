package org.hmnsch.lab.practice.collection.map.identityhashmap;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class IdentityHashMapPractice {
    public static void main(String[] args) {
        IdentityHashMap<String, Integer> stringIntegerIdentityHashMap = new IdentityHashMap<>();
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        String key1 = new String("a");
        String key2 = new String("a");

        // according to String class equals, key1 and key2 are equal and will generate same hashcode, hence hashmap will store only one pair
        // but in identity hash map, Object class equals and hashcode is used to generating hashcode and comparing keys
        stringIntegerIdentityHashMap.put(key1, 1);
        stringIntegerIdentityHashMap.put(key2, 1);
        stringIntegerHashMap.put(key1, 1);
        stringIntegerHashMap.put(key2, 1);

        // {a=1, a=1}
        System.out.println(stringIntegerIdentityHashMap);

        // {a=1}
        System.out.println(stringIntegerHashMap);

    }
}
