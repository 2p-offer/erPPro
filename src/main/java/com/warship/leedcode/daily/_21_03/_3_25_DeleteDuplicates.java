package com.warship.test.leedcode.daily._21_03;

/**
 * 82. 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 */
public class _3_25_DeleteDuplicates {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headNode = new ListNode(0, head);
        ListNode preNode = headNode;
        ListNode currentNode = head;
        boolean needRemove = false;
        while (currentNode != null) {
            if (currentNode.next == null || currentNode.next.val != currentNode.val) {
                if (needRemove) {
                    preNode.next = currentNode.next;
                    needRemove = false;
                } else {
                    preNode = currentNode;
                }
            } else {

                needRemove = true;
            }
            currentNode = currentNode.next;
        }

        return headNode.next;
    }

    /**
     * 官方题解
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates_main(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        //        ListNode node11 = new ListNode(5, null);
        ListNode node1 = new ListNode(5, null);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(4, node2);
        ListNode node33 = new ListNode(4, node3);
//        ListNode node4 = new ListNode(3, node33);
//        ListNode node5 = new ListNode(3, node4);
        ListNode node6 = new ListNode(3, node33);
        soutNode(node6);
        ListNode listNode = deleteDuplicates(node6);
        System.out.println("---");
        soutNode(listNode);
    }

    private static void soutNode(ListNode node4) {
        while (node4 != null) {
            System.out.print(node4.val + "->");
            node4 = node4.next;
        }
    }
}
