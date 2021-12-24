package CyC2018.Leetcode.DataStructure.LinkedList;

public class Leetcode_24_SwapNodesinPairs {

    // iteration
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode left = head;
        ListNode right = head.next;
        while (left != null && right != null) {
            pre.next = right;
            left.next = right.next;
            right.next = left; // 这三句是在掰 LinkedNode 的 next 箭头
            pre = left;
            left = left.next;
            right = left == null ? null : left.next; // 这三句是移动三个指针
        }
        return dummy.next;
    }

    // recursion 这种不写了，太简单，且占内存 O(n)
}
