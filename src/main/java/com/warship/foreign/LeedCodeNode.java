package com.warship.test.foreign;

public class LeedCodeNode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            ListNode orginNode = new ListNode(-1);
            ListNode preNode = orginNode;
            orginNode.next = head;
            while (head != null) {
                if (head.val == val) {
                    preNode.next = head.next;
                    break;
                }
                preNode = preNode.next;
                head = head.next;
            }
            return orginNode.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
