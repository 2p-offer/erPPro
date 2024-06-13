package  com.warship.leedcode.daily._21_03;

/**
 * 92. 反转链表 II
 *
 * 给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 1 eg:
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * 2 eg:
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class _3_18_ReverseBetween {
    public static class ListNode{

        int val;

        ListNode next;

        ListNode(){
        }

        ListNode(int val){
            this.val = val;
        }

        ListNode(int val,
                 ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseBetween(ListNode head,
                                          int left,
                                          int right){

        int index = 1;
        ListNode[] container = new ListNode[right - left + 1];//存放 [left,right] 的所有节点
        ListNode endNode = null; //right的下一个节点
        ListNode startNode = null;//left之前一个节点
        ListNode tmpNode = head;
        while(index <= right){
            if(index < left){
                startNode = tmpNode;
            }

            if(index >= left && index <= right){
                container[index - left] = tmpNode;
            }
            if(index == right){
                endNode = tmpNode.next;
            }
            tmpNode = tmpNode.next;
            index++;
        }

        //倒叙遍历container，将  startNode , left .. right, endNode ,变成  startNode , right ... left , endNode .
        boolean fromHead = false;
        for(int i = container.length - 1; i >= 0; i--){
            //如果startNode  为空，意味着 left 为 1 。 则需要一个临时节点来辅助，并且最后返回临时节点的下一个节点，也就是container的最后一个元素
            if(startNode == null){
                startNode = new ListNode(-1);
                fromHead = true;
            }
            startNode.next = container[i];
            startNode = startNode.next;
        }
        if(startNode != null) {
            startNode.next = endNode;
        }
        return fromHead ? container[container.length - 1] : head;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(4, l3);
        ListNode l5 = new ListNode(5, l4);
        ListNode reverseBetween = reverseBetween(l5, 2, 4);
        //      ListNode reverseBetween = l5;

        while(reverseBetween != null){
            System.out.print(reverseBetween.val + "->");
            reverseBetween = reverseBetween.next;
        }
    }
}
