package com.warship.test.leedcode.daily._21_04;

import com.warship.test.leedcode.helper.TreeNode;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * <p>
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 * <p>
 * 提示：
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 */
public class _4_27_RangeSumBST {
    int res = 0;
    int low;
    int high;

    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        dealNode(root);
        return res;
    }

    private void dealNode(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val >= low) {
            dealNode(root.left);
        }
        if (root.val >= low && root.val <= high) {
            res += root.val;
        }
        if (root.val <= high) {
            dealNode(root.right);
        }
    }


    public int rangeSumBST_(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val >= low) {
            res += rangeSumBST_(root.left, low, high);
        }
        if (root.val >= low && root.val <= high) {
            res += root.val;
        }
        if (root.val <= high) {
            rangeSumBST_(root.right, low, high);
        }
        return -1;
    }


    public static void main(String[] args) {
        _4_27_RangeSumBST test = new _4_27_RangeSumBST();
        test.dealNode(null);
    }
}
