package com.warship.test.javabase.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author erp
 */
public class StreamLimit {
    public static void main(String[] args) {
        List<String> collect = Stream.of("1", "2", "3")
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
