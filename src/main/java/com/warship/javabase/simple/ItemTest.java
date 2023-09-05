package com.warship.test.javabase.simple;

import com.alibaba.fastjson2.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author erp
 */
public class ItemTest {

    private String id;

    private String type;

    private List<String> skills;

    //[A,B,C]

    //"1:A,2:B,3:C,4:D"

    public void updateItemDb(String rid, String itemId, String key, String newValue) {
        StringBuilder sb = new StringBuilder();
        String sbStr = sb.toString();
//        dbUdpate(itemId, sbStr);
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        Thread thread = new Thread(() -> {
            while (true) {
                double random = Math.random();
                if (random < 0.5) {
                    test.add("1");
                } else {
                    test.remove(0);
                }
            }
        });

        Thread thread1 = new Thread(() -> {
            while (true) {
                int i = 0;
//                System.out.println(test.size());
                System.out.println(JSONObject.toJSONString(test));
            }
        });

        thread.start();
        thread1.start();
    }
}