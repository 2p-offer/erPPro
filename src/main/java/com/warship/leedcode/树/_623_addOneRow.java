package  com.warship.leedcode.树;

import java.util.*;

import  com.warship.leedcode.helper.TreeNode;

/**
 * 623. 在二叉树中增加一行
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 * <p>
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 * <p>
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 * <p>
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 二叉树如下所示:
 * 4
 * /   \
 * 2     6
 * / \   /
 * 3   1 5
 * <p>
 * v = 1
 * <p>
 * d = 2
 * <p>
 * 输出:
 * 4
 * / \
 * 1   1
 * /     \
 * 2       6
 * / \     /
 * 3   1   5
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * 二叉树如下所示:
 * 4
 * /
 * 2
 * / \
 * 3   1
 * <p>
 * v = 1
 * <p>
 * d = 3
 * <p>
 * 输出:
 * 4
 * /
 * 2
 * / \
 * 1   1
 * /     \
 * 3       1
 * 注意:
 * <p>
 * 输入的深度值 d 的范围是：[1，二叉树最大深度 + 1]。
 * 输入的二叉树至少有一个节点。
 */
public class _623_addOneRow {


    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 89.46%
     * 的用户
     * 内存消耗：
     * 38 MB
     * , 在所有 Java 提交中击败了
     * 90.12%
     * 的用户
     *
     * @param root
     * @param val
     * @param depth
     * @return
     */
    public TreeNode addOneRow_BFS(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cuDepth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cuNode = queue.poll();
                if (cuDepth == depth - 1) {
                    TreeNode left = new TreeNode(val, cuNode.left, null);
                    TreeNode right = new TreeNode(val, null, cuNode.right);
                    cuNode.left = left;
                    cuNode.right = right;
                }
                if (cuNode.left != null) {
                    queue.offer(cuNode.left);
                }
                if (cuNode.right != null) {
                    queue.offer(cuNode.right);
                }
            }
            cuDepth++;
            if (cuDepth == depth) {
                break;
            }
        }
        return root;
    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 89.46%
     * 的用户
     * 内存消耗：
     * 38.3 MB
     * , 在所有 Java 提交中击败了
     * 51.73%
     * 的用户
     *
     * @param root
     * @param val
     * @param depth
     * @return
     */
    public TreeNode addOneRow_DFS(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        dfs(root, val, depth - 1);
        return root;
    }

    private void dfs(TreeNode node, int val, int depth) {
        if (depth == 1 || node == null) {
            if (node != null) {
                TreeNode left = new TreeNode(val, node.left, null);
                TreeNode right = new TreeNode(val, null, node.right);
                node.left = left;
                node.right = right;
            }
            return;
        }
        dfs(node.left, val, depth - 1);
        dfs(node.right, val, depth - 1);
    }

    public static void main(String[] args) {
        StringBuilder decodeSb = new StringBuilder("").append(",").append(1).append(",").append(1);
        System.out.println(decodeSb.toString());
    }


}
