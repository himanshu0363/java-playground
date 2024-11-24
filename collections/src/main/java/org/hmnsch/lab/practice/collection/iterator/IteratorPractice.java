package org.hmnsch.lab.practice.collection.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorPractice {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        /*
        * Exception in thread "main" java.util.ConcurrentModificationException
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1513)
	at org.hmnsch.lab.practice.collection.iterator.IteratorPractice.main(IteratorPractice.java:10)
        * */
//        arrayList.forEach(a->{
//            if (a == 2) {
//                arrayList.remove(1);
//            }
//            System.out.println(a);
//        });

//        for (int i = 0; i < arrayList.size(); i++) {
//            if (arrayList.get(i) == 2) {
//                arrayList.set(1, 5);
//                arrayList.add(6);
//                arrayList.remove(3);
//            }
//            System.out.println(arrayList.get(i));
//            System.out.println(arrayList);
//        }

        /*
        * Exception in thread "main" java.util.ConcurrentModificationException
	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
	at org.hmnsch.lab.practice.collection.iterator.IteratorPractice.main(IteratorPractice.java:32)
        * */
//        for (int a : arrayList) {
//            if (a == 2) {
//                arrayList.remove(1);
//            }
//            System.out.println(a);
//        }

//        Iterator<Integer> iterator = arrayList.iterator();
//        while (iterator.hasNext()) {
//            int element = iterator.next();
//            System.out.println(element);
//            if (element == 2) {
//                iterator.remove();
//            }
//        }
//        System.out.println(arrayList);

        ListIterator<Integer> integerListIterator = arrayList.listIterator();
        while (integerListIterator.hasNext()) {
            boolean previous = integerListIterator.hasPrevious();
            int element = integerListIterator.next();
            boolean next = integerListIterator.hasNext();
            System.out.println(previous + " - " + element + " - " + next);
        }

    }
}
