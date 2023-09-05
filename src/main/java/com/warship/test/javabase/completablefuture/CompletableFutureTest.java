package com.warship.test.javabase.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author erp
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        System.out.println(Thread.currentThread().getName());
//        Thread thread = new Thread(() -> {
//            CompletableFuture.runAsync(() -> {
//                System.out.println(Thread.currentThread().getName());
//            });
//        });
//        thread.start();
//        Thread.sleep(2000L);

        CompletableFuture<String> future = getFuture("A");
        CompletableFuture<String> future1 = future.thenComposeAsync(data -> getFuture(data));
        String s = future1.get();
        System.out.println(s);

    }

    private static CompletableFuture<String> getFuture(String arg) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return arg + "123";
        });
    }
}
