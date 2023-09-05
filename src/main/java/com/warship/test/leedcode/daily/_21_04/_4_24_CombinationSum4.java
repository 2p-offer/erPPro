package com.warship.test.leedcode.daily._21_04;

/**
 * 377. 组合总和 Ⅳ
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 *
 * 示例 1：
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 示例 2：
 * 输入：nums = [9], target = 3
 * 输出：0
 *
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 *
 */
public class _4_24_CombinationSum4 {


    /**
     * 当数组nums元素为 i1,i2,i3.. ，target为t 时
     * dp[t] = dp[t-i1] + dp[t-i2] + dp[t-i3] + nums.contains(target) ? 1 : 0
     *
     * @param nums
     * @param target
     * @return
     */
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            int sum = 0;
            for (int num : nums) {
                if (num == i) {
                    sum++;
                }
                if (i > num) {
                    sum += dp[i - num];
                }
            }
            dp[i] = sum;
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int i = combinationSum4(new int[]{2, 4, 6}, 18);
        System.out.println(i);
    }
}
