package CyC2018.Leetcode.DataStructure.LinkedList;

public class Leetcode_142_CycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            if (slow == fast) {
                ListNode res = head;
                slow = slow.next; // ********** 关键哦， 细节地方要看好
                while (res != slow) {
                    res = res.next;
                    slow = slow.next;
                }
                return res;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
}
