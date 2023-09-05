package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class _94_inorderTraversal {

    List<Integer> res;

    public List<Integer> inorderTraversal_DFS(TreeNode root) {
        res = new LinkedList<Integer>();
        dealNode(root);
        return res;
    }


    public void dealNode(TreeNode node) {
        if (node == null) {
            return;
        }
        dealNode(node.left);
        res.add(node.val);
        dealNode(node.right);
    }


    /**
     * 迭代实现
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_Iterator(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
