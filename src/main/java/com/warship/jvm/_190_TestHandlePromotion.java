package com.warship.test.jvm;

/**
 * 空间分配担保策略
 *
 * Unrecognized VM option 'Handle-PromotionFailure'
 * Did you mean '(+/-)PromotionFailureALot'? Error: Could not create the Java Virtual Machine.
 * Error: A fatal exception has occurred. Program will exit.
 *
 * jdk 6+ 以后，空间分配担保策略 开关已经无效，虽然报错，但是不纠结了
 *
 */
public class _190_TestHandlePromotion {
    private static final int MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {

        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
        allocation1 = new byte[8 * MB];
        allocation2 = new byte[8 * MB];
        allocation3 = new byte[8 * MB];
        allocation1 = null;
        allocation4 = new byte[8 * MB];
        allocation5 = new byte[8 * MB];
        allocation6 = new byte[8 * MB];

        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation6 = new byte[8 * MB];

//3366
    }
}
