package com.warship.test.javabase.volatile_test;

public class TestVolatile {
    private int a = 0;
    private boolean flag = false;
//
//    public void writer() {
//        a = 1;          //1
//        flag = true;   //2
//    }
//
//    public void reader() throws InterruptedException {
////        Thread.sleep(10);
//        if (flag) {      //3
//            int i = a; //4
//        }
//    }
//
//    public void say(){
//        System.out.println("a:"+a+",flag:"+flag);
//    }
//
//    public static void main(String[] args) throws Exception {
//        TestVolatile  test = new TestVolatile();
//        Thread t1 = new Thread(()->{
//            test.writer();
//        });
//        Thread t2 = new Thread(()->{
//            try {
//                test.reader();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        test.say();
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        test.say();
//    }

    private static boolean stopThread;

    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(() -> {
            int i = 0;
            while (!stopThread) {
                synchronized (TestVolatile.class) {
                    i++;
                }
            }
        });
        th.start();
        Thread.sleep(1000);
        stopThread = true;
        th.join();
    }


}
