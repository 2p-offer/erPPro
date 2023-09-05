package com.warship.test.leedcode.daily._21_04;

/**
 * 153. 寻找旋转排序数组中的最小值
 * <p>
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 4 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * <p>
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
 * <p>
 * 示例 3：
 * 输入：nums = [11,13,15,17]
 * 输出：11
 * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
 */

public class _4_08_FindMin {

    /**
     * 正常人思维，遍历，变小就说明是最小。时间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < pre) {
                return nums[i];
            }
            pre = nums[i];
        }
        return 0;
    }

    /**
     * 二分  O(logn)
     *
     * @param nums
     * @return
     */
    public static int findMin_ErFen(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        return find_ErFen(nums, 0, nums.length - 1);
    }

    private static int find_ErFen(int[] nums, int start, int end) {
        if (end - start <= 1) {
            return Math.min(nums[start], nums[end]);
        }
        int middle = (end + start) / 2;
        if (nums[middle] < nums[end]) {
            return find_ErFen(nums, start, middle);
        } else {
            return find_ErFen(nums, middle, end);
        }


    }

    public static void main(String[] args) {
        int min = findMin_ErFen(new int[]{3, 4, 5, 1, 2});
        System.out.println(min);
    }
}
