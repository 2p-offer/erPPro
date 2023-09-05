package com.warship.test.leedcode.daily._21_04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 81. 搜索旋转排序数组 II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 */
public class _4_07_Search {
    public static boolean search(int[] nums, int target) {
        List<Integer> container = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return container.contains(target);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 4, 51, 6, 3};
        int target = 3;
        boolean search = search(ints, target);
        System.out.println(search);
    }
}
