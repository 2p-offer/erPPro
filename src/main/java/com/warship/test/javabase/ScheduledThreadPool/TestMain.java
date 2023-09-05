package com.warship.test.javabase.ScheduledThreadPool;

import java.util.Calendar;

public class TestMain {
    public static int k = 0;
    public static void main(String[] args) {

        Runnable run = () ->
        {
            try {
                //if(k == 0) {
                    Thread.sleep(5000);
                //}
                k++;
                System.out.println(Calendar.getInstance().get(Calendar.SECOND)+",RUN+++++++"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable run2 = () -> System.out.println(Calendar.getInstance().get(Calendar.SECOND) + ",RUN------"+Thread.currentThread().getName());
        Runnable run3 = () -> System.out.println(Calendar.getInstance().get(Calendar.SECOND) + ",RUN======"+Thread.currentThread().getName());
        Runnable run4 = () -> System.out.println(Calendar.getInstance().get(Calendar.SECOND) + ",RUN||||||"+Thread.currentThread().getName());
        TestScheduledThreadPool testPool = new TestScheduledThreadPool();
        System.out.println("STAET11:"+Calendar.getInstance().get(Calendar.SECOND));

        //testPool.addJob(run2, 3, 1);
        //testPool.addJob(run3, 3, 1);
        testPool.addJob(run, 3, 10);
        testPool.addJob(run4, 1, 1);
    }


}


