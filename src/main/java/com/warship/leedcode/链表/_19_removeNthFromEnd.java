package com.warship.leedcode.链表;

import com.warship.leedcode.helper.ListNode;

import java.util.Objects;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class _19_removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode top = null;
        ListNode currentNode = head;
        int step = 1;
        while (Objects.nonNull(currentNode)) {
            if (step == n) {
                top = new ListNode(0, head);
            }
            if (step > n) {
                top = top.next;
            }
            currentNode = currentNode.next;
            step++;
        }
        if (step == n + 1) {
            return head.next;
        }
        top.next = top.next.next;
        return head;

    }

}
