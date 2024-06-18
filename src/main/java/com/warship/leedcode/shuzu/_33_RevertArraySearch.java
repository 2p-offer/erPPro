package com.warship.leedcode.shuzu;

/**
 * 二分查找
 * <p>
 * <p>
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 */
public class _33_RevertArraySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        _33_RevertArraySearch clzz = new _33_RevertArraySearch();
        int search = clzz.search(nums, 0);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int start, int end, int target) {
        if (start == end || start + 1 == end) {
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] > nums[start]) {
            if (nums[mid] >= target && nums[start] <= target) {
                return search(nums, start, mid, target);
            } else {
                return search(nums, mid + 1, end, target);
            }
        }

        if (nums[mid] < nums[end]) {
            if (nums[mid] <= target && nums[end] >= target) {
                return search(nums, mid, end, target);
            } else {
                return search(nums, start, mid - 1, target);
            }
        }
        return -1;
    }
}
