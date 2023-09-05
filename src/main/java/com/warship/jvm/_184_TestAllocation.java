package com.warship.test.jvm;

/**
 * 垃圾收集
 *
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+UseSerialGC -XX:SurvivorRatio=8
 * 以上配置，idea启动main函数，会额外占用接近4M空间，导致GC提前，所以做如下改进（参数和对象大小都乘以4）
 * -verbose:gc -Xms80M -Xmx80M -Xmn40M -XX:+PrintGCDetails -XX:+UseSerialGC -XX:SurvivorRatio=8
 */
public class _184_TestAllocation {
    private static final int MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(20000);
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[8 * MB];
        allocation2 = new byte[8 * MB];
        allocation3 = new byte[8 * MB];
        allocation4 = new byte[16 * MB];
//3366
    }


    /**
     * 自己调用打印结果，与《深入理解java虚拟机，第三版》描述不一致
     * [GC (Allocation Failure) [DefNew: 7298K->1023K(9216K), 0.0030795 secs] 7298K->5140K(19456K), 0.0031100 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * Heap
     *  def new generation   total 9216K, used 7492K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
     *   eden space 8192K,  78% used [0x00000000fec00000, 0x00000000ff251130, 0x00000000ff400000)
     *   from space 1024K,  99% used [0x00000000ff500000, 0x00000000ff5ffff8, 0x00000000ff600000)
     *   to   space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
     *  tenured generation   total 10240K, used 4116K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
     *    the space 10240K,  40% used [0x00000000ff600000, 0x00000000ffa05308, 0x00000000ffa05400, 0x0000000100000000)
     *  Metaspace       used 3157K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 357K, capacity 388K, committed 512K, reserved 1048576K
     */

}
