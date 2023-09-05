package com.warship.test.leedcode.回溯;


import com.alibaba.fastjson2.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 2p
 * @date 2021/9/10 16:01
 * @desc _47_permuteUnique
 * <p>
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class _47_permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        LinkedList<Integer> selected = new LinkedList<>();
        dealNums(nums, res, used, selected);
        return res;
    }

    private void dealNums(int[] nums, List<List<Integer>> res, boolean[] used, LinkedList<Integer> selected) {
        if (selected.size() == nums.length) {
            res.add(new ArrayList<>(selected));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            //判断是否重复
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }

            selected.addLast(nums[i]);
            used[i] = true;
            dealNums(nums, res, used, selected);
            selected.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        _47_permuteUnique test = new _47_permuteUnique();
        List<List<Integer>> lists = test.permuteUnique(new int[]{1, 2, 3, 1});
        System.out.println(JSONObject.toJSONString(lists));
    }
}
