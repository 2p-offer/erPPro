package com.warship.test.leedcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例一：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例二：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * 1. 1 <= nums.length <= 10
 * 2. -10 <= nums[i] <= 10
 * 3. nums 中的所有元素 互不相同
 */
public class _78_Subsets {
    public static List<List<Integer>> res;
    public static List<List<Integer>> sonList = new ArrayList<>();

    /**
     * 在每个现有子集里加上自己
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets_addOne(int[] nums) {
        res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            subList(sonList, nums[i]);
        }
        return res;

    }

    private static void subList(List<List<Integer>> sonList, int currentNum) {
        sonList.clear();
        for (List<Integer> tmpList : res) {
            ArrayList<Integer> integers = new ArrayList<>(tmpList);
            integers.add(currentNum);
            sonList.add(integers);
        }
        res.addAll(sonList);

    }


    public List<List<Integer>> subSets_Huisu(int[] nums) {
        res = new ArrayList<>();
//        subSet_Huisu();
        return res;
    }


    public static void main(String[] args) {
        _78_Subsets test = new _78_Subsets();
        List<List<Integer>> subsets = test.subsets_addOne(new int[]{0});
        System.out.println(subsets);
    }
}
