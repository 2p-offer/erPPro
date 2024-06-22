package com.warship.leedcode.shuzu;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class _128_LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        _128_LongestConsecutive clazz = new _128_LongestConsecutive();
        int i = clazz.longestConsecutive(nums);
        System.out.println(i);
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> container = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        int result = 1;
        for (int num : container) {
            int currentRes = 1;
            if (container.contains(num - 1)) {
                continue;
            }
            while (container.contains(++num)) {
                currentRes++;
            }
            result = Math.max(result, currentRes);
        }
        return result;
    }

}
