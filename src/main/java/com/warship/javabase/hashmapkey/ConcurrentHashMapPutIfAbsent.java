package com.warship.test.javabase.hashmapkey;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author erp
 */
public class ConcurrentHashMapPutIfAbsent {

    public static void main(String[] args) {
        Map<String, String> test = new ConcurrentHashMap<>();
//        String s = test.putIfAbsent("1", "1");
//        System.out.println(s);
//        System.out.println(test);
//        String s1 = test.putIfAbsent("1", "2");
//        System.out.println(s1);
//        System.out.println(test);
        test.put("1", "1");
        test.put("12", "12");
        test.put("123", "123");
        for (Map.Entry<String, String> entry : test.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
            test.put("333", "333");
        }

        System.out.println(test);
    }
}
