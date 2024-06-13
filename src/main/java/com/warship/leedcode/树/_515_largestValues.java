package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 */
public class _515_largestValues {

    /**
     * 层序遍历，获取每层最大值
     * <p>
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 85.03%
     * 的用户
     * 内存消耗：
     * 38.8 MB
     * , 在所有 Java 提交中击败了
     * 37.88%
     * 的用户
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> ans = new LinkedList();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cuNode = queue.poll();
                if (cuNode.val > max) {
                    max = cuNode.val;
                }
                if (cuNode.left != null) {
                    queue.offer(cuNode.left);
                }
                if (cuNode.right != null) {
                    queue.offer(cuNode.right);
                }
            }
            ans.add(max);
            max = Integer.MIN_VALUE;
        }
        return ans;
    }


    /**
     * 递归。给个“层” 参数。  ans 的index 就是层。
     * <p>
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.8 MB
     * , 在所有 Java 提交中击败了
     * 35.75%
     * 的用户
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues_DFS(TreeNode root) {
        List<Integer> result = new ArrayList();
        Largest(root, result, 0);
        return result;
    }

    private void Largest(TreeNode root, List<Integer> result, int level) {
        if (root == null) return;
        if (level == result.size()) {//新一层，直接添加
            result.add(root.val);
        } else {//老层。如果当前值更大，就更新。
            result.set(level, Math.max(result.get(level), root.val));
        }
        Largest(root.left, result, level + 1);    //递归左右
        Largest(root.right, result, level + 1);
    }
}
