package com.warship.test.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * -Xms100M -Xmx100M -XX:+UseSerialGC
 * 使用jdk bin目录下 jconsole.exe 查看相关窗口。
 */
public class _222_TestJConsole {

    private static final int MB = 1024 * 1024;



    /**
     * 内存变化演示
     * @param num
     * @throws InterruptedException
     */
    public static void OOMTest(int num) throws InterruptedException {
        List<OOMObj> list = new ArrayList<>();
        for(int i = 0;i<num;i++){
            Thread.sleep(50);
            list.add(new OOMObj());
        }
        System.gc();

    }

    static class OOMObj{
        public byte[] pleaceholder = new byte[64 * 1024];
    }

    //=============   内存 -  线程

    /**
     * 线程死循环
     */
    public static void createBusyThread(){
        Thread t = new Thread(()->{
            while(true);
        },"busyThread");
        t.start();
    }

    /**
     * 线程阻塞等待
     * @param obj
     */
    public static void createLockThread(final Object obj){
        Thread t = new Thread(()->{
            synchronized (obj){
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"lockThread");
        t.start();
    }

    static class SynAddRunable implements Runnable{
        int a,b;
        SynAddRunable(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            //升级java17 后注释掉
//            synchronized (Integer.valueOf(a)){
//                //代码 【1】
////                try {
////                    Thread.sleep(1000);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//                synchronized (Integer.valueOf(b)){
//                    System.out.println(a+b);
//                }
//            }
        }
    }

    public static void main(String[] args) throws Exception {

//        内存测试使用
//        OOMTest(1000);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        System.out.println("in:"+s);
//
//        createBusyThread();
//        Object obj = new Object();
//        createLockThread(obj);


        //循环多次尝试，或者直接加入代码  【1】 都可造成死锁
//        for(int i= 1;i < 100;i++){
            new Thread(new SynAddRunable(1,2)).start();
            new Thread(new SynAddRunable(2,1)).start();
//        }


    }



}

