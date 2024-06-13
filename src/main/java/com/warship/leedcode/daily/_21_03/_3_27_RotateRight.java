package  com.warship.leedcode.daily._21_03;

import  com.warship.leedcode.helper.ListNode;

/**
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 示例一：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 示例二：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 */
public class _3_27_RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode currentNode = head;
        int length = 0;
        while (currentNode.next != null) {
            length++;
            currentNode = currentNode.next;
        }
        ListNode preNode = currentNode;
        currentNode.next = head;
        length++;

        k = k % length;
        k = length - k;
        currentNode = head;
        for (int i = 0; i < k; i++) {
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        preNode.next = null;
        return currentNode;
    }
}
