package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class _105_buildTree {


    /**
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了49.73%的用户
     * 内存消耗：
     * 38.3 MB
     * , 在所有 Java 提交中击败了 83.65%的用户
     * <p>
     * 虽然写的时间挺长，效率也有点低，但是我真没想到 ，leedcode 网页写代码，一遍过。
     * <p>
     * 算是对边界值的梳理有了一个提升。历史性突破吧。
     */
    public TreeNode buildTree_Self(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length != inorder.length || preorder.length < 1 || inorder.length < 1) {
            return null;
        }
        return dealRoot(preorder, 0, inorder, 0, inorder.length);
    }

    /**
     * inIndex 代表 根节点再中序遍历出现的位置，
     * inIndex - inStart 是左子节点数量 = leftLength
     * inStart + length - inIndex - 1 是有子节点数量 = rightLength
     * 所有的start end 都是闭合区间
     */
    private TreeNode dealRoot(int[] preorder, int preStart, int[] inorder, int inStart, int length) {
        if (length < 1) {
            return null;
        }
        int root = preorder[preStart];
        TreeNode rootNode = new TreeNode(root);
        int inIndex = inStart;
        int inNum = inorder[inIndex];
        while (inNum != root) {
            inNum = inorder[++inIndex];
        }
        int leftLength = inIndex - inStart;//左子节点数量
        int rightLength = inStart + length - inIndex - 1;//右子节点数量
        rootNode.left = dealRoot(preorder, preStart + 1, inorder, inStart, leftLength);
        rootNode.right = dealRoot(preorder, preStart + leftLength + 1, inorder, inIndex + 1, rightLength);
        return rootNode;
    }


    /**
     * 官方的递归写法， 效率和我一般。
     * 提升的地方在于，寻找中序遍历集合的根节点时，他只需遍历一次节点，然后用map存储了每个节点所在位置。后面查询都是O(1)
     *
     * <p>
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了 67.75%的用户
     * 内存消耗：
     * 38.6 MB
     * , 在所有 Java 提交中击败了43.64% 的用户
     */
    private Map<Integer, Integer> indexMap;


    public TreeNode buildTree_Main(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }


    /**
     * 迭代实现。效率倍增。
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了98.49%的用户
     * 内存消耗：
     * 38.1 MB
     * , 在所有 Java 提交中击败了 96.13%的用户
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree_Iterator(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }


}
