package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

/**
 * 814. 二叉树剪枝
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 *
 * 示例1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 *
 * 示例2:
 * 输入: [1,0,1,0,0,0,1]
 * 输出: [1,null,1,null,1]
 *
 * 示例3:
 * 输入: [1,1,0,1,1,0,1,0]
 * 输出: [1,1,0,1,1,null,1]
 *
 * 说明:
 * 给定的二叉树最多有 100 个节点。
 * 每个节点的值只会为 0 或 1 。
 */
public class _814_PruneTree {

    TreeNode res = new TreeNode(-1, null, null);

    public TreeNode pruneTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        //这个判断,不加一样可以通过，加上会省略层叶子结点（N,null,null）的递归，从测试卷结果来看，能稍微提升内存消耗（栈空间）
        if ((root.left == null && root.right == null && root.val == 0)) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return (root.left == null && root.right == null && root.val == 0) ? null : root;

    }

    public static void main(String[] args) {
        _814_PruneTree test = new _814_PruneTree();
        TreeNode t1 = new TreeNode(0, null, null);
        TreeNode t2 = new TreeNode(0, null, null);
        TreeNode t3 = new TreeNode(0, null, null);
        TreeNode t4 = new TreeNode(1, null, null);
        TreeNode t5 = new TreeNode(0, t1, t2);
        TreeNode t6 = new TreeNode(1, t3, t4);

        TreeNode t7 = new TreeNode(1, t5, t6);
        test.pruneTree(t7);
        System.out.println(t7.val);
    }

}
