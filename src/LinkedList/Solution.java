package LinkedList;

public class Solution {
    // 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next; //先换指向
            head.next = pre; //再向右依次移动三个指针
            pre = head;
            head = next;
        }
        return pre;
    }


}
