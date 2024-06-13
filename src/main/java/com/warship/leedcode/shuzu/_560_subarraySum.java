package  com.warship.leedcode.shuzu;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class _560_subarraySum {
    /**
     * 执行用时：
     * 1831 ms
     * , 在所有 Java 提交中击败了
     * 5.01%
     * 的用户
     * 内存消耗：
     * 40.8 MB
     * , 在所有 Java 提交中击败了
     * 76.51%
     * 的用户
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];//前缀和
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];//预处理数据，得到前缀和
        }
        int ans = 0;
        for (int x = 1; x < preSum.length; x++) {//遍历所有前缀和
            for (int y = 0; y < x; y++) {
                if (preSum[x] - preSum[y] == k) {//num[x] ... num[y] 之间的和 =  preSum[y]- preSum[x]
                    ans++;
                }
            }
        }
        return ans;

    }


    /**
     * 执行用时：
     * 26 ms
     * , 在所有 Java 提交中击败了
     * 86.29%
     * 的用户
     * 内存消耗：
     * 40.8 MB
     * , 在所有 Java 提交中击败了
     * 68.95%
     * 的用户
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum_II(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();//前缀和 值： 前缀和出现次数
        preSum.put(0, 1);
        int pSum = 0;// 0 - i 的和
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            pSum += nums[i];
            int target = pSum - k;//我们想找的值,之前在 i 之前，出现过前缀和 nums[0] - nums[x] = target 的。就说明 x - i 之间的和为k
            if (preSum.containsKey(target)) {
                ans += preSum.get(target);
            }
            preSum.put(pSum, preSum.getOrDefault(pSum, 0) + 1);
        }
        return ans;
    }
}
