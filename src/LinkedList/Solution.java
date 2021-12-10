package LinkedList;

public class Solution {


    // 找两个链表的交点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A_iterator = headA;
        ListNode B_iterator = headB;

        //if(A_iterator == null || A_iterator == null) return null;

        while (!(A_iterator == null && B_iterator == null)){

//            System.out.println("some message");
//            if(A_iterator == null) System.out.println("A is null");
//            else System.out.println("A is " + A_iterator.val);
//            if(B_iterator == null) System.out.println("B is null");
//            else System.out.println("B is " + B_iterator.val);


            if(A_iterator == B_iterator) return A_iterator;
            else{
                if(A_iterator == null){
                    A_iterator = headB;
                }else A_iterator = A_iterator.next;

                if(B_iterator == null){
                    B_iterator = headA;
                }else B_iterator = B_iterator.next;
            }
        }
        return null;
    }


    // 即使不相交也默认交于 null
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//        ListNode h1 = headA, h2 = headB;
//
//        while (h1 != h2) {
//
//            h1 = h1 == null ? headB : h1.next;
//            h2 = h2 == null ? headA : h2.next;
//        }
//
//        return h1;
//    }

    // 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


}
