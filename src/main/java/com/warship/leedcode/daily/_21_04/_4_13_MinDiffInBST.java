package com.warship.test.leedcode.daily._21_04;

import com.warship.test.leedcode.helper.TreeNode;

/**
 * 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 示例1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 * 示例2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 * 提示：
 *
 * 树中节点数目在范围 [2, 100] 内
 * 0 <= Node.val <= 10^5
 */
public class _4_13_MinDiffInBST {
    static int res = Integer.MAX_VALUE;
    static int pre = -1;

    public static int minDiffInBST(TreeNode root) {
        diguibianli(root);
        return res;
    }

    private static void diguibianli(TreeNode root) {
        if (root == null) {
            return;
        }
        diguibianli(root.left);
        if (pre != -1) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val;
        diguibianli(root.right);
    }

    public static void main(String[] args) {

        TreeNode t5 = new TreeNode(49, null, null);

        TreeNode t4 = new TreeNode(12, null, null);

        TreeNode t3 = new TreeNode(48, t4, t5);

        TreeNode t2 = new TreeNode(0, null, null);
        TreeNode t1 = new TreeNode(1, t2, t3);
        int i = minDiffInBST(t1);
        System.out.println(i);

    }


}
