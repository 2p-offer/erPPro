package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class _98_isValidBST {

    long min = Long.valueOf(Integer.MIN_VALUE) - 1;

    public boolean isValidBST(TreeNode root) {
        return dealNode(root);
    }

    private boolean dealNode(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (!dealNode(node.left)) {
            return false;
        }
        if (min >= node.val) {
            return false;
        } else {
            min = node.val;
        }
        if (!dealNode(node.right)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _98_isValidBST test = new _98_isValidBST();
        boolean validBST = test.isValidBST(TreeNode.array2Tree(new Integer[]{2, 1, 3}));
        System.out.println(validBST);
    }
}
