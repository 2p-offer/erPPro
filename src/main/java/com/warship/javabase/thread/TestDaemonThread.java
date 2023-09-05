package com.warship.test.javabase.thread;

public class TestDaemonThread {
    volatile int tick = 1;

    public static void main(String[] args) {
        TestDaemonThread use = new TestDaemonThread();
        Thread thread = new Thread(() -> {
            for (int i = 1; i < 1000; i++) {
                try {
//                System.out.println("123_Daemon_"+i+"_tick_"+use.tick );
                    use.tick++;
                    use.sayHello("1", i);

//                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
//                System.out.println("123__User_"+i+"_tick_"+use.tick );
                    if (i == 5) {
                        System.exit(0);
                    }
                    use.tick++;
                    use.sayHello("2", i);

//                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        thread2.start();
    }

    public synchronized void sayHello(String thread, int i) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("hello," + thread + "__" + i);
    }
}
