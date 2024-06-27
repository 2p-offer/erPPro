package com.warship.leedcode.shuzu;


import java.util.Objects;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class _2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //递归方式
//        return getSum(l1, l2, false);

        //迭代方式
        ListNode res = new ListNode();
        ListNode updateNode = res;
        boolean up = false;
        while (Objects.nonNull(l1) || Objects.nonNull(l2) || up) {

            int sum = (Objects.isNull(l1) ? 0 : l1.val) + (Objects.isNull(l2) ? 0 : l2.val) + (up ? 1 : 0);
            updateNode.next = new ListNode(sum % 10);
            updateNode = updateNode.next;
            l1 = Objects.nonNull(l1) ? l1.next : null;
            l2 = Objects.nonNull(l2) ? l2.next : null;
            up = sum >= 10;
        }
        return res.next;
    }

    public ListNode getSum(ListNode left, ListNode right, boolean up) {
        if (Objects.isNull(left) && Objects.isNull(right)) {
            return up ? new ListNode(1) : null;
        }
        int leftNum = Objects.isNull(left) ? 0 : left.val;
        int rightNum = Objects.isNull(right) ? 0 : right.val;
        int sum = leftNum + rightNum + (up ? 1 : 0);
        int small = sum % 10;
        ListNode smallNode = new ListNode(small);
        smallNode.next = getSum(Objects.nonNull(left) ? left.next : null, Objects.nonNull(right) ? right.next : null, sum >= 10);
        return smallNode;
    }


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


}


