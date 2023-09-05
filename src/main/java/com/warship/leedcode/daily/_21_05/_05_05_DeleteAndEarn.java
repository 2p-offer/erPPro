package com.warship.test.leedcode.daily._21_05;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 740. 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * 示例 1：

 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 */
public class _05_05_DeleteAndEarn {

    /**
     * 我们设 F(i) 为 nums[0] - nums[i] 可以获得的 最大点数
     * 状态转移方程：
     * <p>
     * 当 nums[i-1] = nums[i] - 1 时，存在两种情况，
     * 1.nums[i] 被删除 ，F(i) = F(i-1);
     * 2.nums[i] 被留下，F(i) = F(i-2) + nums[i] * 连续出现次数;
     * <p>
     * 当nums[i] - nums[i-1] > 1 时，则 F(i) = F(i-1) + nums[i] * 连续出现次数;
     * <p>
     * 当 nums[]
     * <p>
     * F(i) = MAX(F(i-1),F(i-2) + nums[i]);
     *
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        List<int[]> container = new ArrayList<>();
        int pre = 0;
        int preSum = 0;
        for (int num : nums) {
            if (num == pre) {
                preSum += num;
            } else {
                container.add(new int[]{pre, preSum});
                pre = num;
                preSum = pre;
            }
        }
        container.add(new int[]{pre, preSum});
        if (container.size() == 2) {
            return container.get(1)[1];
        }
        //存放上一个  nums[i-1]
        pre = 0;
        //存放前一个  nums[i-2]
        preSum = 0;
        int[] dp = new int[container.size()];
        dp[1] = container.get(1)[1];
        if (container.get(2)[0] - container.get(1)[0] == 1) {
            dp[2] = Math.max(dp[1], container.get(2)[1]);
        } else {
            dp[2] = container.get(2)[1] + dp[1];
        }
        for (int i = 3; i < container.size(); i++) {
            if (container.get(i)[0] - container.get(i - 1)[0] == 1) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + container.get(i)[1]);
            } else {
                dp[i] = container.get(i)[1] + dp[i - 1];
            }

        }
        return dp[container.size() - 1];
    }


    /**
     * 官方题解1
     * @param nums
     * @return
     */
    public int deleteAndEarn_I(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob_I(sum);
    }

    public int rob_I(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }


    /**
     * 官方题解II
     * @param nums
     * @return
     */
    public int deleteAndEarn_II(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        List<Integer> sum = new ArrayList<Integer>();
        sum.add(nums[0]);
        int size = 1;
        for (int i = 1; i < n; ++i) {
            int val = nums[i];
            if (val == nums[i - 1]) {
                sum.set(size - 1, sum.get(size - 1) + val);
            } else if (val == nums[i - 1] + 1) {
                sum.add(val);
                ++size;
            } else {
                ans += rob_II(sum);
                sum.clear();
                sum.add(val);
                size = 1;
            }
        }
        ans += rob_II(sum);
        return ans;
    }

    public int rob_II(List<Integer> nums) {
        int size = nums.size();
        if (size == 1) {
            return nums.get(0);
        }
        int first = nums.get(0), second = Math.max(nums.get(0), nums.get(1));
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums.get(i), second);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        _05_05_DeleteAndEarn test = new _05_05_DeleteAndEarn();
        int i = test.deleteAndEarn(new int[]{2, 3});
        System.out.println(i);
    }
}
