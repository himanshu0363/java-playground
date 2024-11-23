package org.hmnsch.lab.practice.exceptions.questions.q7;

public class Main {
    public static void main(String[] args) {
        try {
            validateAge(15);
        } catch (Main.InvalidAgeException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    static void validateAge(int age) throws Main.InvalidAgeException {
        if (age < 18) {
            throw new Main.InvalidAgeException();
        }
    }

    static class InvalidAgeException extends Exception {

    }

}

class InvalidAgeException2 extends Exception {

}

