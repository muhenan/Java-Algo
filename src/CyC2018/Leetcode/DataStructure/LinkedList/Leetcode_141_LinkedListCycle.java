package CyC2018.Leetcode.DataStructure.LinkedList;

// 快慢指针，能相遇就是有环，否则走到尽头就是没有

public class Leetcode_141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
