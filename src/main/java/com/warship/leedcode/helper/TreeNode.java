package com.warship.test.leedcode.helper;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 堆 转 TreeNode
     *
     * @param array
     * @return
     */
    public static TreeNode array2Tree(Integer[] array) {
        try {
            if (array == null || array[0] == null) {
                throw new Exception("args illagel,array can't be null and the first elements can't be null either");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        TreeNode root = new TreeNode(array[0]);
//        dealArray(array, root, 0);
        dealArray_II(array, root);
        return root;
    }

    /**
     * 之前写的 堆转 二叉树算法，出现了问题。当 array = {1, 2, 3, 4, 5, 6, null, 7, null, 8, 9, null, 11, 10} 时， 最后一个元素无法插入到树中
     *
     * @param array
     * @param node
     * @param index
     * @return
     */
    private static TreeNode dealArray(Integer[] array, TreeNode node, int index) {
        if (node == null) {
            return node;
        }
        if (index >= array.length || array[index] == null) {
            return null;
        }
        node.val = array[index];
        node.left = dealArray(array, new TreeNode(), index * 2 + 1);
        node.right = dealArray(array, new TreeNode(), index * 2 + 2);
        return node;
    }


    /**
     * 堆转二叉树的优化，利用广度优先，每一层处理。 可能还有别的问题。目前可以使用。2002-05-23
     *
     * @param array
     * @param node
     * @return
     */
    private static TreeNode dealArray_II(Integer[] array, TreeNode node) {
        if (node == null) {
            return node;
        }
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty() && index < array.length - 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = queue.poll();
                if (index < array.length - 1 && array[++index] != null) {
                    TreeNode leftNode = new TreeNode(array[index]);
                    tmpNode.left = leftNode;
                    queue.offer(leftNode);
                }
                if (index < array.length - 1 && array[++index] != null) {
                    TreeNode rightNode = new TreeNode(array[index]);
                    tmpNode.right = rightNode;
                    queue.offer(rightNode);
                }
            }
        }

        return node;
    }

    @Override
    public String toString() {
        return "{" +
                "val:" + val +
                ", left:" + left +
                ", right:" + right +
                '}';
    }

    public static void main(String[] args) {
//        TreeNode treeNode = array2Tree(new Integer[]{1, 2, 3, 4, null, 6, 7});
        TreeNode treeNode = array2Tree(new Integer[]{1, 2, 3, 4, 5, 6, null, 7, null, 8, 9, null, 11, 10});
        System.out.println(treeNode);

    }
}
