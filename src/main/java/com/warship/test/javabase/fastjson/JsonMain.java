package com.warship.test.javabase.fastjson;

import com.alibaba.fastjson2.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author erp
 */
public class JsonMain {

    static Map<String, String> conMap = new HashMap<>();

    public static void main(String[] args) {
//        printTopUnder();
        dealConMap();
    }

    private static void dealConMap() {
        Thread t1 = new Thread(() -> {
            while (true) {
                for (Map.Entry<String, String> entry : conMap.entrySet()) {
                    String a = entry.getKey() + entry.getValue();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            int i = 0;
            while (i < 100000) {
                conMap.put(String.valueOf(++i), "value");
            }
        });
        t1.start();
        t2.start();
    }

    private static void printTopUnder() {
        JsonUnder json = new JsonUnder();
        json.setName("name");
        json.setTmp("tmp");
        json.setAge(12);
        JSONObject tmp = new JSONObject();
        tmp.put("abc", 123);
        Map<String, Object> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", 1);


        Map<String, Object> map2 = new HashMap<>();
        map2.put("in", "in");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            tmp.put(entry.getKey(), entry.getValue());
        }
        tmp.put("ddd", map2);
        json.setObject(tmp);
//        json.setObject(map);
        prinkStr(json);
    }

    public static void prinkStr(Object json) {
//        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(JSONObject.toJSONString(json));
        //{"age":12,"name":"name","object":{"a":"a","b":1,"abc":123},"tmp":"tmp"}
    }
}
