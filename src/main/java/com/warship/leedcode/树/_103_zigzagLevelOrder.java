package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class _103_zigzagLevelOrder {
    List<List<Integer>> res;
    boolean flag = true;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res = new ArrayList<>();
        dealNode(root);
        return res;
    }

    /**
     * 第一时间想到的办法。两个栈。一个存储下一层的结果，一个用于当前遍历。
     * <p>
     * 执行用时：2 ms ,
     * 在所有 Java 提交中击败了 18.16% 的用户
     * 内存消耗：38.8 MB,
     * 在所有 Java 提交中击败了10.38% 的用户
     *
     * @param node
     */
    private void dealNode(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> tmpList = new LinkedList<>();
        Stack<TreeNode> second;
        stack.push(node);
        while (!stack.isEmpty()) {
            second = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode currentNode = stack.pop();
                tmpList.add(currentNode.val);
                if (flag) {
                    if (currentNode.left != null) {
                        second.push(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        second.push(currentNode.right);
                    }
                } else {

                    if (currentNode.right != null) {
                        second.push(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        second.push(currentNode.left);
                    }
                }
            }
            flag = !flag;
            stack = second;
            res.add(new LinkedList<>(tmpList));
            tmpList.clear();
        }

    }


    /**
     * 瞅了一眼官方题解。用双端队列。所以先自己手写一下
     * 首先得先明确四个api
     * offerFirst
     * offerLast
     * pollFirst
     * pollLast
     * <p>
     * 十分钟，写完了：
     * 添加备注
     * <p>
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了18.16%的用户
     * 内存消耗：
     * 38.5 MB
     * , 在所有 Java 提交中击败了59.60%的用户
     * <p>
     * why???????
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder_II(TreeNode root) {
        List<List<Integer>> container = new ArrayList<>();
        if (root == null) {
            return container;
        }
        boolean tag = true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> tmpList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode;
                if (tag) {
                    currentNode = deque.pollFirst();

                    if (currentNode.left != null) {
                        deque.offerLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        deque.offerLast(currentNode.right);
                    }
                } else {
                    currentNode = deque.pollLast();
                    if (currentNode.right != null) {
                        deque.offerFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        deque.offerFirst(currentNode.left);
                    }

                }
                tmpList.add(currentNode.val);
            }
            tag = !tag;
            container.add(new ArrayList<>(tmpList));

        }
        return container;
    }




    /**
     * 官方题解。看看差距在哪里：
     *
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了 98.66% 的用户
     * 内存消耗：
     * 38.5 MB
     * , 在所有 Java 提交中击败了 62.34% 的用户
     *
     *
     * 区别很小啊。就是代码量打了一点点。。我认为执行效率区别不大。
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder_Main(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }



}
