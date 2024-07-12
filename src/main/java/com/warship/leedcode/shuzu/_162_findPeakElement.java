package com.warship.leedcode.shuzu;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 */
public class _162_findPeakElement {

    public static void main(String[] args) {
        _162_findPeakElement clazz = new _162_findPeakElement();
        System.out.println(clazz.findPeakElement(new int[]{6, 5, 4, 3, 2, 3, 2}));
    }

    public int findPeakElement(int[] nums) {
        int res = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (right - left == 0) {
                return left;
            }
            if (right - left == 1) {
                return nums[left] > nums[right] ? left : right;
            }
            int mid = (left + right) / 2;
            int midNum = nums[mid];
            if (midNum < nums[mid - 1]) {
                right = mid;
            } else if (midNum < nums[mid + 1]) {
                left = mid;
            } else {
                return mid;
            }
        }
        return res;
    }
}