package org.hmnsch.lab.practice.collection.map.sortedmap;

import java.util.*;

public class TreeMapPractice {
    public static void main(String[] args) {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("a", 1);
        stringIntegerHashMap.put("c", 1);
        stringIntegerHashMap.put("b", 1);

        TreeMap<String, Integer> stringIntegerTreeMap = new TreeMap<>(stringIntegerHashMap);
        Map<String, Integer> stringIntegerMap = new TreeMap<>(stringIntegerHashMap);
        SortedMap<String, Integer> stringIntegerSortedMap = new TreeMap<>(stringIntegerHashMap);
        NavigableMap<String, Integer> stringIntegerNavigableMap = new TreeMap<>(stringIntegerHashMap);

//        System.out.println(stringIntegerHashMap);
//        System.out.println(stringIntegerTreeMap);
//        System.out.println(stringIntegerMap);
//        System.out.println(stringIntegerSortedMap);
//        System.out.println(stringIntegerNavigableMap);

        // returns map from head to the key provided, toKey is excluded
        System.out.println(stringIntegerSortedMap.headMap("c"));

        // returns map from fromKey to the tail, fromKey is included
        System.out.println(stringIntegerSortedMap.tailMap("b"));

        // returns map from fromKey to toKey, toKey is excluded
        System.out.println(stringIntegerSortedMap.subMap("a", "b"));

        System.out.println(stringIntegerSortedMap.firstKey());
        System.out.println(stringIntegerSortedMap.lastKey());

        System.out.println(stringIntegerSortedMap.values().getClass());

        // returns map from head to the key provided, toKey is included or excluded based on parameter passed
        System.out.println(stringIntegerNavigableMap.headMap("c", true));

        // returns map from fromKey to the tokey provided, fromKey and toKey is included or excluded based on parameter passed
        System.out.println(stringIntegerNavigableMap.subMap("a", false,"c", false));

        // Returns a key-value mapping associated with the least key greater than or equal to the given key, or null if there is no such key.
        System.out.println(stringIntegerNavigableMap.ceilingEntry("b1"));


        System.out.println(stringIntegerNavigableMap.ceilingKey("b"));
        System.out.println(stringIntegerNavigableMap.descendingMap());
        System.out.println(stringIntegerNavigableMap.higherEntry("a"));
        System.out.println(stringIntegerNavigableMap.firstEntry());
        System.out.println(stringIntegerNavigableMap.floorEntry("b1"));

        /*
        * Exception in thread "main" java.lang.NullPointerException
	at java.base/java.util.Objects.requireNonNull(Objects.java:208)
	at java.base/java.util.TreeMap.put(TreeMap.java:809)
	at java.base/java.util.TreeMap.put(TreeMap.java:534)
	at org.hmnsch.lab.practice.collection.map.sortedmap.TreeMapPractice.main(TreeMapPractice.java:53)
        * */
//        stringIntegerTreeMap.put(null, 1);
        stringIntegerTreeMap.put("d", null);
        System.out.println(stringIntegerTreeMap);
    }
}
