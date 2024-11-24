package org.hmnsch.lab.practice.java8features;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class UseReferenceInPlaceOfLambda {
    public static void main(String[] args) {
        // method reference

        // lambda --> x -> System.out.println(x)
        Consumer<Integer> printNumber = x -> System.out.println(x);

        // method reference --> System.out::println
        // it is saying that whatever is passed to this consumer, the println function will be applied to it
        Consumer<Integer> printNumberWithMethodReference = System.out::println;
        printNumberWithMethodReference.accept(5);

        // constructor reference

        // lambda
        Supplier<UseReferenceInPlaceOfLambda> supplyThisClassObject = () -> new UseReferenceInPlaceOfLambda();

        // constructor reference
        Supplier<UseReferenceInPlaceOfLambda> supplyThisClassObject2 = UseReferenceInPlaceOfLambda::new;
        System.out.println(supplyThisClassObject2.get());

    }
}
