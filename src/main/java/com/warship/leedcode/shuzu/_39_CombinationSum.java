package com.warship.leedcode.shuzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 */
public class _39_CombinationSum {

    public static void main(String[] args) {
        _39_CombinationSum clazz = new _39_CombinationSum();
        List<List<Integer>> lists = clazz.combinationSum(new int[]{8, 7, 4, 3}, 11);
        System.out.println(lists);
    }

    /**
     * 自己的办法
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> allInt = new LinkedList<>();
        tmp(result, allInt, candidates, 0, target);
        return result;
    }

    public void tmp(List<List<Integer>> container, LinkedList<Integer> allInt, int[] candidates, int startIndex, int target) {
        int sum = 0;
        int addInt = candidates[startIndex];
        if (addInt > target) {
            return;
        }
        int addTimes = 0;
        while (sum < target) {
            allInt.add(addInt);
            sum += addInt;
            addTimes++;
        }
        if (sum == target) {
            container.add(new ArrayList<>(allInt));
        }
        for (int i = 0; i < addTimes; i++) {
            sum -= addInt;
            allInt.removeLast();
            if (startIndex < candidates.length - 1) {
                tmp(container, allInt, candidates, startIndex + 1, target - sum);
            }
        }
    }


    // ===== 看起来还不错的题解

    List<Integer> path = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum_(int[] candidates, int target) {
        rollBack(candidates, target, 0, 0);
        return res;
    }

    public void rollBack(int[] nums, int target, int index, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) return;
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            sum += nums[i];
            rollBack(nums, target, i, sum);
            path.remove(path.size() - 1);
            sum -= nums[i];
        }
    }
}
