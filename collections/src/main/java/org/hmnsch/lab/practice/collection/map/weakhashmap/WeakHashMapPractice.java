package org.hmnsch.lab.practice.collection.map.weakhashmap;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class WeakHashMapPractice {
    public static void main(String[] args) throws InterruptedException {
        WeakHashMap<String, String> integerStringWeakHashMap = new WeakHashMap<>();
//        WeakReference<String> stringWeakReference = new WeakReference<>("a");
        String str = new String("a");
        integerStringWeakHashMap.put(str, "a");
        System.out.println(integerStringWeakHashMap.size());
        str = null;
        System.gc();
        Thread.sleep(10000);

        System.out.println(integerStringWeakHashMap.size());
    }
}
