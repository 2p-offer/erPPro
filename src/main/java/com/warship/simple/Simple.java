package com.warship.test.simple;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class Simple {

    /**
     * @param containerSet 已经处理过的bean
     * @param beanNames    bean总集合
     * @param bean         当前操作bean
     */
    private static void doSort(LinkedHashSet<java.lang.String> containerSet, Map<java.lang.String, List<java.lang.String>> beanNames, java.lang.String bean) {
        //异常处理
        if (!beanNames.containsKey(bean)) {
            //TODO ERROR
            return;
        }
        //已经处理过的不再处理
        if (containerSet.contains(bean)) {
            return;
        }
        //没有依赖项的直接放到头部
        List<java.lang.String> dependentBeans = beanNames.get(bean);
        if (dependentBeans.isEmpty()) {
            containerSet.add(bean);
            return;
        }
        for (java.lang.String dependentBean : dependentBeans) {
            doSort(containerSet, beanNames, dependentBean);
        }
        containerSet.add(bean);
    }


    public static void main(java.lang.String[] args) throws NoSuchMethodException, InterruptedException {
//        String test = "#### 100002-100414";
//        System.out.println(Pattern.matches("#(4) [0-9]*\\-[0-9]*", test));
//
//        LinkedList<String> linkedList = new LinkedList<>();
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                linkedList.add(i + "");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                linkedList.add(i + "-");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        t2.start();
//
//        System.out.println("size:" + linkedList.size());
//        Thread.sleep(10100);
//        System.out.println("TOSTRING"+linkedList);
//        for (String s1 : linkedList) {
//            System.out.println(s1);
//        }
//        Set<String> a = new HashSet<>();
//        a.add("3");
//        a.add("4");
//        a.add("34");
//        a.add("41");
//        a.add("434");
//        a.stream().forEach(o -> {
//            if (o.contains("3")) {
//                a.remove(o);
//            }
//        });

        ArrayList<Integer> targets = Lists.newArrayList(1, 2, 3, 4);
        targets.forEach(i -> {
            if (i == 2) {
                throw new RuntimeException("11111");
            }
        });

    }


    public static int test(String a, int b) {
        return b = b + 1;
    }

    public static boolean test2(boolean test) {
        return test = true;
    }

}
