package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.*;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class _199_rightSideView {

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.59%
     * 的用户
     * 内存消耗：
     * 37 MB
     * , 在所有 Java 提交中击败了
     * 77.39%
     * 的用户
     * <p>
     * 迭代思想，层序遍历，将每一层最后一个元素，放到结果集
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView_Iterator(TreeNode root) {
        List<Integer> res = new LinkedList();
        if (root == null) {
            return res;
        }
        //迭代：
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cuNode = queue.poll();
                if (i == size - 1) {
                    res.add(cuNode.val);
                }
                if (cuNode.left != null) {
                    queue.offer(cuNode.left);
                }
                if (cuNode.right != null) {
                    queue.offer(cuNode.right);
                }
            }
        }
        return res;
    }


    /**
     * DFS .....
     * <p>
     * 使用map存放，当前层是否已经确定最右侧节点。
     * <p>
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 23.12%
     * 的用户
     * 内存消耗：
     * 37.2 MB
     * , 在所有 Java 提交中击败了
     * 32.46%
     * 的用户
     */
    Map<Integer, Integer> container = new HashMap<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        dfs(root, 0);
        return dealRes();

    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
        if (checkContainer(depth)) {
            container.put(depth, node.val);
        }
        //res.add(node.val);

    }

    private boolean checkContainer(int depth) {
        return container.get(depth) == null;
    }

    private List<Integer> dealRes() {
        List<Integer> res = new ArrayList<>(container.size());
        for (Map.Entry<Integer, Integer> entry : container.entrySet()) {
            res.add(entry.getKey(), entry.getValue());
        }
        return res;
    }


    /**
     * 官方的DFS。确实细节上有些差距。
     *
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.59%
     * 的用户
     * 内存消耗：
     * 37.3 MB
     * , 在所有 Java 提交中击败了
     * 17.94%
     * 的用户
     */
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView_main(TreeNode root) {
        dfs_main(root, 0); // 从根节点开始访问，根节点深度是0
        return res;
    }

    private void dfs_main(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }


    public static void main(String[] args) {
        HashMap<Integer, Integer> tes = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : tes.entrySet()) {

        }
    }
}
