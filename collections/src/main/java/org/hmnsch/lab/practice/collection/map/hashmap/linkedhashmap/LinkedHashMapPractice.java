package org.hmnsch.lab.practice.collection.map.hashmap.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class LinkedHashMapPractice {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> stringIntegerLinkedHashMap = new LinkedHashMap<>();
        stringIntegerLinkedHashMap.put("a", 1);
        stringIntegerLinkedHashMap.put("b", 1);
        stringIntegerLinkedHashMap.put("c", 1);

        // order will be maintained
        System.out.println(stringIntegerLinkedHashMap);

        // access order is set to true,
        // order is updated every time when map's pair is used
        // the pair used recently will be moved to the last
        // it is useful when least recently used items need to be removed to save memory
        LinkedHashMap<String, Integer> stringIntegerLinkedHashMap2 = new LinkedHashMap<>(3, 0.75f, true);
        stringIntegerLinkedHashMap2.put("a", 1);
        stringIntegerLinkedHashMap2.put("b", 1);
        stringIntegerLinkedHashMap2.put("c", 1);

        // order will be maintained
        System.out.println(stringIntegerLinkedHashMap2);

        stringIntegerLinkedHashMap2.get("b");
        // b will be moved to the last
        // {a=1, c=1, b=1}
        System.out.println(stringIntegerLinkedHashMap2);

        stringIntegerLinkedHashMap2.put("a", 2);
        // a will be moved to the last
        // {c=1, b=1, a=2}
        System.out.println(stringIntegerLinkedHashMap2);

        LRUCache<String, Integer> stringIntegerLRUCache = new LRUCache<>(3);
        // capacity of LRU is only 3, if size is increased to more than 3 then the least recently used pair will be removed.
        stringIntegerLRUCache.put("a", 1);
        stringIntegerLRUCache.put("b", 1);
        stringIntegerLRUCache.put("c", 1);

        // d will be added in last and a will be removed
        stringIntegerLRUCache.put("d", 2);
        // {b=1, c=1, d=2}
        System.out.println(stringIntegerLRUCache);

        // b will move to last
        stringIntegerLRUCache.get("b");
        // {c=1, d=2, b=1}
        System.out.println(stringIntegerLRUCache);

    }

    static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    }
}
