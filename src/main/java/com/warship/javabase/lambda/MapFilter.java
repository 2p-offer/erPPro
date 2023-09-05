package com.warship.test.javabase.lambda;

import com.alibaba.fastjson2.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author erp
 */
public class MapFilter {
    public static void main(String[] args) {

        Set<String> ans = new HashSet<>();
        Map<String, Map<String, Integer>> test = new HashMap<>();
        Map<String, Integer> map1_1 = new HashMap<>();
        map1_1.put("1_1", 1);
        map1_1.put("2_1", 22);
        Map<String, Integer> map1_2 = new HashMap<>();
        map1_2.put("1_2", 1);
        map1_2.put("2_2", 222);
        Map<String, Integer> map1_3 = new HashMap<>();
        map1_3.put("1_1", 11);
        map1_3.put("2_3", 222);
        test.put("1", map1_1);
        test.put("2", map1_2);
        test.put("3", map1_3);

        System.out.println(JSONObject.toJSONString(test));

        test.values().forEach(map -> {
            ans.addAll(map.keySet().stream().filter(f -> !f.contains("_2") && !ans.contains(f)).collect(Collectors.toSet()));
        });
        System.out.println(ans);
    }
}
