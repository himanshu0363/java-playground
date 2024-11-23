package org.hmnsch.lab.practice.exceptions.questions;

import java.util.concurrent.*;

public class QuestionPractice {
    public static void main(String[] args) {
//        throwInFinally();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<Integer> callable = () -> {
          throw new RuntimeException();
        };
        Future<Integer> submit = executorService.submit(callable);

        try {
            submit.get();
        } catch (ExecutionException e) {
            System.out.println("callable runtime exception");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }

    static void throwInFinally() {
        try {
            throw new ArithmeticException();
        } finally {
            // exception thrown in finally takes precedence
            throw new RuntimeException();
        }
    }
}
