package  com.warship.leedcode.daily._21_03;

/**
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 */
public class _3_26_DeleteDuplicates {
    public class ListNode {
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
        if (head == null) {
            return head;
        }
        ListNode preNode = head;
        ListNode currentNode = head.next;
        while (currentNode != null) {
            if (preNode.val == currentNode.val) {
                preNode.next = currentNode.next;
            } else {
                preNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }
}
