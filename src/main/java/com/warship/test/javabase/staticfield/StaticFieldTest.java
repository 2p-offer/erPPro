package com.warship.test.javabase.staticfield;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author erp
 */
public class StaticFieldTest {
    public static final AtomicLong ID_GENERATOR = new AtomicLong(0);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            long l = ID_GENERATOR.incrementAndGet();
            System.out.println("t1:" + l);
        });

        Thread t2 = new Thread(() -> {
            long l = ID_GENERATOR.incrementAndGet();
            System.out.println("t2:" + l);
        });

        t1.start();
        t2.start();


    }

}
