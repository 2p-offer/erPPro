package com.warship.test.javabase.maptest.treeMap;

/**
 * @author erp
 */
public class SimpleTest {

    public static void main(String[] args) {
//        Map<Integer, String> map = new TreeMap<>(Integer::compare);
//        map.put(1, "11");
//        map.put(4, "44");
//        map.put(2, "22");
//        map.put(123, "123123");
//        map.put(1111111, "11111111111111");
//        map.put(3, "33");
//        System.out.println(map);
//        map.forEach((k, v) -> {
//            map.put(k, "k:" + k);
//        });
//        System.out.println("======================");
//
////        for (Map.Entry<Integer, String> entry : map.entrySet()) {
////            entry.setValue(entry.getValue() + ",,,");
////            System.out.println(entry.getValue());
////        }
//        System.out.println("======================");
//        map.values().stream().forEach((v) -> {
//            System.out.println(",value:" + v);
//        });
//

        double a = 1.23d;
        long l = Double.doubleToLongBits(a);
        long x = (long) a;
        System.out.println(l);
        System.out.println(x);


    }
}
