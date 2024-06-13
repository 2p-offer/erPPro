package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _112_hasPathSum {

    int targetSum;

    /**
     * root == null return false;
     * root == [1] sum == 1 return true;
     * [1,2] 1 return fasle. 是我对树的节点理解有问题嘛？
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        this.targetSum = targetSum;
        return dfs(root, 0);
    }

    public boolean dfs(TreeNode node, int currentNum) {
        if (node == null) {
            return currentNum == targetSum;
        }
        currentNum += node.val;
        return dfs(node.left, currentNum) || dfs(node.right, currentNum);
    }


    /**
     * 0 ms	38.6 MB
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum_DFS_Main(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum_DFS_Main(root.left, targetSum - root.val) || hasPathSum_DFS_Main(root.right, targetSum - root.val);
    }

    /**
     * bfs
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 11.86%
     * 的用户
     * 内存消耗：
     * 38.1 MB
     * , 在所有 Java 提交中击败了
     * 90.91%
     * 的用户
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum_BFS(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();
        queueNode.offer(root);
        queueVal.offer(root.val);
        while (!queueNode.isEmpty()) {
            TreeNode currentNode = queueNode.poll();
            int currentVal = queueVal.poll();
            if (currentNode.left == null && currentNode.right == null) {
                if (targetSum == currentVal)
                    return true;
            }
            if (currentNode.left != null) {
                queueNode.offer(currentNode.left);
                queueVal.offer(currentVal + currentNode.left.val);
            }
            if (currentNode.right != null) {
                queueNode.offer(currentNode.right);
                queueVal.offer(currentVal + currentNode.right.val);
            }
        }
        return false;
    }


}
