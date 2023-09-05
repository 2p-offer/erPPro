package com.warship.test.javabase.collection.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * subList 之后的集合改变，会改变原有集合内容
 *
 * @author erp
 */
public class SubListTest {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("123");
        test.add("112233");
        System.out.println(test);
        List<String> strings = test.subList(0, 1);

        System.out.println(strings);
        strings.add("111");
        System.out.println(strings);
        System.out.println(test);
    }
}
