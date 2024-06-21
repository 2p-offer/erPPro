package com.warship.leedcode.shuzu;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 */
public class _75_SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        _75_SortColors clazz = new _75_SortColors();
        clazz.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return;
        }
        int currentColor = 0;
        int i = 0;
        int j;
        while (i < length) {
            while (i < length && nums[i] == currentColor) {
                i++;
            }
            j = i + 1;
            while (j < length) {
                if (nums[j] == currentColor) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    i++;
                }
                j++;
            }
            currentColor++;
        }
    }
}
