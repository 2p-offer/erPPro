package com.warship.test.javabase.sortError;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestSortError {
    public static void main(String[] args) {
        int[] ints = new int[]{3,3,3,3,2,2,2,2,2,2,2,2,2,2,6,3,3,3,3,3,3,3,3,3,3,3,3,2,2,2,2,2,2,6,3,3,3,3,3,3,3,3,3,3,3,3,2,2,2,2,2,2,6,3,3,3,3,3,3,3,3,3,3,3,3,2,2,2,2,2,2,6,3,3,3,3,3,3,3,3,3,3,3,3,3,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,3,3,3,3,2,2,2,2,2,2};
        testSort(ints);
        testSortError(ints);
    }

    static void testSortError(int... ints){

        List<Integer> list  = Arrays.stream(ints).boxed().collect(Collectors.toList());
        list.sort((o1, o2) -> {
            return o1 >= o2 ? 1 : -1;
        });
        System.out.println(list);
    }


    static void testSort(int... ints){

        List<Integer> list  = Arrays.stream(ints).boxed().collect(Collectors.toList());

        list.sort((o1, o2) -> {
            if (o1 == o2) {
                return 0;
            } else {
                return o1 > o2 ? 1 : -1;
            }
        });

        System.out.println(list);
    }

}
