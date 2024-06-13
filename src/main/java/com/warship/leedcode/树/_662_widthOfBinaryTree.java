package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 662. 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 示例 1:
 *
 * 输入:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 *
 * 输入:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * 注意: 答案在32位有符号整数的表示范围内。
 *
 * 通过次数21,989提交次数54,786
 */
public class _662_widthOfBinaryTree {


    /**
     * 思路肯定没有问题，但是超时了。处理了太多的不必要的空节点
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree_Self(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int tmp1 = 0;
            int tmp2 = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cuNode = queue.poll();
                if (cuNode == null) {
                    if (tmp1 > 0) {
                        tmp2++;
                        queue.offer(null);
                        queue.offer(null);
                    }
                } else {
                    tmp1 = tmp1 + tmp2 + 1;
                    tmp2 = 0;
                    queue.offer(cuNode.left);
                    queue.offer(cuNode.right);
                }
            }
            if (tmp1 > ans) {
                ans = tmp1;
            }
        }
        return ans;
    }


    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 75.16%
     * 的用户
     * 内存消耗：
     * 38.2 MB
     * , 在所有 Java 提交中击败了
     * 34.77%
     * 的用户
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree_Main_BFS(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.poll();
            if (a.node != null) {
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                if (curDepth != a.depth) {
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }


    /**
     * <p>
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 17.76%
     * 的用户
     * 内存消耗：
     * 38.8 MB
     * , 在所有 Java 提交中击败了
     * 5.14%
     * 的用户
     */
    int ans;
    Map<Integer, Integer> left;

    public int widthOfBinaryTree_Main_DFS(TreeNode root) {
        ans = 0;
        left = new HashMap();
        dfs(root, 0, 0);
        return ans;
    }

    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        left.computeIfAbsent(depth, x -> pos);//如果depth对应value不存在，则将depth的value设置为pos
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }


}

class AnnotatedNode {
    TreeNode node;
    int depth, pos;

    AnnotatedNode(TreeNode n, int d, int p) {
        node = n;
        depth = d;
        pos = p;
    }

}
