package org.hmnsch.lab.practice.collection.list.vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class VectorPractice {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        Vector<Integer> vector1 = new Vector<>(5);
        Vector<Integer> vector2 = new Vector<>(5, 5);
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3));
        Vector<Integer> vector3 = new Vector<>(arrayList);

        vector2.addAll(arrayList);
        vector2.addAll(vector2);
        System.out.println(vector2);
        System.out.println(vector2.capacity());
        vector2.remove(1);
        vector2.remove(Integer.valueOf(3));
        System.out.println(vector2);
        System.out.println(vector2.capacity());
        vector2.trimToSize();
        System.out.println(vector2);
        System.out.println(vector2.capacity());
        vector2.addAll(Arrays.asList(1, 2));
        System.out.println(vector2);
        System.out.println(vector2.capacity());

        // increases the size if current size is smaller and adds null to the extra spaces
        vector2.setSize(10);
        System.out.println(vector2);
        System.out.println(vector2.capacity());

        // decreases the size if current size is larger and deletes from the last
        vector2.setSize(5);
        System.out.println(vector2);
        System.out.println(vector2.capacity());
    }
}
