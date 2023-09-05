package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

import java.util.*;

/**
 * 508. 出现次数最多的子树元素和
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 示例 1：
 * 输入:
 *
 *   5
 *  /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 示例 2：
 * 输入：
 *
 *   5
 *  /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 *
 *
 *
 * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
 */
public class _508_findFrequentTreeSum {

    /**
     * 执行用时：
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 36.18%
     * 的用户
     * 内存消耗：
     * 38.9 MB
     * , 在所有 Java 提交中击败了
     * 49.13%
     * 的用户
     */
    Map<Integer, Integer> ans;//节点和：出现次数

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return null;
        }
        ans = new HashMap();
        dfs(root);
        return getRes();
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int val = node.val + dfs(node.left) + dfs(node.right);
        ans.put(val, ans.getOrDefault(val, 0) + 1);
        return val;
    }

    private int[] getRes() {
        int max = Integer.MIN_VALUE;//当前最大出现次数
        List<Integer> res = new ArrayList();
        for (Map.Entry<Integer, Integer> entry : ans.entrySet()) {
            if (entry.getValue() > max) {
                res.clear();
                max = entry.getValue();
                res.add(entry.getKey());
            } else if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    //=======================================================
    /**
     * 4 ms	38.8 MB
     * <p>
     * 这个b的思路，就可取。相当于在递归内部，已经确定了 max。 到时候遍历map的时候，不需要每个都操作list。只有等于max的在追加到list。
     * 省去了冗余数据添加到list。然后在某个地方又clear list 的操作
     */
    private int maxcount = 1;//记录子树元素的最大重复个数

    public int[] findFrequentTreeSum_II(TreeNode root) {
        Map<Integer, Integer> hash = new HashMap<>();//记录子树元素和，以及出现的频数
        getSumAndCount(root, hash);
        int l = 0;
        Set Keys = hash.keySet();
        List<Integer> list = new ArrayList<>();
        for (Object k : Keys) {         //遍历hashmap
            if (hash.get(k) == maxcount) list.add((int) k);
        }
        int[] ans = new int[list.size()];
        while (l < list.size()) ans[l] = list.get(l++);
        return ans;
    }

    private int getSumAndCount(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int l_sum = getSumAndCount(root.left, map);//求当前节点的左子树的"子树元素和"
        int r_sum = getSumAndCount(root.right, map);//求当前节点的右子树的"子树元素和"
        int ret = root.val + l_sum + r_sum;//该节点的子树元素和（也是返回值）
        if (map.containsKey(ret)) {//如果hashmap中包含这个"子树元素和"的值
            int temp = map.get(ret) + 1;
            map.put(ret, temp);//更新hashmap中的键值对
            if (maxcount < temp) maxcount = temp;//比较并更新“子树数元素和”的最大重复个数
        } else map.put(ret, 1);//如果不存在，直接存入即可
        return ret;
    }

}
