package org.hmnsch.lab.practice.collection.comparable;

import java.util.ArrayList;

public class ComparablePractice {
    public static void main(String[] args) {

        ArrayList<Jungle> jungles = new ArrayList<>();
        jungles.add(new Jungle("a", 2));
        jungles.add(new Jungle("a", 3));
        jungles.add(new Jungle("a", 1));

        /* if Jungle doesn't implement Comparable
        * Exception in thread "main" java.lang.ClassCastException: class org.hmnsch.lab.practice.collection.comparable.ComparablePractice$Jungle cannot be cast to class java.lang.Comparable (org.hmnsch.lab.practice.collection.comparable.ComparablePractice$Jungle is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
	at java.base/java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:320)
	at java.base/java.util.ComparableTimSort.sort(ComparableTimSort.java:188)
	at java.base/java.util.Arrays.sort(Arrays.java:1107)
	at java.base/java.util.Arrays.sort(Arrays.java:1301)
	at java.base/java.util.ArrayList.sort(ArrayList.java:1721)
	at org.hmnsch.lab.practice.collection.comparable.ComparablePractice.main(ComparablePractice.java:13)
        * */
        jungles.sort(null);
        System.out.println(jungles);

    }

    static class Jungle implements Comparable<Jungle> {

        String location;
        int size;

        public Jungle(String location, int size) {
            this.location = location;
            this.size = size;
        }

        @Override
        public int compareTo(Jungle o) {
            // asc
//            return size-o.size;

            // desc
            return o.size-size;
        }

        @Override
        public String toString() {
            return "Jungle{" +
                    "location='" + location + '\'' +
                    ", size=" + size +
                    '}';
        }
    }
}
