package CyC2018.Leetcode.DataStructure.LinkedList;

public class Leetcode_725_SplitLinkedListinParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int count = 0;
        ListNode iteratorOfCount = head;
        while (iteratorOfCount != null) {
            count++;
            iteratorOfCount = iteratorOfCount.next;
        }
        ListNode iterator = head;
        int remainder = count % k;
        int quotient = count / k;
        for (int i = 0; i < k; i++) {
            res[i] = iterator;
            int currentSize = quotient + (remainder-- > 0 ? 1 : 0);
            for (int j = 0; j < currentSize - 1; j++) {
                if (iterator != null) {
                    iterator = iterator.next;
                }
            }
            ListNode pre = iterator;
            if (iterator != null) {
                iterator = iterator.next;
                pre.next = null;
            }
        }
        return res;
    }
}
