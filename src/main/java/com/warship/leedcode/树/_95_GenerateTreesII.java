package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 提示：
 *
 * 1 <= n <= 8
 */
public class _95_GenerateTreesII {


    int sum;
    List<TreeNode> res;

    /**
     * 自己最一开始的想法，回溯。选择一个节点之后，应该在所有还未选择的节点中，选择一个并插入，在递归结束后，将上次做的选择回退。
     * 出现了问题，当选择完 2 . 1 节点后，又将3节点放到了1的右面。但是3应该放在2的右面
     * 所以这道题不应该顺序处理每一个节点。 看了下题解，写出下面的官方思路题解。
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        res = new ArrayList<>();
        sum = n;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp, 0);
            dp[i] = i;
            TreeNode treeNode = new TreeNode(i);
            dealNode(treeNode, treeNode, dp, 1);
        }
        return res;
    }

    /**
     * @param currentNode 当前已经添加的节点的结果
     * @param dp          已经被选择的节点 dp[i] !=0 代表已经被选择
     * @param n           已经被选择的 数量
     */
    private void dealNode(TreeNode headNode, TreeNode currentNode, int[] dp, int n) {
        if (n == sum) {
            TreeNode copy = new TreeNode(headNode.val);
            copyNode(copy, headNode);
            res.add(copy);
            return;
        }
        for (int i = 1; i <= sum; i++) {
            if (dp[i] != 0) {
                continue;
            }
            dp[i] = i;
            if (currentNode.val < i) {
                currentNode.right = new TreeNode(i);
                dealNode(headNode, currentNode.right, dp, n + 1);
            } else {
                currentNode.left = new TreeNode(i);
                dealNode(headNode, currentNode.left, dp, n + 1);
            }
            dp[i] = 0;
            currentNode.left = null;
            currentNode.right = null;
        }
    }

    private void copyNode(TreeNode copy, TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }
        if (currentNode.left != null) {
            copy.left = new TreeNode(currentNode.left.val);
        }
        if (currentNode.right != null) {
            copy.right = new TreeNode(currentNode.right.val);
        }
        copyNode(copy.right, currentNode.right);
        copy.val = currentNode.val;
        copyNode(copy.left, currentNode.left);
    }


    /**
     * 借鉴官方题解实现的
     * @param n
     * @return
     */
    public List<TreeNode> generateTreesII(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return dealNodeII(1, n);
    }

    public List<TreeNode> dealNodeII(int start, int end) {
        List<TreeNode> all = new LinkedList();
        if (end < start) {
            all.add(null);//如果end<start .记得返回null节点。作为叶子节点的子节点。
            return all;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> treeNodesLeft = dealNodeII(start, i - 1);
            List<TreeNode> treeNodesRight = dealNodeII(i + 1, end);
            for (TreeNode left : treeNodesLeft) {
                for (TreeNode right : treeNodesRight) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    all.add(root);
                }
            }
        }

        return all;
    }


    public List<TreeNode> generateTrees_main(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees_main(1, n);
    }

    public List<TreeNode> generateTrees_main(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees_main(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees_main(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }


    public static void main(String[] args) {

        _95_GenerateTreesII test = new _95_GenerateTreesII();
//        TreeNode treeNode = TreeNode.array2Tree(new Integer[]{1, 2, 3, 4, null, null, 5});
//        System.out.println(treeNode);
//        TreeNode copy = new TreeNode(treeNode.val);
//        test.copyNode(copy, treeNode);
//        System.out.println(copy);

        List<TreeNode> treeNodes1 = test.generateTrees_main(2);

        List<TreeNode> treeNodes = test.generateTreesII(2);
        System.out.println(treeNodes1);
        System.out.println(treeNodes1.size());
        System.out.println(treeNodes);
        System.out.println(treeNodes.size());
    }
}
