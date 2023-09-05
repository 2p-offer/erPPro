//package com.warship.test.javabase.mapfastfail;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.CountDownLatch;
//
///**
// * @author erp
// */
//public class MapFastFail {
//
//    public Map<String, MapFastFailInner> map = new ConcurrentHashMap<>();
//
//    public static void main(String[] args) {
//        MapFastFail test = new MapFastFail();
//        test.fastFail();
//    }
//    CountDownLatch countDownLatch = new CountDownLatch(1);
//
//
//    public void fastFail() {
//        map.put("1", new MapFastFailInner());
//        map.put("2", new MapFastFailInner());
//        map.put("3", new MapFastFailInner());
//
//
//
//        Thread t1 = new Thread(() -> {
////            int i = 1;
////            while (i < (10000)) {
////                map.forEach((k, v) -> System.out.println(k + v));
////                i++;
////            }
////    sendTaskToT2();
//            countDownLatch.await();
//        });
//
//        Thread t2 = new Thread(() ->
//        {
////            for (int i = 0; i < 10000; i++) {
////                int tmp = (int) (Math.random() * 10 % 3) + 1;
////                MapFastFailInner orDefault = map.getOrDefault(tmp, new MapFastFailInner());
////                System.out.println(Thread.currentThread() + ":" + orDefault.a);
////                map.put(tmp + i + "", new MapFastFailInner());
////            }
//
//            //String res  = toTask();
//
//            countDownLatch.countDown();
//        }
//        );
//
//        t1.start();
//        t2.start();
//
//
//
//    }
//
//    static class MapFastFailInner {
//
//        int a;
//        int b;
//
//        public MapFastFailInner() {
//            a = 10;
//            b = (int) (Math.random() * 1000);
//        }
//
//        @Override
//        public String toString() {
//            return "MapFastFailInner{" +
//                    "a=" + a +
//                    ", b=" + b +
//                    '}';
//        }
//    }
//}
