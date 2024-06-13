package  com.warship.leedcode.daily._21_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 */
public class _4_23_LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int maxIndex = 0;
        int maxNum = 1;
        int tmpMaxNum = Integer.MIN_VALUE;
        int tmpMaxIndex = -1;
        List<Integer>[] dp = new ArrayList[nums.length];
        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums[0]);
        dp[0] = tmp;
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (tmpMaxNum < dp[j].size()) {
                        tmpMaxNum = dp[j].size();
                        tmpMaxIndex = j;
                    }
                }
            }
            if (tmpMaxIndex != -1) {
                tmp = new ArrayList<>(dp[tmpMaxIndex]);
                tmp.add(nums[i]);
                dp[i] = tmp;
                if (tmp.size() > maxNum) {
                    maxIndex = i;
                    maxNum = tmp.size();
                }
                System.out.println("maxIndex:" + maxIndex + ",maxNum:" + maxNum);
                tmpMaxNum = Integer.MIN_VALUE;
                tmpMaxIndex = -1;
            }
            if (dp[i] == null) {
                tmp = new ArrayList<>();
                tmp.add(nums[i]);
                dp[i] = tmp;
            }
            System.out.println(dp[i]);
        }

        return dp[maxIndex];
    }


    public List<Integer> largestDivisibleSubset_main(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        // 第 1 步：动态规划找出最大子集的个数、最大子集中的最大整数
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = dp[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 题目中说「没有重复元素」很重要
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        // 第 2 步：倒推获得最大子集
        List<Integer> res = new ArrayList<Integer>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }

        for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> integers = largestDivisibleSubset(new int[]{2, 3, 4, 9, 8});
        System.out.println(integers);
    }
}
