package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

import java.util.*;

public class _113_pathSum {
    List<List<Integer>> res = new LinkedList<>();

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.6 MB
     * , 在所有 Java 提交中击败了
     * 88.57%
     * 的用户
     * <p>
     * DFS + 回溯
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        LinkedList<Integer> container = new LinkedList<>();
        container.offer(root.val);
        pathSum(root, targetSum, container);
        return res;
    }

    public void pathSum(TreeNode node, int targetSum, LinkedList<Integer> container) {
        if (node.left == null && node.right == null) {
            if (targetSum == node.val) {
                res.add(new LinkedList(container));
            }
            return;
        }
        if (node.left != null) {
            container.offer(node.left.val);
            pathSum(node.left, targetSum - node.val, container);
            container.pollLast();
        }

        if (node.right != null) {
            container.offer(node.right.val);
            pathSum(node.right, targetSum - node.val, container);
            container.pollLast();
        }
    }


    /**
     * 执行用时：
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 5.59%
     * 的用户
     * 内存消耗：
     * 39.5 MB
     * , 在所有 Java 提交中击败了
     * 9.09%
     * 的用户
     * <p>
     * 写的时候，感觉就像屎
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum_BFS(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();
        Queue<List<Integer>> queueList = new LinkedList<>();
        queueNode.offer(root);
        queueVal.offer(root.val);
        List<Integer> tmpcontainer = new LinkedList<>();
        tmpcontainer.add(root.val);
        queueList.offer(tmpcontainer);
        while (!queueNode.isEmpty()) {
            TreeNode currentNode = queueNode.poll();
            int currentVal = queueVal.poll();
            List<Integer> currentList = queueList.poll();
            if (currentNode.left == null && currentNode.right == null) {
                if (targetSum == currentVal) {
                    res.add(new LinkedList<>(currentList));
                }
                continue;

            }
            if (currentNode.left != null) {
                queueNode.offer(currentNode.left);
                queueVal.offer(currentVal + currentNode.left.val);
                List<Integer> leftList = new LinkedList<>(currentList);
                leftList.add(currentNode.left.val);
                queueList.offer(leftList);
            }
            if (currentNode.right != null) {
                queueNode.offer(currentNode.right);
                queueVal.offer(currentVal + currentNode.right.val);
                List<Integer> rightList = new LinkedList<>(currentList);
                rightList.add(currentNode.right.val);
                queueList.offer(rightList);
            }
        }
        return res;
    }


    /**
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 8.38%
     * 的用户
     * 内存消耗：
     * 38.7 MB
     * , 在所有 Java 提交中击败了
     * 73.72%
     * 的用户
     * <p>
     * 用了个map，存放子节点值-父节点  。用于追溯跟节点到当前节点的路径。 不用在每个节点都创建list。只有符合条件的时候，才临时创建list。节省大部分空间。已经复制list的时间开销
     */
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

    public List<List<Integer>> pathSum_BFS_Main(TreeNode root, int sum) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == sum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }

        return ret;
    }

    public void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<Integer>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<Integer>(temp));
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.array2Tree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        _113_pathSum test = new _113_pathSum();
        System.out.println(test.pathSum_BFS(root, 22));
    }
}
