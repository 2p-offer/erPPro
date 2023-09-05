package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层序遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层序遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 也太简单了
 */
public class _107_levelOrderBottom {
    LinkedList<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return res;
        }
        dealNode(root);
        return res;
    }

    private void dealNode(TreeNode node){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> tmp = new LinkedList();
            for(int i = 0 ; i<size; i++){
                TreeNode currentNode = queue.poll();
                tmp.offer(currentNode.val);
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            res.offerFirst(new LinkedList(tmp));
        }
    }
}
