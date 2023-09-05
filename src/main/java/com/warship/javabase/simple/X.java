package com.warship.test.javabase.simple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author erp
 */
public class X {
    public A getObject() {
        return getT();
    }

    public <T> T getT() {
        return (T) new Object();
    }

    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("1", "2");
        map1.put("12", "2");
        map1.put("13", "2");

        final Iterator<String> iterator = map1.keySet().iterator();
        while (iterator.hasNext()) {
            final String next = iterator.next();
            if ("1".equals(next)) {
                iterator.remove();
            }
        }
        System.out.println(map1);
    }
}
