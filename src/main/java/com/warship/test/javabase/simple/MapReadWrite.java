package com.warship.test.javabase.simple;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author erp
 */
public class MapReadWrite {


    Map<String, String> map = new ConcurrentHashMap<>();

    public void add() {
        while (true) {
            map.put(System.currentTimeMillis() + "", "" + (int) (Math.random() * 10));
        }
    }

    public void get() {
        while (true) {
            List<String> collect = map.values()
                    .stream()
                    .map(st -> st + "123")
                    .collect(Collectors.toList());
            System.out.println(collect);
        }
    }

    public static void main(String[] args) {
        MapReadWrite test = new MapReadWrite();
        Thread t1 = new Thread(test::add);

        Thread t2 = new Thread(test::get);

        t1.start();
        t2.start();
    }
}
