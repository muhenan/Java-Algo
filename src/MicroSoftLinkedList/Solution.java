package MicroSoftLinkedList;

//class ListNode {
//    int val;
//    LinkedList.ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}

public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 两个链表的交点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode iteratorOfA = headA;
        ListNode iteratorOfB = headB;
        while(iteratorOfA != iteratorOfB){
            iteratorOfA = (iteratorOfA == null ? headB : iteratorOfA.next);
            iteratorOfB = (iteratorOfB == null ? headA : iteratorOfB.next);
        }
        return iteratorOfA;
    }
}
