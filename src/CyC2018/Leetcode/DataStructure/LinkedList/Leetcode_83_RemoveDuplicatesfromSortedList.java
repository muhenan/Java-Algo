package CyC2018.Leetcode.DataStructure.LinkedList;

public class Leetcode_83_RemoveDuplicatesfromSortedList {
    // recursion
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            return head.next;
        }
        else {
            return head;
        }
    }

    // iteration 1
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        while (pre != null && pre.next != null) {
            if (pre.val != pre.next.val) {
                pre = pre.next;
            }
            else {
                ListNode iterator = pre.next;
                while (iterator != null && pre.val == iterator.val) {
                    iterator = iterator.next;
                }
                pre.next = iterator;
                pre = pre.next;
            }
        }
        return head;
    }

    // iteration 2
    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode left = head;
        ListNode right = head.next;
        while (right != null) {
            if (left.val != right.val) {
                left = left.next;
                right = right.next;
            } else {
                right = right.next;
                left.next = right;
            }
        }
        return head;
    }
}
