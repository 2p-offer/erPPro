package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

/**
 * 080. 根到叶路径上的不足节点
 * 给定一棵二叉树的根 root，请你考虑它所有 从根到叶的路径：从根到任何叶的路径。（所谓一个叶子节点，就是一个没有子节点的节点）
 * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为「不足节点」，需要被删除。
 * 请你删除所有不足节点，并返回生成的二叉树的根。
 *
 * 示例 1：
 * * 输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
 * 输出：[1,2,3,4,null,null,7,8,9,null,14]
 *
 * 示例 2：
 * 输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
 * 输出：[5,4,8,11,null,17,4,7,null,null,null,5]
 *
 * 示例 3：
 * 输入：root = [5,-6,-6], limit = 0
 * 输出：[]
 * 提示：
 * 给定的树有 1 到 5000 个节点
 * -10^5 <= node.val <= 10^5
 * -10^9 <= limit <= 10^9
 */
public class _1080_SufficientSubset {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        int nodeSum = getNodeSum(root, limit);
        if (nodeSum < limit) {
            return null;
        }
        return root;
    }

    /**
     * 返回当前节点到所有叶子节点路径和的最大值
     *
     * @param node
     * @param limit
     * @return
     */
    public int getNodeSum(TreeNode node, int limit) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        if (node.left == null && node.right == null) {
            return node.val;
        }
        int nextLimt = limit - node.val;
        int leftSum = getNodeSum(node.left, nextLimt);
        int rightSum = getNodeSum(node.right, nextLimt);
        if (node.left != null && leftSum < nextLimt) {
            node.left = null;
        }
        if (node.right != null && rightSum < nextLimt) {
            node.right = null;
        }
        return Math.max(leftSum, rightSum) + node.val;
    }

    @Deprecated
    public TreeNode sufficientSubset_(TreeNode root, int limit) {
        if (root.left == null && root.right == null) {
            return root;
        }
        int leftVal = Integer.MIN_VALUE;
        int rightVal = Integer.MIN_VALUE;
//        int rootVal = Integer.MIN_VALUE;
        if (root.left != null) {
            int tmp1 = root.left.val;
            TreeNode leftTreeNode = sufficientSubset(root.left, limit);
            leftVal = leftTreeNode.val;
            if (leftVal < limit) {
                root.left = null;
            } else {
                root.left.val = tmp1;
            }

        }
        if (root.right != null) {
            int tmp2 = root.right.val;
            TreeNode rightTreeNode = sufficientSubset(root.right, limit);
            rightVal = rightTreeNode.val;
            if (rightVal < limit) {
                root.right = null;
            } else {
                root.right.val = tmp2;
            }
        }
//        if (leftVal != Integer.MIN_VALUE) {
//            rootVal = Math.max(leftVal, rightVal);
//        }
//
//        if (rightVal != Integer.MIN_VALUE) {
//            rootVal = Math.max(rightVal, rootVal);
//        }
        root.val += Math.max(leftVal, rightVal);
        return root;
    }


    public static void main(String[] args) {
        _1080_SufficientSubset test = new _1080_SufficientSubset();
        TreeNode t1 = new TreeNode(-5, null, null);
        TreeNode t2 = new TreeNode(4, null, null);
        TreeNode t3 = new TreeNode(2, t1, null);
        TreeNode t4 = new TreeNode(-3, t2, null);
        TreeNode t5 = new TreeNode(1, t3, t4);
//        TreeNode t333 = new TreeNode(4, t3, null);
//        TreeNode t11 = new TreeNode(5, null, null);
//        TreeNode t22 = new TreeNode(3, null, null);
//        TreeNode t33 = new TreeNode(4, t11, t22);
//        TreeNode t111 = new TreeNode(17, null, null);

//        TreeNode t7 = new TreeNode(8, t111, t33);
//        TreeNode t5 = new TreeNode(5, t333, t7);

        TreeNode treeNode = test.sufficientSubset(t5, -1);
        System.out.println(treeNode);
    }
}


;