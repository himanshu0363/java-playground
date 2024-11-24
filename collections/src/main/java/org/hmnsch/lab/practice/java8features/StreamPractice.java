package org.hmnsch.lab.practice.java8features;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        // process collections in functional way
        // data processing is simplified
        // less code is required
        // enable parallelism

        // source of stream --> intermediate operations --> terminal operations
        // stateful and stateless operations
        // stateful --> operations that cares about other values along with the current value like sorted
        // stateless --> operations that only cares about the current value like map etc

        // traditional way of counting even numbers in a collection
//        traditionalWay();
        // stream way with lambda
//        streamWay();

        // stream creation
//        createStreams();

        // intermediate operations
        intermediateOperations();

        // terminal operations
//        terminalOperations();

    }

    static void terminalOperations() {

        List<String> names = Arrays.asList("David", "Alice", "Bob", "Charlie", "Alice");

//        names.stream().limit(5);
//        names.stream().skip(2);

        // collect
        List<String> a = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
        Set<String> a1 = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toSet());

        // [Alice, Alice]
        System.out.println(a);
        // [Alice]
        System.out.println(a1);

        // toList
        List<String> list = names.stream().map(String::toUpperCase).toList();
        List<String> list1 = names.stream().sorted().toList();
        // [Alice, Alice, Bob, Charlie, David]
        System.out.println(list1);
        System.out.println(list);

        // toArray
        String[] array = names.stream().map(String::toUpperCase).toArray(String[]::new);
        // [DAVID, ALICE, BOB, CHARLIE, ALICE]
        System.out.println(Arrays.toString(array));

        // reduce
        // Alice Bob
        Optional<String> reduce = names.stream().distinct().skip(1).limit(2).reduce((x, y) -> x + " " + y);
        System.out.println(reduce.get());

        // count
        long count = names.stream().distinct().count();
        System.out.println(count);

        // anyMatch, allMatch, noneMatch --> these are short circuit operation, means as soon as they have the answer, they return
        /*
        * true
false
false
        * */
        System.out.println(names.stream().anyMatch(name -> name.startsWith("A")));
        System.out.println(names.stream().allMatch(name -> name.startsWith("B")));
        System.out.println(names.stream().noneMatch(name -> name.startsWith("C")));

        // findFirst, findAny --> these are short circuit operation, means as soon as they have the answer, they return
        System.out.println(names.stream().findFirst().get());
        System.out.println(names.stream().findAny().get());

        // forEach
        names.stream().forEach(System.out::println);

        // min, max
        System.out.println(names.stream().min(Comparator.naturalOrder()).get());
        System.out.println(names.stream().max(Comparator.naturalOrder()).get());

        // count occurrences of a char in a string
        String string = "Hello World";
        long count1 = string.chars().filter(x -> x == 'l').count();
        System.out.println(count1);
    }

    static void intermediateOperations() {
        // intermediate operations convert a stream into another stream
        // these are lazy, they do not execute until a terminal operation is applied

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // filter(), it will not filter until terminal operation is applied but it will remember to filter when it is applied
        Stream<String> streamOfNamesStartingWithA = names.stream().filter(name -> name.startsWith("A"));

        // this is not possible because startsWith takes an argument instead of being applied on the elements
//        Stream<String> streamOfNamesStartingWithA2 = names.stream().filter(String::startsWith);

        // map(), to transform the values to something according to map function
        Stream<String> namesToUpperCase = names.stream().map(String::toUpperCase);

        // sorted() --> natural order of the Class used
        Stream<String> sorted = names.stream().sorted();
        // sorted with comparator
        names.stream().sorted((name1, name2) -> name2.compareTo(name1));
        names.stream().sorted(Comparator.reverseOrder());

        // distinct() --> for removing duplicates
        names.stream().distinct();

        // limit() --> limit the results
        names.stream().limit(5);

        // skip()
        names.stream().skip(2);

        // peek()
        names.stream().peek(System.out::println).count();   // peek will not work due to optimization
        names.stream().peek(System.out::println).toList();

        // flatMap, takes one argument and returns a stream
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5)
        );
        // [1, 2, 3, 4, 5]
        System.out.println(list.stream().flatMap(x -> x.stream()).toList());
        System.out.println(list.stream().flatMap(Collection::stream).toList());

        List<String> list1 = Arrays.asList(
                "abcd ef",
                "gh ijklm"
        );
        // [abcd, ef, gh, ijklm]
        System.out.println(list1.stream().flatMap(x -> Arrays.stream(x.split(" "))).toList());

    }

    static void createStreams() {
        // via a collection
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        // via an array
        Integer[] array = list.toArray(new Integer[0]);
        Integer[] array1 = list.toArray(Integer[]::new);
        Stream<Integer> stream1 = Arrays.stream(array);

        // via Stream.of()
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        // via Stream.generate(), infinite stream, to limit use limit()
        Stream<Integer> generate = Stream.generate(() -> 1);
        Stream<Integer> limit = Stream.generate(() -> 1).limit(5);

        // via Stream.iterate(), infinite stream, to limit use limit()
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        Stream<Integer> iterate1 = Stream.iterate(1, x -> x + 1).limit(5);

        // java.util.stream.SliceOps$1@214c265e
        System.out.println(iterate1);

    }

    static void streamWay() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // list.stream() --> source
        // filter() --> intermediate
        // count() --> terminal
        // lambda --> x -> x % 2 == 0
        long countWithLambda = list.stream().filter(x -> x % 2 == 0).count();

        // method reference --> StreamPractice::evenCheck
        long countWithMethodReference = list.stream().filter(StreamPractice::evenCheck).count();
        System.out.println(countWithLambda);
        System.out.println(countWithMethodReference);

    }

    static boolean evenCheck(int x) {
        return x%2==0;
    }

    static void traditionalWay() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int count = 0;
        for (int i : list) {
            if (i % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
