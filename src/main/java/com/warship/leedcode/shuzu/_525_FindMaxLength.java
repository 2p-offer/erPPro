package com.warship.leedcode.shuzu;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 示例 2:
 * <p>
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 */
public class _525_FindMaxLength {

    public int findMaxLength(int[] nums) {
        int[] parseArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int tmpNum = nums[i];
            if (tmpNum == 0) {
                parseArray[i] = -1;
            } else if (tmpNum == 1) {
                parseArray[i] = 1;
            }
        }
        int[] sumArray = new int[nums.length];
        sumArray[0] = parseArray[0];
        for (int i = 1; i < parseArray.length; i++) {
            sumArray[i] = parseArray[i] + sumArray[i - 1];
        }
        int result = 0;
        Map<Integer, Integer> container = new HashMap<>();
        container.put(0, -1);
        for (int i = 0; i < sumArray.length; i++) {
            int tmpSum = sumArray[i];
            if (container.containsKey(tmpSum)) {
                Integer oldIndex = container.get(tmpSum);
                result = Math.max(i - oldIndex, result);
            } else {
                container.put(tmpSum, i);
            }

        }
        return result;
    }

}
