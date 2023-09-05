package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 */
public class _144_preorderTraversal {

    List<Integer> res;

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 36.7 MB
     * , 在所有 Java 提交中击败了
     * 44.60%
     * 的用户
     *
     * 递归的方式遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_DFS(TreeNode root) {
        res = new LinkedList<>();
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }


    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 48.90%
     * 的用户
     * 内存消耗：
     * 36.6 MB
     * , 在所有 Java 提交中击败了
     * 78.16%
     * 的用户
     *
     * 迭代的方式遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_Iterator(TreeNode root) {

        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cuNode = stack.pop();
            res.add(cuNode.val);
            if (cuNode.right != null) {
                stack.push(cuNode.right);
            }
            if (cuNode.left != null) {
                stack.push(cuNode.left);
            }
        }
        return res;
    }
}
