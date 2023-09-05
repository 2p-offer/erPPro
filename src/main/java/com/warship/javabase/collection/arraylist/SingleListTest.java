package com.warship.test.javabase.collection.arraylist;

import java.util.Collections;
import java.util.List;

/**
 * Collections.singletonList 返回值不可变
 *
 * @author erp
 */
public class SingleListTest {
    public static void main(String[] args) {
        List<String> strings = Collections.singletonList("123");
        System.out.println(strings);
        List<String> strings1 = addToList(strings);
        System.out.println(strings);
        System.out.println(strings1);
    }

    public static List<String> addToList(List<String> test) {
        test.add("abc");
        return test;
    }
}
