package org.hmnsch.lab.practice.java8features;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamPractice {
    public static void main(String[] args) {
        // a type of stream that allows parallel processing
        // allow multiple threads to process parts of stream simultaneously
        // for large data sets, performance is improved
        // not suitable for small datasets
        // suitable for stateless operations

        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();

        long startTime = System.currentTimeMillis();
        list.stream().map(ParallelStreamPractice::factorial).toList();
        long endTime = System.currentTimeMillis();

        // 159
        System.out.println(endTime-startTime);

        long startTime1 = System.currentTimeMillis();
        list.parallelStream().map(ParallelStreamPractice::factorial).toList();
        long endTime1 = System.currentTimeMillis();

        // 29
        System.out.println(endTime1-startTime1);

    }

    static int factorial(int x) {
        int result=1;
        if (x == 1) {
            return result;
        }
        for (int i = 2; i <= x; i++) {
            result *= i;
        }
        return result;
    }
}
