package org.hmnsch.lab.practice.java8features;

import java.util.function.*;

public class InbuiltFunctionalInterfaces {
    public static void main(String[] args) {
        // predicate
        // used for testing conditions
        // takes an argument and returns true or false
//        predicateFI();

        // function
        // used to apply some logic and return something
        // only takes one argument
//        functionFI();

        // consumer
        // used to accept an argument and do something with it, no return
//        consumerFI();

        // supplier
        // used to get something without an argument
//        supplierFI();

        // bi predicate
        // similar to predicate but takes 2 arguments
//        biPredicateFI();

        // bi function
        // similar to function but takes 2 arguments
//        biFunctionFI();

        // bi consumer
        // similar to consumer but takes 2 arguments
//        biConsumerFI();

        // unary operator
        // similar to function but arguments and return are of same type
//        unaryOperatorFI();

        // binary operator
        // similar to bi function but arguments and return are of same type
//        binaryOperatorFI();


    }

    static void unaryOperatorFI() {

        UnaryOperator<Integer> doubleIt = x -> 2*x;
        System.out.println(doubleIt.apply(5));

    }

    static void binaryOperatorFI() {

        BinaryOperator<Integer> subtract = (x,y) -> x-y;
        System.out.println(subtract.apply(5, 2));

    }

    static void biConsumerFI() {

        BiConsumer<Integer, String> ageAndNameInEnglishSentence = (x,y) -> System.out.println("age is - " + x + " and name is " + y);
        ageAndNameInEnglishSentence.accept(5, "a");

    }

    static void biFunctionFI() {

        BiFunction<Integer, Long, String> subtract = (x,y) -> "answer is - " + (x-y);
        System.out.println(subtract.apply(5, 2l));

    }

    static void biPredicateFI() {

        BiPredicate<Integer, String> isNumberStringSame = (x,y) -> Integer.valueOf(y).equals(x);
        System.out.println(isNumberStringSame.test(2, "2"));
        System.out.println(isNumberStringSame.test(5, "3"));

    }

    static void predicateFI() {

        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(2));

        // default method and(), or() and negate() can be used to test multiple conditions
        Predicate<Integer> isSingleDigit = x -> x / 10 == 0;

        System.out.println(isEven.and(isSingleDigit).test(12));

    }

    static void functionFI() {

        Function<Integer, String> ageInEnglishSentence = x -> "age is - " + x;
        System.out.println(ageInEnglishSentence.apply(5));

        // default method andThen(), compose() can be used to apply multiple functions
        Function<String, Integer> lengthOfString = x -> x.length();

        System.out.println(ageInEnglishSentence.andThen(lengthOfString).apply(5));

        // compose is used when 2nd function needs to be applied first

    }

    static void consumerFI() {

        Consumer<Integer> ageInEnglishSentence = x -> System.out.println("age is - " + x);
        ageInEnglishSentence.accept(5);

        // default method andThen() can be used to apply multiple consumers
        Consumer<Integer> lengthOfString = x -> System.out.println(x.toString());

        ageInEnglishSentence.andThen(lengthOfString).accept(5);

    }

    static void supplierFI() {

        class Pen {
            String type;
            int cost;

            public Pen(String type, int cost) {
                this.type = type;
                this.cost = cost;
            }

            @Override
            public String toString() {
                return "Pen{" +
                        "type='" + type + '\'' +
                        ", cost=" + cost +
                        '}';
            }
        }

        Supplier<Pen> supplyPen = () -> new Pen("cap", 5);
        System.out.println(supplyPen.get());

    }

}
