package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

import java.util.*;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * <p>
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 * <p>
 * 提示：|
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 */
public class _863_distanceK {
    List<Integer> ans = new LinkedList<>();



    //=====
    Map<TreeNode, TreeNode> sonPar;

    /**
     * 执行用时：
     * 18 ms
     * , 在所有 Java 提交中击败了
     * 66.67%
     * 的用户
     * 内存消耗：
     * 38.5 MB
     * , 在所有 Java 提交中击败了
     * 56.57%
     * 的用户
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        sonPar = new HashMap<>();
        dealSonPar(root, null);//初始化map。构建 子节点- 父节点映射关系。 即找到所有距离为1的两个节点
        Queue<TreeNode> container = new LinkedList<>();//这个是待遍历的容器集合
        Set<TreeNode> dealed = new HashSet<>();//已经处理过的节点，防止寻路回头
        int distance = 0;//当前list里面的元素距离target的距离
        container.offer(target);
        while (!container.isEmpty()) {
            if (distance == k) {
                dealAns(container);
                return ans;
            }
            int size = container.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = container.poll();
                //比当前节点距离大1的节点只有三种
                //1.当前节点父节点
                TreeNode parNode = sonPar.get(tmpNode);
                if (parNode != null && !dealed.contains(parNode)) {
                    container.offer(parNode);
                }
                //2.当前节点左节点
                if (tmpNode.left != null && !dealed.contains(tmpNode.left)) {
                    container.offer(tmpNode.left);
                }
                //3.当前节点右节点
                if (tmpNode.right != null && !dealed.contains(tmpNode.right)) {
                    container.offer(tmpNode.right);
                }
                dealed.add(tmpNode);
            }
            distance++;
        }


        return ans;
    }

    private void dealAns(Queue<TreeNode> container) {
        while (!container.isEmpty()) {
            TreeNode poll = container.poll();
            ans.add(poll.val);
        }
    }

    private void dealSonPar(TreeNode node, TreeNode par) {
        if (node == null) {
            return;
        }
        sonPar.put(node, par);
        dealSonPar(node.left, node);
        dealSonPar(node.right, node);

    }



    //=======
    /**
     * 执行用时：
     * 18 ms
     * , 在所有 Java 提交中击败了
     * 66.67%
     * 的用户
     * 内存消耗：
     * 38.5 MB
     * , 在所有 Java 提交中击败了
     * 58.73%
     * 的用户
     * 思路
     * 如果 target 节点在 root 节点的左子树中，且 target 节点深度为 3，那所有 root 节点右子树中深度为 K - 3 的节点到 target 的距离就都是 K。
     *
     * 算法
     * 深度优先遍历所有节点。定义方法 dfs(node)，这个函数会返回 node 到 target 的距离。在 dfs(node) 中处理下面四种情况：
     * 如果 node == target，把子树中距离 target 节点距离为 K 的所有节点加入答案。
     * 如果 target 在 node 左子树中，假设 target 距离 node 的距离为 L+1，找出右子树中距离 target 节点 K - L - 1 距离的所有节点加入答案。
     * 如果 target 在 node 右子树中，跟在左子树中一样的处理方法。
     * 如果 target 不在节点的子树中，不用处理。
     * 实现的算法中，还会用到一个辅助方法 subtree_add(node, dist)，这个方法会将子树中距离节点 node K - dist 距离的节点加入答案。
     */
    TreeNode target;
    int K;
    public List<Integer> distanceK_II(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList();
        this.target = target;
        this.K = K;
        dfs(root);
        return ans;
    }

    // Return vertex distance from node to target if exists, else -1
    // Vertex distance: the number of vertices on the path from node to target
    public int dfs(TreeNode node) {
        if (node == null)
            return -1;
        else if (node == target) {
            subtree_add(node, 0);
            return 1;
        } else {
            int L = dfs(node.left), R = dfs(node.right);
            if (L != -1) {
                if (L == K) ans.add(node.val);
                subtree_add(node.right, L + 1);
                return L + 1;
            } else if (R != -1) {
                if (R == K) ans.add(node.val);
                subtree_add(node.left, R + 1);
                return R + 1;
            } else {
                return -1;
            }
        }
    }

    // Add all nodes 'K - dist' from the node to answer.
    public void subtree_add(TreeNode node, int dist) {
        if (node == null) return;
        if (dist == K)
            ans.add(node.val);
        else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
        }
    }

}
