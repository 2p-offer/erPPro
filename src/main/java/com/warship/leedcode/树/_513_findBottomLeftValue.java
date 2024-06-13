package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *
 *
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 */
public class _513_findBottomLeftValue {

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 65.38%
     * 的用户
     * 内存消耗：
     * 38 MB
     * , 在所有 Java 提交中击败了
     * 72.53%
     * 的用户
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cuNode = queue.poll();
                if (i == 0) {
                    ans = cuNode.val;
                }
                if (cuNode.left != null) {
                    queue.offer(cuNode.left);
                }
                if (cuNode.right != null) {
                    queue.offer(cuNode.right);
                }
            }
        }
        return ans;
    }
}
