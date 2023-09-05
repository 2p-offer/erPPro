package com.warship.test.leedcode.daily._21_04;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 */
public class _4_30_SingleNumber {

    Map<Integer, Integer> contaienr;

    public int singleNumber(int[] nums) {
        contaienr = new HashMap<>(nums.length / 3 + 1);
        for (int i = 0; i < nums.length; i++) {
            Integer tmp = contaienr.get(nums[i]);
            if (tmp == null) {
                contaienr.put(nums[i], 1);
            } else if (tmp == 2) {
                contaienr.remove(nums[i]);
            } else {
                contaienr.put(nums[i], tmp + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : contaienr.entrySet()) {
            return entry.getKey();
        }
        return -1;
    }


    public int singleNumber_Bit(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _4_30_SingleNumber test = new _4_30_SingleNumber();
        int i = test.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99});


        System.out.println(i);
    }
}
