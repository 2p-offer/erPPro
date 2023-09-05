package com.warship.test.javabase.volatile_test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class TestVolatile3 {
    //加上volatile 能解决问题吗？
    //    public  int i = 0;
    public volatile int i = 0;
    public AtomicInteger ai = new AtomicInteger(0);


    CountDownLatch latch = new CountDownLatch(2);

    //    public synchronized void doTask() {
    public void doTask() {
        for (int j = 0; j < 1000000; j++) {
            i++;
//            ai.incrementAndGet();
        }
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {

        TestVolatile3 test = new TestVolatile3();
        Thread daemon = new Thread(() -> {
            try {
                test.latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(test.ai.get());
            System.out.println(test.i);
        });

        Thread t1 = new Thread(() -> {
            test.doTask();
        });


        Thread t2 = new Thread(() -> {
            test.doTask();
        });
        daemon.start();
        t1.start();
        t2.start();


    }
}
