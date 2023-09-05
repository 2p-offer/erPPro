package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * <p>
 * 提示：
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * <p>
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */
public class _230_kthSmallest {

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.5 MB
     * , 在所有 Java 提交中击败了
     * 35.24%
     * 的用户
     */
    int res = -1;
    int index;
    int target;

    public int kthSmallest_Self(TreeNode root, int k) {
        index = 1;
        target = k;
        TreeNode res = dfs(root);
        return res == null ? -1 : res.val;
    }

    private TreeNode dfs(TreeNode node) {
        if (node.left != null) {//一直找左节点，找不到左节点，说明当前是最小节点
            TreeNode leftNode = dfs(node.left);
            if (leftNode != null) {
                return leftNode;
            }
        }
        if (target == index) {//找到了k节点，直接返回
            return node;
        }
        index++;//去找第index个小节点
        if (node.right != null) {
            return dfs(node.right);//找右边
        }
        return null;
    }


    /**
     * 官方解答，中序遍历所有节点，找第K个。
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest_Main_I(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }


    /**
     * 官方解答 迭代搜索。
     *
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.3 MB
     * , 在所有 Java 提交中击败了
     * 62.03%
     * 的用户
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest_Main_II(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
