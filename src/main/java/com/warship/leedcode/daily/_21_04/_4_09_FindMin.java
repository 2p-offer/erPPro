package com.warship.test.leedcode.daily._21_04;

public class _4_09_FindMin {

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
        return find_ErFen(nums, 0, nums.length - 1);
    }

    private static int find_ErFen(int[] nums, int start, int end) {
        if (end - start <= 1) {
            return Math.min(nums[start], nums[end]);
        }
        int middle = (end + start) / 2;
        if (nums[middle] < nums[end]) {
            return find_ErFen(nums, start, middle);
        } else if (nums[middle] > nums[end]) {
            return find_ErFen(nums, middle, end);
        } else {
            return Math.min(find_ErFen(nums, start, middle), find_ErFen(nums, middle, end));
        }
    }

    public static void main(String[] args) {
        int min_erFen = findMin_ErFen(new int[]{3, 3, 1, 3});

        System.out.println(min_erFen);
    }

}
