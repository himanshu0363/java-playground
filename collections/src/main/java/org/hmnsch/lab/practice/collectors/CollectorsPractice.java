package org.hmnsch.lab.practice.collectors;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

public class CollectorsPractice {
    public static void main(String[] args) {
        // utility class for creating collections

        List<String> names = Arrays.asList(
                "Alice", "Bob", "Charlie", "David",
                "Alice", "Eve", "Frank", "Charlie",
                "Grace", "David"
        );

        // toList
        System.out.println(names.stream().collect(Collectors.toList()));
        System.out.println(names.stream().toList());

        // toSet
        System.out.println(names.stream().collect(Collectors.toSet()));

        // any collection
        ArrayList<String> collect = names.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(names.stream().collect(Collectors.toCollection(ArrayList::new)).toString());

        // joining strings
        // AliceBobCharlieDavidAliceEveFrankCharlieGraceDavid
        System.out.println(names.stream().collect(Collectors.joining()));
        // Alice, Bob, Charlie, David, Alice, Eve, Frank, Charlie, Grace, David
        System.out.println(names.stream().collect(Collectors.joining(", ")));

        // summarizing data
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        IntSummaryStatistics collect1 = list.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println(collect1.getMax());
        System.out.println(collect1.getAverage());
        System.out.println(collect1.getCount());
        System.out.println(collect1.getMin());
        System.out.println(collect1.getSum());
        System.out.println(collect1);

        // averaging
        System.out.println(list.stream().collect(Collectors.averagingInt(x->x)));

        // grouping
        // {3=[Bob, Eve], 5=[Alice, David, Alice, Frank, Grace, David], 7=[Charlie, Charlie]}
        System.out.println(names.stream().collect(Collectors.groupingBy(x->x.length())));

        // {3=Bob,Eve, 5=Alice,David,Alice,Frank,Grace,David, 7=Charlie,Charlie}
        System.out.println(names.stream().collect(Collectors.groupingBy(x->x.length(), Collectors.joining(","))));
        // {3=2, 5=6, 7=2}
        System.out.println(names.stream().collect(Collectors.groupingBy(x->x.length(), Collectors.counting())));
        // {3=2, 5=6, 7=2}
        System.out.println(names.stream().collect(Collectors.groupingBy(x->x.length(), TreeMap::new, Collectors.counting())).toString());

        // partitioning
        // {false=[Bob, Eve], true=[Alice, Charlie, David, Alice, Frank, Charlie, Grace, David]}
        System.out.println(names.stream().collect(Collectors.partitioningBy(x->x.length()>4)));

        // {false=[Bob, Eve], true=[Grace, Alice, Charlie, David, Frank]}
        System.out.println(names.stream().collect(Collectors.partitioningBy(x->x.length()>4, Collectors.toSet())));

        // mapping and collecting
        Set<String> collect2 = names.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toSet()));
        System.out.println(collect2);
    }
}
