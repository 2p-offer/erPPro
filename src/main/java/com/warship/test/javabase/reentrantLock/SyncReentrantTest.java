package com.warship.test.javabase.reentrantLock;

/**
 * synchronized 是不是可重入锁
 */
public class SyncReentrantTest {

    public static int i = 1;

    public static void main(String[] args) {
        SyncReentrantTest test = new SyncReentrantTest();
        test.testReentrant();
    }

    public void testReentrant(){
        System.out.println("before in:"+i);
        synchronized (SyncReentrantTest.class){
            System.out.println("in:"+i);
            i++;
            if(i>2){
                return;
            }
            testReentrant();

        }
    }
}
