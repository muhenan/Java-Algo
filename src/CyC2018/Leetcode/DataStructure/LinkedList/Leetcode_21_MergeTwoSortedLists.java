package CyC2018.Leetcode.DataStructure.LinkedList;

public class Leetcode_21_MergeTwoSortedLists {

    // recursion Time: O(m+n) Space: O(m+n)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }

    // iteration Time: O(m+n) Space: O(1)
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1, null);
        ListNode pre = head;
        while (!(list1 == null && list2 == null)) {
            if (list1 == null) {
                pre.next = list2;
                return head.next;
            }
            if (list2 == null) {
                pre.next = list1;
                return head.next;
            }
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        return head.next;
    }
}
