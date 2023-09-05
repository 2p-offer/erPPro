package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 */
public class _114_flatten {

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 10.42%
     * 的用户
     * 内存消耗：
     * 37.6 MB
     * , 在所有 Java 提交中击败了
     * 91.68%
     * 的用户
     * <p>
     * 使用迭代的方式，遍历树
     *
     * @param root
     */
    public void flatten_iterator(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmpNode = new TreeNode(-1);
        TreeNode res = tmpNode;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            tmpNode.right = new TreeNode(currentNode.val);
            tmpNode = tmpNode.right;
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        root.left = null;
        if (res.right != null) {
            root.right = res.right.right;
        }
    }

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 37.6 MB
     * , 在所有 Java 提交中击败了
     * 93.34%
     * 的用户
     *
     * @param root
     */
    public void flatten_DiGui(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode res = new TreeNode(root.val);
        dealNode(root, res);
        root.left = null;
        if (res.right != null) {
            root.right = res.right.right;
        }
    }

    private TreeNode dealNode(TreeNode node, TreeNode container) {
        if (node == null) {
            return container;
        }
        container.right = new TreeNode(node.val);
        if (node.left != null) {
            container = dealNode(node.left, container.right);
        }
        if (node.right != null) {
            container = dealNode(node.right, container.right);
        }
        return container;

    }


    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 43.88%
     * 的用户
     * 内存消耗：
     * 37.8 MB
     * , 在所有 Java 提交中击败了
     * 69.88%
     * 的用户
     *
     * @param root
     */
    public void flatten_Iterator_Main(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            TreeNode left = curr.left, right = curr.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            prev = curr;
        }
    }

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 37.9 MB
     * , 在所有 Java 提交中击败了
     * 52.15%
     * 的用户
     * <p>
     * 这按理说，是最优解（空间占用方面）。为什么内存消耗，并不比我递归的消耗小呢？？？？
     * <p>
     *          思路讲解：
     * 整个思路和  Morris 遍历树有些相像；
     * 前序遍历的特点是，当前节点遍历，左子树全部遍历完成，遍历右节点；
     * 而上述说法，对左子树同样适用。
     * 所以我们可以想到。当前节点的右节点，会在当前节点的左子树的最右边节点处理完之后处理。
     *
     * <p>
     * <p>
     *              官方的讲解：
     * 前两种方法都借助前序遍历，前序遍历过程中需要使用栈存储节点。有没有空间复杂度是 O(1)O(1) 的做法呢？
     * 注意到前序遍历访问各节点的顺序是根节点、左子树、右子树。如果一个节点的左子节点为空，则该节点不需要进行展开操作。如果一个节点的左子节点不为空，则该节点的左子树中的最后一个节点被访问之后，该节点的右子节点被访问。该节点的左子树中最后一个被访问的节点是左子树中的最右边的节点，也是该节点的前驱节点。因此，问题转化成寻找当前节点的前驱节点。
     * 具体做法是，对于当前节点，如果其左子节点不为空，则在其左子树中找到最右边的节点，作为前驱节点，将当前节点的右子节点赋给前驱节点的右子节点，然后将当前节点的左子节点赋给当前节点的右子节点，并将当前节点的左子节点设为空。对当前节点处理结束后，继续处理链表中的下一个节点，直到所有节点都处理结束。
     *
     * @param root
     */
    public void flatten_Main(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode nextNode = curr.left;//这个是下次要处理的节点
                TreeNode preNode = curr.left;//这个，处理完之后，是右节点的前驱节点。
                while (preNode.right != null) {
                    preNode = preNode.right;//当前节点的右节点，应该在当前节点的左子树的最右边一个节点处理完之后在处理。
                }
                preNode.right = curr.right;
                curr.right = nextNode;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
