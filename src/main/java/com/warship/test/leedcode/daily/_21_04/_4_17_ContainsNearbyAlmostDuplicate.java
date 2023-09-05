package com.warship.test.leedcode.daily._21_04;

import java.util.Iterator;
import java.util.TreeSet;

public class _4_17_ContainsNearbyAlmostDuplicate {
    /**
     * 滑动窗口解法
     * 从头遍历 nums，得到当前值currentNum
     * 维护一个currentNum 左侧最多K个元素在一个集合，作为可滑动窗口；
     * 如果 k中和 currentNum 相减绝对值最小的元素  ，相减得到的绝对值 < t  则代表已经找到了符合条件的两个元素。
     * <p>
     * 如果集合中元素长度 > k 则需要删除第一个放入的元素 ，即：nums[currentIndex - k]
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {

        int length = nums.length;
        if (length <= 1) {
            return false;
        }
        TreeSet<Integer> windows = new TreeSet<>();
        windows.add(nums[0]);
        for (int i = 1; i < length; i++) {
            int currentNum = nums[i];
            int nearlyNum = getNearlyNum(windows, currentNum);
            if (nearlyNum <= t) {
                return true;
            }
            //使用set做滑动窗口，问题是，当窗口中出现重复元素的时候，没法保证当 窗口集合长度==k的时候，
            //只包含粗人rentIndex 左侧 k个元素。
            //但是细想，当窗口中将要出现重复元素的时候【currentNum 存在与 窗口集合】，getNearlyNum 返回值是 0；必定符合提议
            if (windows.size() == k) {
                windows.remove(nums[i - k]);
            }
            windows.add(currentNum);
        }
        return false;
    }

    /**
     * 获取container中与num值最接近的数
     * <p>
     * 写到一半发现，用list 不如用有序集合 TreeSet 。因为这个方法，使用list 每次都要遍历container 内部所有元素
     * 如果使用TreeSet 则当 container某个元素与num的绝对值已经大于等于 记录的最优解的时候，说明当前记录的最优解就是最优解
     *
     * @param container
     * @param num
     * @return
     */
    public static int getNearlyNum(TreeSet<Integer> container, int num) {
        Iterator<Integer> iterator = container.iterator();
        int res = -1;
        while (iterator.hasNext()) {
            int tmp = iterator.next();
            int abs = Math.abs(tmp - num);
            if (res == -1 || abs < res) {
                res = abs;
            } else if (abs >= res) {
                return res;
            }
        }
        return res;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        int length = nums.length;
        //添加k==0 是 i，j 下标不相等。k==0 肯定不符合提议
        if (length <= 1 || k == 0) {
            return false;
        }
        TreeSet<Long> windows = new TreeSet<>();
        windows.add((long) nums[0]);
        for (int i = 1; i < length; i++) {
            long currentNum = nums[i];
            //ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
            Long minNum = windows.ceiling(currentNum - t);
            if (minNum != null && minNum <= (currentNum + t)) {
                return true;
            }
            //使用set做滑动窗口，问题是，当窗口中出现重复元素的时候，没法保证当 窗口集合长度==k的时候，
            //只包含粗人rentIndex 左侧 k个元素。
            //但是细想，当窗口中将要出现重复元素的时候【currentNum 存在与 窗口集合】，getNearlyNum 返回值是 0；必定符合提议
            if (windows.size() >= k) {
                windows.remove((long) nums[i - k]);
            }
            windows.add(currentNum);
        }
        return false;
    }


    public static void main(String[] args) {
//        TreeSet<Integer> container = new TreeSet<>();
//        container.add(11);
//        container.add(111);
//        container.add(1);
//        container.add(5);
//        container.add(22);
//        container.add(3);
//        int nearlyNum = getNearlyNum(container, 8);
//        System.out.println(nearlyNum);
//[-2147483648,2147483647]
//1
//1[2147483640,2147483641]
//1
//100
        boolean b = containsNearbyAlmostDuplicate(new int[]{1, 2}, 0, 1);
        System.out.println(b);
//        System.out.println(Integer.MAX_VALUE);

    }


}
