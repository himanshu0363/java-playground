package org.hmnsch.lab.practice.collection.map;

import java.util.Map;

public class ImmutableMapPractice {
    public static void main(String[] args) {
        // map that cannot be modified is immutable map
        // no null key or value

        // Map.of() for 10 entries only, optimized for smaller size
        Map<String, Integer> immutableMap = Map.of("a", 1, "b", 2);
        System.out.println(immutableMap);

        /*
        * Exception in thread "main" java.lang.UnsupportedOperationException
	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
	at java.base/java.util.ImmutableCollections$AbstractImmutableMap.put(ImmutableCollections.java:1072)
	at org.hmnsch.lab.practice.collection.map.ImmutableMapPractice.main(ImmutableMapPractice.java:12)
        * */
//        immutableMap.put("c", 3);

        /*
        * Exception in thread "main" java.lang.NullPointerException
	at java.base/java.util.Objects.requireNonNull(Objects.java:208)
	at java.base/java.util.ImmutableCollections$MapN.<init>(ImmutableCollections.java:1184)
	at java.base/java.util.Map.of(Map.java:1419)
	at org.hmnsch.lab.practice.collection.map.ImmutableMapPractice.main(ImmutableMapPractice.java:21)
        * */
//        Map<String, Integer> immutableMap2 = Map.of("a", 1, "b", 2, null, 3, "d", null);

        /*
        * Exception in thread "main" java.lang.IllegalArgumentException: duplicate key: 1
	at java.base/java.util.ImmutableCollections$MapN.<init>(ImmutableCollections.java:1189)
	at java.base/java.util.Map.of(Map.java:1373)
	at org.hmnsch.lab.practice.collection.map.ImmutableMapPractice.main(ImmutableMapPractice.java:31)
        * */
//        Map<Integer, Integer> immutableMap2 = Map.of(1, 1, 1, 1);

        // for more than 10 entries
        Map<Integer, Integer> integerIntegerMap = Map.ofEntries(
                Map.entry(1, 1),
                Map.entry(2, 1),
                Map.entry(3, 1),
                Map.entry(4, 1),
                Map.entry(5, 1),
                Map.entry(6, 1),
                Map.entry(7, 1),
                Map.entry(8, 1),
                Map.entry(9, 1),
                Map.entry(10, 1),
                Map.entry(11, 1),
                Map.entry(12, 1)
        );

        System.out.println(integerIntegerMap);

    }
}
