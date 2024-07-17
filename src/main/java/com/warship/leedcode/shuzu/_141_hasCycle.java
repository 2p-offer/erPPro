package com.warship.leedcode.shuzu;

import com.warship.leedcode.helper.ListNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * 提示：
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 * <p>
 * <p>
 * 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class _141_hasCycle {


    public boolean hasCycle(ListNode head) {
        if (Objects.isNull(head)) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public boolean hasCycle_(ListNode head) {
        Set<ListNode> container = new HashSet<>();
        while (Objects.nonNull(head)) {
            if (container.contains(head)) {
                return true;
            }
            container.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 让fast的速度比slow快。让slow一步一步走。 如果有环的话，fast总会和slow重合
     */
}
