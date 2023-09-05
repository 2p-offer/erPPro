package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 */
public class _538_convertBST {

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 84.95%
     * 的用户
     * 内存消耗：
     * 38.7 MB
     * , 在所有 Java 提交中击败了
     * 57.55%
     * 的用户
     * @param root
     * @return
     */
    public TreeNode convertBST_DFS(TreeNode root) {
        if (root == null) {
            return root;
        }
        dfs(root, 0);
        return root;
    }

    private int dfs(TreeNode node, int preSum) {
        if (node == null) {
            return preSum;
        }
        int right = dfs(node.right, preSum);
        node.val += right;
        return dfs(node.left, node.val);
    }
}
