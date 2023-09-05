package com.warship.test.leedcode.daily._21_04;

/**
 * 面试题 17.21. 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 */
public class _4_02_Trap {

    public static int trap(int[] height) {

        int res = 0;
        if (height == null || height.length == 0) {
            return 0;
        }

        int higherIndex = 0;
        int higher = height[0];
        for (int i = 0; i < height.length; i++) {
            if (higher < height[i]) {
                higher = height[i];
                higherIndex = i;
            }
        }

        int max = 0;
        for (int a = 0; a < higherIndex; a++) {
            if (height[a] > max) {
                max = height[a];
                continue;
            }
            res += (max - height[a]);
        }
        max = 0;
        for (int b = height.length - 1; b > higherIndex; b--) {
            if (height[b] > max) {
                max = height[b];
                continue;
            }
            res += (max - height[b]);
        }

        return res;
    }

//    public static void addWater(int[] height, int start, int end) {
//        if (end - start <= 1 || end >= height.length - 1 || start <= 0) {
//            return;
//        }
//        int higherIndex = start;
//        int higher = height[start];
//        for (int i = start + 1; i < end; i++) {
//        }
//
//    }

    public static void main(String[] args) {
        int trap = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);

    }
}
