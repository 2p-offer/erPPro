package com.warship.test.jvm;

/**
 * 超过某个限制的对象会直接放到老年代
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 */
public class _186_TestPretenureSizeThreshold {
    private static final int MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1;
        allocation1 = new byte[4 * MB];

    }

}
