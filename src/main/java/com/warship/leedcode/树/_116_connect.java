package com.warship.test.leedcode.树;

import java.util.LinkedList;
import java.util.Queue;

public class _116_connect {


    /**
     * 最一开始想到，也是一遍就写过的方法。层序遍历。
     * <p>
     * 3 ms	38.5 MB
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node pre = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                if (pre != null) {
                    pre.next = currentNode;
                }
                if (i == size - 1) {//当前层的最后一个节点，next应该设为空
                    currentNode.next = null;
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                pre = currentNode;
            }
            pre = null;
        }
        return root;
    }

    /**
     * 我是真没想到。这么顺利能解出来最优解。
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.4 MB
     * , 在所有 Java 提交中击败了
     * 88.93%
     * 的用户
     * <p>
     * 树的题目，最近做下来发现，至少都会有两种解。无非递归和迭代。
     *
     * @param root
     * @return
     */
    public Node connect_II(Node root) {
        if (root != null) {
            connect_DiGui(root);
        }
        return root;
    }

    private void connect_DiGui(Node node) {
        if (node.left == null) {//如果是叶子结点，就return
            return;
        }
        //上面的判断，意味着，再node时，应该处理node 的子节点
        if (node.next == null) {//如果当前节点没有下一节点，说明当前节点的右节点可以指向null
            node.right.next = null;//这一步可以省略。因为next初始化就是null
        } else {
            node.right.next = node.next.left;//当前节点有下一个节点 N，则当前节点的右节点应该指向N的左节点
        }
        node.left.next = node.right;

        connect_DiGui(node.left);
        connect_DiGui(node.right);
    }

    /**
     * 思路和II一致，但是不用递归。
     * <p>
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 71.43%
     * 的用户
     * 内存消耗：
     * 38.6 MB
     * , 在所有 Java 提交中击败了
     * 65.91%
     * 的用户
     *
     * @param root
     * @return
     */
    public Node connect_III(Node root) {

        Node currentNode = root;//当前要处理的节点
        Node firstNode = root;//当前处理层的层头
        while (currentNode != null) {
            if (currentNode.left != null) {
                currentNode.left.next = currentNode.right;
            }
            if (currentNode.next == null) {//当前层到头了，得到下一层
                firstNode = firstNode.left;//层头是上一层层头的左节点
                currentNode = firstNode;//从层头开始处理
            } else {
                if (currentNode.right != null) {
                    currentNode.right.next = currentNode.next.left;
                }
                currentNode = currentNode.next;
            }
        }
        return root;

    }


    /**
     *
     * 官方的，没有用递归的方式 和我 III 方法一致。但是不论是代码可读性还是效率。都比我好 啊
     *
     *
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.9 MB
     * , 在所有 Java 提交中击败了
     * 16.00%
     * 的用户
     * @param root
     * @return
     */
    public Node connect_Main(Node root) {
        if (root == null) {
            return root;
        }

        // 从根节点开始
        Node leftmost = root;

        while (leftmost.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;

            while (head != null) {

                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // 指针向后移动
                head = head.next;
            }

            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }

        return root;
    }


}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};