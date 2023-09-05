package com.warship.test.javabase.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author erp
 */
public class MapToLong {

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> test = new HashMap<>();
        Map<String, Integer> map1_1 = new HashMap<>();
        map1_1.put("1_1", 1);
        map1_1.put("2_1", 2);
        Map<String, Integer> map1_2 = new HashMap<>();
        map1_2.put("1_1", 3);
        map1_2.put("2_2", 4);
        Map<String, Integer> map1_3 = new HashMap<>();
        map1_3.put("1_1", 5);
        map1_3.put("2_3", 6);
        test.put("1", map1_1);
        test.put("2", map1_2);
        test.put("3", map1_3);

        long sum = test.entrySet().stream().mapToLong(entry ->
                entry.getValue().getOrDefault("1_1", 0)).sum();

        AtomicLong tmpSum = new AtomicLong(0L);
        test.forEach((k, v) -> {
            int tmpAbsolute = v.getOrDefault("1_1", 0);
            tmpSum.addAndGet(tmpAbsolute);
        });

        System.out.println(sum);
        System.out.println(tmpSum.get());
    }

}
