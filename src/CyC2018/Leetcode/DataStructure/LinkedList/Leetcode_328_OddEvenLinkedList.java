package CyC2018.Leetcode.DataStructure.LinkedList;

public class Leetcode_328_OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode iterationOdd = head;
        ListNode evenHead = head.next;
        ListNode iterationEven = evenHead;
        while (iterationEven.next != null) {
            iterationOdd.next = iterationEven.next;
            iterationOdd = iterationOdd.next;
            if (iterationOdd.next != null) {
                iterationEven.next = iterationOdd.next;
                iterationEven = iterationEven.next;
            } else {
                break;
            }
        }
        iterationEven.next = null;
        iterationOdd.next = evenHead;
        return head;
    }
}
