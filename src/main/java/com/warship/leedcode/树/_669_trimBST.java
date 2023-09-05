package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

/**
 * 669. 修剪二叉搜索树
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案。
 *
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,0,2], low = 1, high = 2
 * 输出：[1,null,2]
 * 示例 2：
 *
 *
 * 输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * 输出：[3,2,null,1]
 * 示例 3：
 *
 * 输入：root = [1], low = 1, high = 2
 * 输出：[1]
 * 示例 4：
 *
 * 输入：root = [1,null,2], low = 1, high = 3
 * 输出：[1,null,2]
 * 示例 5：
 *
 * 输入：root = [1,null,2], low = 2, high = 4
 * 输出：[2]
 *
 *
 * 提示：
 *
 * 树中节点数在范围 [1, 104] 内
 * 0 <= Node.val <= 104
 * 树中每个节点的值都是唯一的
 * 题目数据保证输入是一棵有效的二叉搜索树
 * 0 <= low <= high <= 104
 */
public class _669_trimBST {
    /**
     * 迭代方式
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38 MB
     * , 在所有 Java 提交中击败了
     * 64.40%
     * 的用户
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST_Iterator(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        //先确定root 节点位置 low <= root.val <= high
        while (root != null) {
            if (root.val > high) {
                root = root.left;
                continue;
            }
            if (root.val < low) {
                root = root.right;
                continue;
            }
            break;
        }
        if (root == null) {
            return null;
        }
        TreeNode preNode = root;//被删除节点的上一个节点
        TreeNode cuNode = root.left;
        while (preNode != null && cuNode != null) {//处理root左子树
            if (cuNode.val < low) {//如果当前节点值 < low ,当前节点及其左子树要被删除，所以直接pre指向当前节点右子树
                preNode.left = cuNode.right;
                cuNode = preNode.left;
                continue;
            }
            preNode = cuNode;//当前节点>= low 则寻找下一个更小的节点
            cuNode = preNode.left;
        }
        preNode = root;
        cuNode = preNode.right;
        while (preNode != null && cuNode != null) {//处理root右子树，与左子树处理一致
            if (cuNode.val > high) {
                preNode.right = cuNode.left;
                cuNode = preNode.right;
                continue;
            }
            preNode = cuNode;
            cuNode = preNode.right;
        }
        return root;

    }

    /**
     * 这。。。。啥？？？
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST_BFS(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST_BFS(root.left, L, R);
        if (root.val < L) return trimBST_BFS(root.right, L, R);

        root.left = trimBST_BFS(root.left, L, R);
        root.right = trimBST_BFS(root.right, L, R);
        return root;
    }

}
