package com.warship.test.leedcode.树;

public class _117_connect_II {

    /**
     * 比116 麻烦一点，写的还是不好。但是终究完成了。回头看一下
     *
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 64.71%
     * 的用户
     * 内存消耗：
     * 38 MB
     * , 在所有 Java 提交中击败了
     * 69.52%
     * 的用户
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node head = root;//当前层的头结点
        while (head != null) {
            Node currentNode = head;//当前节点
            while (currentNode != null) {
                if (currentNode.left != null) {//左节点不是空，左节点的下一个节点指向 左节点所在层层 左节点之后出现的第一个节点
                    if (currentNode.right != null) {//如果有右节点，直接连向右节点
                        currentNode.left.next = currentNode.right;
                    } else {//没有的话，寻找子节点所在层出现的第一个节点
                        Node leftHead = getHead(currentNode.next);
                        if (leftHead == null) {
                            break;
                        } else {
                            currentNode.left.next = leftHead;
                        }
                    }
                }
                if (currentNode.right != null) {//右节点的下一个节点，直接是右节点所在层，右节点之后第一个出现的节点
                    Node rightHead = getHead(currentNode.next);
                    if (rightHead == null) {
                        break;
                    } else {
                        currentNode.right.next = rightHead;
                    }
                }
                currentNode = currentNode.next;//处理下一个节点
            }
            head = getHead(head);//找到下一层的头结点
        }
        return root;
    }

    private Node getHead(Node head) {
        while (head != null) {
            if (head.left != null) {
                return head.left;
            }
            if (head.right != null) {
                return head.right;
            }
            head = head.next;
        }
        return null;
    }
}


