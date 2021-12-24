package CyC2018.Leetcode.DataStructure.LinkedList;

import java.util.Stack;

public class Leetcode_445_AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = getStackByLinkedList(l1);
        Stack<Integer> stack2 = getStackByLinkedList(l2);
        ListNode res = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            int remainder = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            res = new ListNode(remainder, res);
        }
        return res;
    }
    private Stack<Integer> getStackByLinkedList(ListNode l1) {
        Stack<Integer> res = new Stack<>();
        while (l1 != null) {
            res.push(l1.val);
            l1 = l1.next;
        }
        return res;
    }
}
