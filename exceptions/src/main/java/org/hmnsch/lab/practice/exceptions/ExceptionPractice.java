package org.hmnsch.lab.practice.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionPractice {
    public static void main(String[] args) {
//        System.out.println(divideWithoutExceptionHandling(1, 0));
//        System.out.println("calling divideWithoutExceptionHandling will stop this from printing");

//        System.out.println(runTimeExceptionHandling(1, 0));
//        System.out.println("calling runTimeExceptionHandling will stop this from printing");


//        System.out.println(runTimeExceptionHandlingWithoutThrowing(1, 0));
//        System.out.println("calling runTimeExceptionHandlingWithoutThrowing will not stop this from printing");

//        System.out.println(exceptionHandlingFinallyUse(1, 1));

//        exceptionHandlingFinallyUseWithoutReturn(1, 1);

//        System.out.println(exceptionHandlingFinallyUseWithThrowing(1, 1));

//        exceptionHandlingFinallyUseWithThrowingInVoidMethod(1, 0);

//        multipleLevelCatches(1, 1);

//        multipleCatches(1, 1);

        checkedException();
    }

    static void checkedException() {
        // checked exceptions must be handled and the code cannot be compiled without it
        File file = new File("a.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        try {
            fileReader.close();
        } catch (NullPointerException | ArithmeticException | IOException e) { // multiple exceptions must be different
            // variable e cannot be used for specific exception methods
            System.out.println("can't close");
        } finally {
            System.out.println("abcd");
        }
    }

    static void multipleCatches(int a, int b) {
        try {
            System.out.println(a / b);
            String str = null;
            System.out.println(str.charAt(5));
        } catch (ArithmeticException | NullPointerException e) { // multiple exceptions must be different
            // variable e cannot be used for specific exception methods
            System.out.println("arithmetic or null");
        } finally {
            System.out.println(a + "/" + b);
        }
    }

    static void multiLevelCatches(int a, int b) {
        try {
            System.out.println(a / b);
            String str = null;
//            System.out.println(str.charAt(5));
            int[] ints = {1, 2, 3, 4, 5};
//            System.out.println(ints[5]);
            throw new InterruptedException();
        } catch (ArithmeticException e) { // catches must from specific to general ones
            System.out.println("arithmetic");
        } catch (NullPointerException e) {
            System.out.println("null");
        } catch (RuntimeException e) {
            System.out.println("runtime");
        } catch (Exception e) {
            System.out.println("generic");
        } finally {
            System.out.println(a + "/" + b);
        }

        System.out.println("outside finally in void method");
    }

    static int divideWithoutExceptionHandling(int a, int b) {
        /*
        * Exception in thread "main" java.lang.ArithmeticException: / by zero
	at org.hmnsch.lab.practice.exceptions.ExceptionPractice.divide(ExceptionPractice.java:9)
	at org.hmnsch.lab.practice.exceptions.ExceptionPractice.main(ExceptionPractice.java:5)
        * */
        return a / b;

        // this is unreachable but with exception handling, we can still print it
//        System.out.println("abcd");
    }

    static int runTimeExceptionHandling(int a, int b) {

        try {
            return a / b;
        } catch (Exception e) {
            // catching and throwing it again, not handling it completely here, expecting the caller to handle it.
            // this method doesn't necessarily need to throw this to the calling method as it is a runtime exception
            // no need to return anything as after throwing the exception, the method execution is completed
            /*
            * Exception in thread "main" java.lang.ArithmeticException
	at org.hmnsch.lab.practice.exceptions.ExceptionPractice.runTimeExceptionHandling(ExceptionPractice.java:35)
	at org.hmnsch.lab.practice.exceptions.ExceptionPractice.main(ExceptionPractice.java:8)
            * */
            throw new ArithmeticException();
        }
    }

    static int runTimeExceptionHandlingWithoutThrowing(int a, int b) {

        try {
            return a / b;
        } catch (Exception e) {
            /* the whole stack trace is printed
            * java.lang.ArithmeticException: / by zero
	at org.hmnsch.lab.practice.exceptions.ExceptionPractice.runTimeExceptionHandlingWithoutThrowing(ExceptionPractice.java:40)
	at org.hmnsch.lab.practice.exceptions.ExceptionPractice.main(ExceptionPractice.java:8)
            * */
            e.printStackTrace();

//            only the error is printed
//            java.lang.ArithmeticException: / by zero
            System.out.println(e);

            // returning a value to end the execution of the method
            return -1;
        }
    }

    static int exceptionHandlingFinallyUse(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println(e);
            return -1;
        } finally { // this will run no matter, if an exception occurs or not, it is beneficial when the method returns during try or catch
            System.out.println(a + "/" + b);
        }
        // unreachable statement, not possible
//        System.out.println("outside finally in a method that returns a value");

    }

    static void exceptionHandlingFinallyUseWithoutReturn(int a, int b) {
        try {
            System.out.println(a/b);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally { // this is redundant and can be outside finally if the method is not returning anything and exception is not rethrown
            System.out.println(a + "/" + b);
        }
        System.out.println("outside finally in void method");
    }

    static int exceptionHandlingFinallyUseWithThrowing(int a, int b) {
        try {
            return a/b;
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        } finally { // this is ok and cannot be printed without finally as the exception is rethrown
            System.out.println(a + "/" + b);
        }
        // unreachable statement, not possible
//        System.out.println("outside finally in a method that returns a value");
    }

    static void exceptionHandlingFinallyUseWithThrowingInVoidMethod(int a, int b) {
        try {
            System.out.println(a/b);
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        } finally { // this is ok and cannot be printed without finally as the exception is rethrown
            System.out.println(a + "/" + b);
        }
        // this will not be printed as the exception is re-thrown
        System.out.println("outside finally in void method");
    }

}
