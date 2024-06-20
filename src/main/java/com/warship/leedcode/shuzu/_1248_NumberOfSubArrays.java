package com.warship.leedcode.shuzu;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中 「优美子数组」 的数目。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * <p>
 * 示例 3：
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * <p>
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */
public class _1248_NumberOfSubArrays {

    public static void main(String[] args) {
        _1248_NumberOfSubArrays clazz = new _1248_NumberOfSubArrays();
        int[] nums = new int[]{ 2, 1, 2,  1, 2,};
        int i = clazz.numberOfSubarraysPrefixSum(nums, 1);
        System.out.println(i);
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int slow = 0;
        int fast = 0;
        int useNum = 0;
        int ans = 0;

        while (fast < nums.length) {
            while (useNum < k && fast < nums.length) {
                if (nums[fast] % 2 == 1) {
                    useNum++;
                }
                fast++;
            }
            if (useNum < k) {
                return ans;
            }
            int leftCount = 1;
            int rightCount = 1;
            while (slow < fast) {
                int slowNum = nums[slow];
                if (slowNum % 2 == 1) {
                    useNum--;
                    slow++;
                    break;
                } else {
                    leftCount++;
                    slow++;
                }
            }

            while (fast < nums.length) {
                int fastNum = nums[fast];
                if (fastNum % 2 == 0) {
                    rightCount++;
                    fast++;
                } else {
                    break;
                }
            }
            ans += leftCount * rightCount;

        }
        return ans;
    }


    public int numberOfSubarraysPrefixSum(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> container = new HashMap<>();
        container.put(0, 1);
        for (int num : nums) {
            if (num % 2 == 1) {
                sum++;
            }
            container.merge(sum, 1, Integer::sum);
            int needSum = sum - k;
            ans += container.getOrDefault(needSum, 0);
        }
        return ans;
    }
}
