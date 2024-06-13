package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 *
 * 示例 2：
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 *
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 *
 * 提示：
 * 树中节点的数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 9
 * 树的深度不超过 10
 */
public class _129_sumNumbers {


    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 35.9 MB
     * , 在所有 Java 提交中击败了
     * 62.88%
     * 的用户
     * <p>
     * 深度优先，  DFS
     *
     * @param root
     * @return
     */
    public int sumNumbers_DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dealNode(root, 0);
    }

    private int dealNode(TreeNode node, int currentNum) {
        currentNum *= 10;
        currentNum += node.val;
        if (node.left == null && node.right == null) {
            return currentNum;
        }
        int res = 0;
        if (node.left != null) {
            res += dealNode(node.left, currentNum);
        }
        if (node.right != null) {
            res += dealNode(node.right, currentNum);
        }
        return res;
    }


    /**
     * 广度优先搜索
     *
     * 行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 26.30%
     * 的用户
     * 内存消耗：
     * 36.1 MB
     * , 在所有 Java 提交中击败了
     * 15.55%
     * 的用户
     *
     * 和官方代码可以说是一模一样，官方的就不贴了
     * @param root
     * @return
     */
    public int sumNumbers_BFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();
        int sum = 0;
        queue.offer(root);
        res.offer(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                int currentNum = res.poll();
                if (currentNode.left == null && currentNode.right == null) {
                    sum += currentNum;
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                    res.offer(currentNum * 10 + currentNode.left.val);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                    res.offer(currentNum * 10 + currentNode.right.val);
                }
            }
        }
        return sum;
    }


}
