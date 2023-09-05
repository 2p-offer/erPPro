package com.warship.test.leedcode.树;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 *
 * 提示：
 *
 * 数组长度 <= 1000
 */
public class _jianzhi_33_verifyPostorder {

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 35.9 MB
     * , 在所有 Java 提交中击败了
     * 36.97%
     * 的用户
     * @param postorder
     * @return
     */
    public boolean verifyPostorder_DFS(int[] postorder) {
        if (postorder == null) {
            return false;
        }
        return dfs(postorder, 0, postorder.length - 1);
    }

    private boolean dfs(int[] postorder, int start, int end) {
        if (end <= start) {
            return true;
        }
        int root = postorder[end];//start - end 组成树的根节点
        //找到根节点的左子树和右子树区间
        int leftEnd = start;//第一个大于 跟节点的节点索引
        while (postorder[leftEnd] < root) {
            leftEnd++;
        }
        int rightEnd = leftEnd;
        while (rightEnd < end) {//一旦当前大于root。后面都要大于root
            if (postorder[rightEnd] < root) {
                return false;
            }
            rightEnd++;
        }

        return dfs(postorder, start, leftEnd - 1) && dfs(postorder, leftEnd, end - 1);
    }
}
