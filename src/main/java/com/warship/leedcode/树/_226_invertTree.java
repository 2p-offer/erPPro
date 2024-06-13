package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _226_invertTree {

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 35.7 MB
     * , 在所有 Java 提交中击败了
     * 82.28%
     * 的用户
     *
     * @param root
     * @return
     */
    public TreeNode invertTree_DFS(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        dfs(node.left);
        dfs(node.right);
    }


    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 35.6 MB
     * , 在所有 Java 提交中击败了
     * 91.26%
     * 的用户
     *
     * @param root
     * @return
     */
    public TreeNode invertTree_BFS(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cuNode = queue.poll();
                TreeNode tmp = cuNode.left;
                cuNode.left = cuNode.right;
                cuNode.right = tmp;
                if (cuNode.left != null) {
                    queue.offer(cuNode.left);
                }
                if (cuNode.right != null) {
                    queue.offer(cuNode.right);
                }
            }
        }
        return root;
    }
}
