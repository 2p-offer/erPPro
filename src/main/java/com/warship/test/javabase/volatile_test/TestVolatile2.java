package com.warship.test.javabase.volatile_test;

public class TestVolatile2 {

    public int result = 10;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public static void main(String[] args) throws InterruptedException {
        TestVolatile2.methodTest();
    }

    public static void methodTest() throws InterruptedException {

        TestVolatile2 test = new TestVolatile2();


//        new Thread(() -> {

        while (test.getResult() < 100) {
//                    System.out.println("123");
        }
//                System.out.println("stop thread." + Thread.currentThread().getName());
//        }
//        ).start();
//        Thread.sleep(1000);
//        test.setResult(200);
    }
}
