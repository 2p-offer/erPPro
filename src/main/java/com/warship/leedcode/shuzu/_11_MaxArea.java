package com.warship.leedcode.shuzu;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * <p>
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * 提示：
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class _11_MaxArea {


    public static void main(String[] args) {
        _11_MaxArea clazz = new _11_MaxArea();
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = clazz.maxArea(nums);
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            int heightI = height[i];
            int heightJ = height[j];
            res = Math.max(res, Math.min(heightI, heightJ) * (j - i));
            if (heightI <= heightJ) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

}
