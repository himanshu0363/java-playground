package org.hmnsch.lab.practice.collection.list.arraylist;

import org.hmnsch.lab.practice.comparator.StringLengthComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayListPractice {
    public static void main(String[] args) {
        // ArrayList initialization

        // 1. with default capacity of 10
        ArrayList<Integer> defaultArrayList = new ArrayList<>();

        // 2. with user defined capacity
        ArrayList<Integer> userArrayList = new ArrayList<>(25);

        // 3. with type as List, ArrayList methods cannot be used
        List<Integer> list = new ArrayList<>();

        // 4. using array, Arrays.asList returns static ArrayList from Arrays class
        // new elements cannot be added, only existing elements can be modified
        // list.sort() can be applied
        List<Integer> listFromArray = Arrays.asList(1, 2, 3);

        listFromArray.set(0, 5);
//        System.out.println(listFromArray);

        /*
         Exception in thread "main" java.lang.UnsupportedOperationException
	at java.base/java.util.AbstractList.add(AbstractList.java:153)
	at java.base/java.util.AbstractList.add(AbstractList.java:111)
	at org.hmnsch.lab.practice.collection.list.arraylist.ArrayListPractice.main(ArrayListPractice.java:24)
        **/
//        listFromArray.add(1);

        Integer[] integers = {1, 2, 3};
        List<Integer> listFromArray2 = Arrays.asList(integers);

        // not possible as required type is Integer.
//        int[] ints = {1,2,3};
//        List<Integer> listFromArray3 = Arrays.asList(ints);

//        listFromArray.sort(null);
//        System.out.println(listFromArray);



        // 5. using array, List.of returns an immutable list
        // list.sort() can't be applied
        List<Integer> listFromArray4 = List.of(1, 2, 3);

        /*
        * Exception in thread "main" java.lang.UnsupportedOperationException
	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
	at java.base/java.util.ImmutableCollections$AbstractImmutableList.set(ImmutableCollections.java:260)
	at org.hmnsch.lab.practice.collection.list.arraylist.ArrayListPractice.main(ArrayListPractice.java:48)
        * */
        // abstract helping classes help maintaining these functionalities
//        listFromArray4.set(0, 5);
//        System.out.println(listFromArray4);

        // 6. from another collection, a modifiable array list is created
        // all the elements will be copied to a new array as the collection passed is not an ArrayList
        ArrayList<Integer> listFromOtherCollection = new ArrayList<>(listFromArray4);

        // removing via index, removes element at provided index
//        listFromOtherCollection.remove(0);
//        System.out.println(listFromOtherCollection);


        // removing via value, pass object by wrapping integers, removes provided element value
//        listFromOtherCollection.remove(Integer.valueOf(1));
//        System.out.println(listFromOtherCollection);

        // converting a list to an array list.toArray() of object type
        Object[] objects = listFromArray.toArray();

        // not possible as toArray() returns Object type if the type is not passed
        // Integer[] integers2 = listFromArray.toArray();

        // converting a list to an array list.toArray(new Integers[]) of integers type
        Integer[] integers1 = listFromArray.toArray(new Integer[0]);
//        System.out.println(Arrays.toString(integers1));


        ArrayList<String> strings = new ArrayList<>();
        strings.addAll(Arrays.asList("a", "bc", "d", "efg", ""));

        // natural order, ascending alphabetically
//        strings.sort(null);
//        System.out.println(strings);

        // ordering according to the custom comparator class, length based, asc
//        strings.sort(new StringLengthComparator());
//        System.out.println(strings);

        // ordering according to the comparator using lambda, length based, desc
//        strings.sort((s1, s2) -> s2.length()-s1.length());
//        System.out.println(strings);

        Employee employee = new Employee(1, "first", 2000);
        Employee employee1 = new Employee(2, "second", 2001);
        Employee employee2 = new Employee(3, "third", 2003);
        Employee employee3 = new Employee(4, "fourth", 2003);
        Employee employee4 = new Employee(5, "fifth", 2005);
        ArrayList<Employee> employees = new ArrayList<>(Arrays.asList(employee1, employee2, employee, employee4, employee3));
        System.out.println(employees);

        // not possible without Employee class implementing Comparable interface
//        employees.sort(null);

        // using lambda
//        employees.sort((e1, e2)->e1.yoj-e2.yoj);
//        System.out.println(employees);

        // using anonymous implementation
//        employees.sort(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.yoj-o2.yoj;
//            }
//        });

        // we are using minus operator as we are dealing with primitives but if objects are used then Comparable's compareTo method needs to be used.
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        // using comparator class static methods
        // sort based on yoj asc
//        Comparator<Employee> comparator = Comparator.comparing(Employee::getYoj);
        // sort based on yoj asc then if same yoj then compare with name in asc
//        Comparator<Employee> comparator = Comparator.comparing(Employee::getYoj).thenComparing(Employee::getName);
        // sort based on yoj asc then if same yoj then compare with name in desc
        // comparingInt is optimized for comparing primitive integer values
//        Comparator<Employee> comparator = Comparator.comparing(Employee::getYoj).thenComparing(Comparator.comparing(Employee::getName).reversed());
//        employees.sort(comparator);
        System.out.println(employees);

    }
}
