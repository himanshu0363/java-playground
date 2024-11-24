package org.hmnsch.lab.practice.java8features;

public class CustomFunctionalInterfacePractice {
    public static void main(String[] args) {
        // lambda expression
        // it is used to implement functional interface
        // functional interface is an interface that has only one abstract method, can have default and static methods

        @FunctionalInterface    // it is recommended to write this
        interface Vehicle {
            void produce(String type);
        }

        // to implement this, we use lambda expression
        // instead of writing another class to implement it, we can write lamda expression and store the logic in a variable of interface type
        // lambda expression --> x -> System.out.println("produced - " + x)
        // we remove the return type, access modifier and function name, also, argument type can be removed and return keyword as well, if function returns and code is just one line
        // if using curly braces for the implementation then return keyword is needed
        Vehicle vehicle = x -> System.out.println("produced - " + x);

        // produced - bike
        vehicle.produce("bike");

        @FunctionalInterface    // it is recommended to write this
        interface Magic {
            int doTrick(int x, int y);
        }

        Magic addNumbers = (x, y) -> x + y;
        System.out.println(addNumbers.doTrick(1, 3));

    }
}
