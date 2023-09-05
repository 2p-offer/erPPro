package com.warship.test.jvm;

/**
 * 长期存活的对象将会进入老年代
 * -verbose:gc -Xms80M -Xmx80M -Xmn40M -XX:+PrintGCDetails -XX:+UseSerialGC -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 *  32M eden   4M from  4M to
 */
public class _187_TestTenuringThreshold {
    private static final int MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {

        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[MB];         //1M  -> eden  -  1M
        allocation2 = new byte[16 * MB];    //16M -> eden  -  16M + 1M
        allocation3 = new byte[16 * MB];    //发生minor GC 1M放到from,age+1;16M放到old ，16M -> eden
        allocation3 = null;
        allocation3 = new byte[16 * MB];    //按常理： 发生minorGC, 1M从from 转到 to，16M放到old，新的16M -> eden
                                            //由于守护线程启动，加载一些默认类，导致from真正内存占用 > 2M，所以触发了动态对象年龄判断。
                                            //from没有转到to，而是全部放到了old，其他不变。
    }
    /**
     * 运行结果与书中又不一致，是因为，虚拟机的动态对象年龄判断
     * 虚拟机并不是永远地要求对象的年龄必须达到了MaxTenuringThreshold才能晋升到老年代，如果在Survivor空间中相同年龄的所有对象大小的 总和 大于Survivor空间的一半，年龄大于或者等于该年龄的对象直接可以进入老年代，无须等到MaxTenuringThreshold中要求的年龄。
     * ————————————————
     *  见 3.8.4 -  P189  - 动态对象年龄判断
     */

    /**
     * 对象最大存活年龄为1
     *
     * [GC (Allocation Failure) [DefNew: 21349K->2074K(36864K), 0.0072654 secs] 21349K->18458K(77824K), 0.0073044 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     * [GC (Allocation Failure) [DefNew: 18786K->1K(36864K), 0.0016207 secs] 35170K->18307K(77824K), 0.0016489 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * Heap
     *  def new generation   total 36864K, used 17254K [0x00000000fb000000, 0x00000000fd800000, 0x00000000fd800000)
     *   eden space 32768K,  52% used [0x00000000fb000000, 0x00000000fc0d9670, 0x00000000fd000000)
     *   from space 4096K,   0% used [0x00000000fd000000, 0x00000000fd000508, 0x00000000fd400000)
     *   to   space 4096K,   0% used [0x00000000fd400000, 0x00000000fd400000, 0x00000000fd800000)
     *  tenured generation   total 40960K, used 18305K [0x00000000fd800000, 0x0000000100000000, 0x0000000100000000)
     *    the space 40960K,  44% used [0x00000000fd800000, 0x00000000fe9e0758, 0x00000000fe9e0800, 0x0000000100000000)
     *  Metaspace       used 3254K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 367K, capacity 388K, committed 512K, reserved 1048576K
     */

    /**
     * 对象最大存活年龄为 11
     *[GC (Allocation Failure) [DefNew
     * Desired survivor size 2097152 bytes, new threshold 1 (max 11)
     * - age   1:    2124528 bytes,    2124528 total
     * : 21349K->2074K(36864K), 0.0064951 secs] 21349K->18458K(77824K), 0.0065281 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     * [GC (Allocation Failure) [DefNew
     * Desired survivor size 2097152 bytes, new threshold 11 (max 11)
     * - age   1:       1440 bytes,       1440 total
     * : 18786K->1K(36864K), 0.0012049 secs] 35170K->18307K(77824K), 0.0012200 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * Heap
     *  def new generation   total 36864K, used 17255K [0x00000000fb000000, 0x00000000fd800000, 0x00000000fd800000)
     *   eden space 32768K,  52% used [0x00000000fb000000, 0x00000000fc0d9730, 0x00000000fd000000)
     *   from space 4096K,   0% used [0x00000000fd000000, 0x00000000fd0005a0, 0x00000000fd400000)
     *   to   space 4096K,   0% used [0x00000000fd400000, 0x00000000fd400000, 0x00000000fd800000)
     *  tenured generation   total 40960K, used 18305K [0x00000000fd800000, 0x0000000100000000, 0x0000000100000000)
     *    the space 40960K,  44% used [0x00000000fd800000, 0x00000000fe9e07d0, 0x00000000fe9e0800, 0x0000000100000000)
     *  Metaspace       used 3277K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 370K, capacity 388K, committed 512K, reserved 1048576K
     *
     * Process finished with exit code 0
     */

}
