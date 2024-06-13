package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.List;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *
 *
 * 提示：
 *
 * 节点总数 <= 10000
 */
public class _jianzhi_55_TreeNodeSolution {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

//    public int maxDepth(TreeNode root) {
//
//        if(root == null){
//            return 0;
//        }
//
//        List<TreeNode> contain_1 = new ArrayList<>();
//        List<TreeNode> contain_2 = new ArrayList<>();
//        contain_1.add(root);
//        return dealNodes(0,contain_1,contain_2);
//    }

    public int dealNodes(int currentDeap, List<TreeNode> nodes, List<TreeNode> contains) {
        if (nodes.isEmpty()) {
            return currentDeap;
        }

        for (TreeNode node : nodes) {
            if (node.left != null) {
                contains.add(node.left);
            }
            if (node.right != null) {
                contains.add(node.right);
            }
        }
        currentDeap++;
        nodes.clear();
        return dealNodes(currentDeap, contains, nodes);

    }
}
