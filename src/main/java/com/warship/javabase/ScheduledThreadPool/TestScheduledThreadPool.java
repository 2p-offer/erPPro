package com.warship.test.javabase.ScheduledThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestScheduledThreadPool {

    TestScheduledThreadPool() {
        service = Executors.newScheduledThreadPool(1, new CountThreadFactory("TEST"));
    }

    ScheduledExecutorService service;

    public void addJob(Runnable runable, int sleep, int a) {
        service.scheduleAtFixedRate(runable, sleep, a, TimeUnit.SECONDS);
    }


    public static class CountThreadFactory implements ThreadFactory {

        String name;
        AtomicInteger integer;

        public CountThreadFactory(String a) {
            name = a;
            integer = new AtomicInteger(1);
        }

        public Thread newThread(Runnable a) {
            return new Thread(a, a.toString());
        }
    }
}
