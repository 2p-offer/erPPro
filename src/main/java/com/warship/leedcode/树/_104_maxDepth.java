package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.LinkedList;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class _104_maxDepth {


    /**
     * 广度优先 BFS
     *
     *执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了 16.45% 的用户
     * 内存消耗：
     * 38.1 MB
     * , 在所有 Java 提交中击败了 94.98% 的用户
     *
     * @param root
     * @return
     */
    public int maxDepth_BFS(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            res++;
        }
        return res;
    }


    int res = 0;

    /**DFS
     *执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了 100.00%的用户
     * 内存消耗：
     * 38.1 MB
     * , 在所有 Java 提交中击败了 90.63% 的用户
     * @param root
     * @return
     */
    public int maxDepth_DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        DFS(root, 0);
        return res;
    }

    private void DFS(TreeNode node, int depth) {
        if (node == null) {
            res = Math.max(res, depth);
            return;
        }
        DFS(node.left, depth + 1);
        DFS(node.right, depth + 1);
    }


    /**
     * 总是会感觉，官方的解法更优雅。
     *
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗：
     * 38.3 MB
     * , 在所有 Java 提交中击败了 75.17% 的用户
     * @param root
     * @return
     */
    public int maxDepth_DFS_Main(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth_DFS_Main(root.left);
            int rightHeight = maxDepth_DFS_Main(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
