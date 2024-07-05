package com.warship.leedcode.链表;

import com.warship.leedcode.helper.ListNode;

import java.util.Objects;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 */
public class _24_swapPairs {

    public ListNode swapPairs(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode res = head.next == null ? head : head.next;
        ListNode topNode = new ListNode(0, head);
        ListNode currentNode = head;
        while (Objects.nonNull(currentNode) && Objects.nonNull(currentNode.next)) {
            ListNode currentNextNode = currentNode.next;
            topNode.next = currentNextNode;
            currentNode.next = currentNextNode.next;
            currentNextNode.next = currentNode;
            topNode = currentNode;
            currentNode = currentNode.next;
        }
        return res;
    }

}
