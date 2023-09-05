package com.warship.test.javabase.lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * @author erp
 */
public class MapTypeChange {
    public static void main(String[] args) {
        Map<String, String> firstMap = new HashMap<>();
        firstMap.put(null, "22");
        firstMap.put(null, "22");
        firstMap.put(null, "22");
        firstMap.put(null, "23");
        firstMap.put("1", "1");
        firstMap.put("2", "2");
        firstMap.put("3", "3");
        System.out.println(firstMap.containsKey(null));
        System.out.println(firstMap.get(null));
        Map<Integer, String> secondMap = new HashMap<>();
    }
}
