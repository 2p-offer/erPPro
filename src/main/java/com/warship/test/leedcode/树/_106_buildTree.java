package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class _106_buildTree {


    /**
     * 执行用时：
     * 5 ms
     * , 在所有 Java 提交中击败了
     * 26.03%
     * 的用户
     * 内存消耗：
     * 38.3 MB
     * , 在所有 Java 提交中击败了
     * 84.21%
     * 的用户
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree_self(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        return dealNode(inorder, postorder, 0, 0, inorder.length);
    }

    private TreeNode dealNode(int[] inorder, int[] postorder, int inStart, int postStart, int length) {
        if (length < 1) {
            return null;
        }
        int rootVal = postorder[postStart + length - 1];

        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inStart;
        while (rootIndex < inStart + length) {
            if (inorder[rootIndex] == rootVal) {
                break;
            }
            rootIndex++;
        }
        int leftLength = rootIndex - inStart;
        int rightLength = length - leftLength - 1; // 总长度-左节点- 根节点
        root.left = dealNode(inorder, postorder, inStart, postStart, leftLength);
        root.right = dealNode(inorder, postorder, rootIndex + 1, postStart + leftLength, rightLength);

        return root;
    }

    //==================================================

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 98.45%
     * 的用户
     * 内存消耗：
     * 38.5 MB
     * , 在所有 Java 提交中击败了
     * 56.26%
     * 的用户
     * <p>
     * 速度直接翻倍！！！！！！！！！！！！！！！ 比官方还块呢。嘻嘻
     * 能得到什么收获？？ 稍微多一点空间占用，时间能得到极大优化，尤其要多次遍历某个集合。使用hash表，能直接快速定位。
     */
    Map<Integer, Integer> container = new HashMap<>();

    public TreeNode buildTree_self_II(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            container.put(inorder[i], i);
        }
        return dealNode_II(inorder, postorder, 0, 0, inorder.length);
    }

    private TreeNode dealNode_II(int[] inorder, int[] postorder, int inStart, int postStart, int length) {
        if (length < 1) {
            return null;
        }
        int rootVal = postorder[postStart + length - 1];

        TreeNode root = new TreeNode(rootVal);
        int rootIndex = container.get(rootVal);
        int leftLength = rootIndex - inStart;
        int rightLength = length - leftLength - 1; // 总长度-左节点- 根节点
        root.left = dealNode(inorder, postorder, inStart, postStart, leftLength);
        root.right = dealNode(inorder, postorder, rootIndex + 1, postStart + leftLength, rightLength);

        return root;
    }

    // ================================================

    /**
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 67.88%
     * 的用户
     * 内存消耗：
     * 38.3 MB
     * , 在所有 Java 提交中击败了
     * 83.89%
     * 的用户
     * <p>
     * <p>
     */
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();


    public TreeNode buildTree_main(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }

    //======================================

    /**
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 67.88%
     * 的用户
     * 内存消耗：
     * 38.1 MB
     * , 在所有 Java 提交中击败了
     * 96.08%
     * 的用户
     * <p>
     * 迭代实现。还没没看题解，速度并没有快很多，重点是学习这种思想，
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }

}
