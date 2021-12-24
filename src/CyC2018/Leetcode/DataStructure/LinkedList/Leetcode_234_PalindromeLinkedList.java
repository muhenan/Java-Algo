package CyC2018.Leetcode.DataStructure.LinkedList;

public class Leetcode_234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;
        ListNode midPointer = findMidPointerAndCut(head);
        ListNode head2 = reverse(midPointer);
        return isEqual(head, head2);
    }

    private ListNode findMidPointerAndCut(ListNode head) {
        ListNode left = head;
        ListNode right = head.next;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        ListNode res = left.next;
        left.next = null;
        return res;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }

    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

//    public boolean isPalindrome2(ListNode head) {
//        if (head == null) return false;
//        if (head.next == null) return true;
//        long[] arr = new long[10];
//        long count = 0;
//        while (head != null) {
//            count++;
//            arr[head.val] += count;
//            head = head.next;
//        }
//        if (count % 2 == 1) {
//            for(long element: arr) {
//                if (element % (count / 2 + 1) != 0) return false;
//            }
//            return true;
//        } else {
//            for(long element: arr) {
//                if (element % (count + 1) != 0) return false;
//            }
//            return true;
//        }
//    }

    /*
        纪念一下曾经的自己吧，这个方法不可取，有 bug，但永远纪念自己的创意，热爱创意

        以下是自己想出的一种巧妙方法，但可惜之处在于这种方法只能解决数值是 0-9 的情况
        因为运用了哈希表，所以就有了数值的局限性
        但他一遍走完通过 index 存在的某种数学关系完成判断
        属于 “ 逻辑复杂，编程简单 ” 的情况
    */


//    class Solution {
//        public:
//        bool isPalindrome(ListNode* head) {
//            int arr[10];
//            for(int i = 0; i < 10; i++) arr[i] = 0;
//            ListNode* iPoint = head;
//            int count = 0;
//            while(iPoint){
//                count++;
//                arr[iPoint->val] += count;
//                iPoint = iPoint->next;
//            }
//            if(count % 2 == 1){
//                for(int i = 0; i < 10; i++){
//                    if(arr[i] % (count/2 + 1) != 0) return false;
//                }
//                return true;
//            }else{
//                for(int i = 0; i < 10; i++){
//                    if(arr[i] % (count + 1) != 0) return false;
//                }
//                return true;
//            }
//        }
//    };
}
