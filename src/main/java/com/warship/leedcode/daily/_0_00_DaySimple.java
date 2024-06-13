package  com.warship.leedcode.daily;

public class _0_00_DaySimple {

    public static void main(String[] args) {
//        Scanner x = new Scanner( System.in );
//        System.out.println(x.next());
//        Content t1 = new Content();
//        Content t11 = new Content();
//        Content t111 = new Content();
//        Content t1111 = new Content();
//        Content t11111 = new Content();
//        Scanner xx = new Scanner( System.in );
//        System.out.println(xx.next());
//
//        Content[] content = new Content[10000];
//        content[0] = t1;
//        content[1] = t11;
//        content[2] = t111;
//        content[3] = t1111;
//
//        Content t111111 = new Content();
//        Scanner xxx = new Scanner( System.in );
//        System.out.println(xxx.next());
//
//        Content[] content2 = new Content[10000];
//
//        int[] c1 = new int[1024*1024*10];
//        content2[0] = t1;
//        content2[1] = t11;
//        content2[2] = t111;
//        content2[3] = t1111;
//
//        Scanner xxxx= new Scanner( System.in );
//        System.out.println(xxxx.next());
//        int a = -2;
//        System.out.println(a);
//        a = a >> 1;
//        System.out.println(a);
//        System.out.println(-4 >> 1 << 1);


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

    public static class Content {
        int MB = 1024 * 1024;
        byte[] con = new byte[4 * MB];
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
            if(currentNode.next == null || currentNode.next.val != currentNode.val){
                if (needRemove) {
                    preNode.next = currentNode.next;
                    needRemove = false;
                }else {
                    preNode = currentNode;
                }
            }else{

                needRemove = true;
            }
            currentNode = currentNode.next;
        }

        return headNode.next;
    }

    //        if(head.next == null){
    //            return  head;
    //        }
    //
    //        int beSureHead = 0;//headNode 是否已经确定
    //        if(head.val != head.next.val){
    //            beSureHead = 2;
    //        }
    //
    //        ListNode headNode = head;
    //        ListNode preNode = null;
    //        ListNode currentNode = head;
    //        while (currentNode.next != null) {
    //            if (currentNode.val == currentNode.next.val) {
    //                if (beSureHead < 2) {
    //                    headNode = null;
    //                    beSureHead = 0;
    //                }
    //            } else {
    //                if (beSureHead < 2) {
    //                    headNode = currentNode.next;
    //                    beSureHead++;
    //                }
    //            }
    //            currentNode = currentNode.next;
    //        }
    //
    //        return headNode;

}
