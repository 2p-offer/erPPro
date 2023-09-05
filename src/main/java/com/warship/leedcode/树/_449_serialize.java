package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 449. 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * 编码的字符串应尽可能紧凑。
 *
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 提示：
 * 树中节点数范围是 [0, 104]
 * 0 <= Node.val <= 104
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 */
public class _449_serialize {

    /**
     * 执行用时：
     * 12 ms
     * , 在所有 Java 提交中击败了
     * 55.92%
     * 的用户
     * 内存消耗：
     * 39.3 MB
     * , 在所有 Java 提交中击败了
     * 71.86%
     * 的用户
     *
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cuNode = queue.poll();
                if (cuNode == null) {
                    ans.append("n");
                } else {
                    queue.offer(cuNode.left);
                    queue.offer(cuNode.right);
                    ans.append(cuNode.val);
                }
                ans.append(",");
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] source = data.split(",");
        if ("n".equals(source[0])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(source[0]));
        dealArray(source, root);
        return root;
    }


    private void dealArray(String[] array, TreeNode node) {
        if (node == null) {
            return;
        }
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty() && index < array.length - 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = queue.poll();
                if (index < array.length - 1 && !"n".equals(array[++index])) {
                    TreeNode leftNode = new TreeNode(Integer.valueOf(array[index]));
                    tmpNode.left = leftNode;
                    queue.offer(leftNode);
                }
                if (index < array.length - 1 && !"n".equals(array[++index])) {
                    TreeNode rightNode = new TreeNode(Integer.valueOf(array[index]));
                    tmpNode.right = rightNode;
                    queue.offer(rightNode);
                }
            }
        }
    }
}
