package com.warship.test.leedcode.回溯;

import com.alibaba.fastjson2.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 2p
 * @date 2021/9/9 23:51
 * @desc _46_permute
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class _46_permute {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> container = new LinkedList<>();
        doTask(nums, container);
        return res;
    }

    private void doTask(int[] nums, LinkedList<Integer> container) {
        if (container.size() == nums.length) {
            res.add(new LinkedList<>(container));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (container.contains(nums[i])) {
                continue;
            }
            container.add(nums[i]);
            doTask(nums, container);
            container.removeLast();
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        //结果集
        List<List<Integer>> res = new ArrayList<>();
        //已选择列表
        LinkedList<Integer> selected = new LinkedList<>();
        //已选择列表，用于O(1)判断当前元素是否已经被选择（用来优化遍历selected判断是否已经选择）
        boolean[] used = new boolean[nums.length];
        dealNums(res, selected, used, nums);
        return res;
    }

    private void dealNums(List<List<Integer>> res, LinkedList<Integer> selected, boolean[] used, int[] nums) {
        if (selected.size() == nums.length) {
            res.add(new ArrayList<>(selected));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            selected.addLast(nums[i]);
            used[i] = true;
            dealNums(res, selected, used, nums);
            selected.removeLast();
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        _46_permute test = new _46_permute();
        List<List<Integer>> lists = test.permute2(new int[]{1, 2, 3});
        System.out.println(JSONObject.toJSONString(lists));

    }

}
