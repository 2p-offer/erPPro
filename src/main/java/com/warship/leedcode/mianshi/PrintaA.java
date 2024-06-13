package  com.warship.leedcode.mianshi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class PrintaA {
    StringBuffer res = new StringBuffer();
    CountDownLatch c = new CountDownLatch(2);
    AtomicBoolean flag = new AtomicBoolean(true);
    public synchronized void adda(int i) {
        while (!flag.get()) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        res.append((char) ('a' + i));
        flag.set(false);
//        System.out.println("tttttttt:" + System.currentTimeMillis());
        notify();
    }
    public synchronized void addA(int i) {
        while (flag.get()) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        res.append((char) ('A' + i));
        flag.set(true);
        notify();

    }
    public static void main(String[] args) throws Exception {
        long mainStart = System.currentTimeMillis();
        PrintaA test = new PrintaA();
        Thread t1 = new Thread(() -> {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 26; i++) {test.adda(i);}
            long end = System.currentTimeMillis();
            System.out.println("t1:" + (end - start));
            test.c.countDown();
        });
        Thread t2 = new Thread(() -> {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 26; i++) {test.addA(i);}
            long end = System.currentTimeMillis();
            System.out.println("t2:" + (end - start));
            test.c.countDown();
        });
        t1.start();
        t2.start();
        test.c.await();
        long mainEnd = System.currentTimeMillis();
        System.out.println("res:" + test.res.toString());
        System.out.println("main:" + (mainEnd - mainStart));
    }
}
