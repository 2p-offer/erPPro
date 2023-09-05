package com.warship.test.javabase.hashmapkey;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestKeySet {
    public static void main(String[] args) {
        Map<Integer,String>  hashMap  = new HashMap<>();
        hashMap.put(1,"1");
        hashMap.put(11,"11");
        hashMap.put(111,"111");
        hashMap.put(1111,"1111");
        Set<Integer> set = hashMap.keySet();
        Set<Integer> simpleSet = new HashSet<>();
        simpleSet.add(2);
        simpleSet.add(22);
        simpleSet.add(222);
        simpleSet.add(2222);
        System.out.println("keySet:"+set);
        System.out.println("simpleSet"+simpleSet);

    }

}
