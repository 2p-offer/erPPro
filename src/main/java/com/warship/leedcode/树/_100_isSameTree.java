package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 * <p>
 * 提示：
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 */
public class _100_isSameTree {

    /**
     * 深度优先搜索
     * 目前最容易想到，也最容易实现的方法。相当于同事递归遍历两个树。在任何时刻两个当前节点都相同，就说明两个树相同
     * leedcode 也做到笔记本写代码，一次通过
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeDFS(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }

        if (!isSameTreeDFS(p.left, q.left)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (!isSameTreeDFS(p.right, q.right)) {
            return false;
        }
        return true;
    }

    /**
     * 广度优先搜索
     * 目前觉得，树遍历应该精进的方式，思路已经掌握了。但是coding熟练度不够。
     * 不用ide，手写代码还是费劲。并且一些点想不到。导致leedcode提交5次才通过。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.offer(p);
        qQueue.offer(q);
        while (!pQueue.isEmpty() || !qQueue.isEmpty()) {
            int size = Math.max(pQueue.size(), qQueue.size());//取两个queue最长的那个。这样可以处理所有节点。
            for (int i = 0; i < size; i++) {
                TreeNode qNode = qQueue.poll();
                TreeNode pNode = pQueue.poll();
                if (qNode == null || pNode == null) {//如果两节点有一个为空，则连个节点都必须为空，（为了处理p q 两个树直接为空的情况）
                    return qNode == null && pNode == null;
                }
                if (qNode.val != pNode.val) {//节点值不同，直接说明树不同
                    return false;
                }
                if (pNode.left != null || qNode.left != null) {//只要有一个不为空，就放进队列。如果只有一个为空，下一次循环遍历就会判断为树不同
                    pQueue.offer(pNode.left);
                    qQueue.offer(qNode.left);
                }
                if (pNode.right != null || qNode.right != null) {
                    pQueue.offer(pNode.right);
                    qQueue.offer(qNode.right);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _100_isSameTree test = new _100_isSameTree();
        TreeNode treeNode = TreeNode.array2Tree(new Integer[]{1, 2});
        TreeNode treeNode1 = TreeNode.array2Tree(new Integer[]{1, null, 2});
        boolean sameTreeBFS = test.isSameTreeBFS(treeNode, treeNode1);
        boolean sameTreeDFS = test.isSameTreeDFS(treeNode, treeNode1);
        System.out.println("BFS:" + sameTreeBFS);
        System.out.println("DFS:" + sameTreeDFS);

    }


}
