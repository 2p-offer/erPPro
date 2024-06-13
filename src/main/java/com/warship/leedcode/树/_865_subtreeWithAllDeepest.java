package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.*;

public class _865_subtreeWithAllDeepest {

    /**
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 17.99%
     * 的用户
     * 内存消耗：
     * 37.8 MB
     * , 在所有 Java 提交中击败了
     * 21.47%
     * 的用户
     */
    Map<TreeNode, TreeNode> sonPar;

    public TreeNode subtreeWithAllDeepest_Self(TreeNode root) {
        TreeNode ans = root;
        sonPar = new HashMap<>();
        dealSonPar(root, null);
        //找到最后一层的所有节点
        List<TreeNode> lastLevel = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            lastLevel.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cuNode = queue.poll();
                if (cuNode.left != null) {
                    queue.offer(cuNode.left);
                }
                if (cuNode.right != null) {
                    queue.offer(cuNode.right);
                }
                lastLevel.add(cuNode);
            }
        }

        //lastLevel 里，就是树的最后一层所包含的所有节点
        Set<TreeNode> container = new HashSet();
        Set<TreeNode> container2 = new HashSet();
        container.addAll(lastLevel);
        while (container.size() != 1) {
            for (TreeNode node : container) {
                container2.add(sonPar.get(node));
            }
            container = container2;
            container2 = new HashSet();
        }
        for (TreeNode node : container) {
            ans = node;
        }

        return ans;
    }

    private void dealSonPar(TreeNode node, TreeNode par) {
        if (node == null) {
            return;
        }
        sonPar.put(node, par);
        dealSonPar(node.left, node);
        dealSonPar(node.right, node);
    }


    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 33.27%
     * 的用户
     * 内存消耗：
     * 37.8 MB
     * , 在所有 Java 提交中击败了
     * 16.45%
     * 的用户
     * <p>
     * 思路是，计算左子树和右子树的深度，
     * 如果一样，则当前节点即为答案
     * 如果 l > r 则最深节点再左子树，答案也在左子树。
     * 如果 l < r 同上
     *
     * @param root
     * @return
     */
    public TreeNode subtreeWithAllDeepest_DFS_II(TreeNode root) {
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        if (l == r) return root;
        else if (l > r) return subtreeWithAllDeepest_DFS_II(root.left);
        return subtreeWithAllDeepest_DFS_II(root.right);
    }

    HashMap<Integer, Integer> depths = new HashMap<>();

    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        if (depths.containsKey(node.val)) return depths.get(node.val);
        int d = Math.max(getDepth(node.left), getDepth(node.right)) + 1;
        depths.put(node.val, d);
        return d;
    }

    //=============

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 37.7 MB
     * , 在所有 Java 提交中击败了
     * 25.92%
     * 的用户
     * <p>
     * 可能是最好的方案了，自己添加一个数据结构NODE 。用于存储TreeNode 及 当前节点所在树的高度(这个高度指从低向上的深度。叶子节点为1，叶子节点父节点为2)
     * 将方法DFS_II 两步操作合为一步完成
     *
     * @param root
     * @return
     */
    public TreeNode subtreeWithAllDeepest_DFS_I(TreeNode root) {
        return getNodes(root).node;
    }

    private NodeInfo getNodes(TreeNode node) {
        if (node == null) return new NodeInfo(node, 0);
        NodeInfo l = getNodes(node.left);
        NodeInfo r = getNodes(node.right);
        if (l.d == r.d) return new NodeInfo(node, l.d + 1);
        if (l.d > r.d) return new NodeInfo(l.node, l.d + 1);
        return new NodeInfo(r.node, r.d + 1);
    }

    class NodeInfo {
        TreeNode node;
        int d;

        NodeInfo(TreeNode node, int d) {
            this.d = d;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        _865_subtreeWithAllDeepest test = new _865_subtreeWithAllDeepest();
        TreeNode treeNode = test.subtreeWithAllDeepest_DFS_I(TreeNode.array2Tree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}));

        System.out.println(treeNode);
    }
}
