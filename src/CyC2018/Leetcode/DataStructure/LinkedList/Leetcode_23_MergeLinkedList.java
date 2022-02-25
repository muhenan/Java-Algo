package CyC2018.Leetcode.DataStructure.LinkedList;

// hard
// merge 几个升序的链表

// 思考一下时间复杂度，因为一共 nk 个元素，那么时间复杂度的话就是 nk 再乘一个数
// 最简单的方法我们可以得到 nk2 ，那么优化一下呢？最优能到 nklogk 吧，这应该就是最优结果了

/**
 * 方法 1 ：归并每一个
 *      用归并排序算法的思想，把每一行都归并进去
 *      时间复杂度的话，我们可以算一下最后一行走了 n 个，倒数第二行相当于用了两遍，走了 2n 个，那么第一行走了 kn 次
 *      时间复杂度：kn + (k - 1)n + ... + 3n + 2n + n = (k + 1)nk / 2 = O(nk2)
 *      用时：102ms
 * 方法 1.1 ：每次找一个最小的
 *      在列上遍历，每次找到最小的一个
 *      相当于找一个需要 k 的时间复杂度，那么一共 nk 个，总的时间复杂度为 O(nk2)
 *      用时：321ms
 * 方法 2 ：归并排序的思想
 *      两两归并，最后得到的时间复杂度是 O(logk * nk) 相当于每一个都被用了 logk 次
 *      用时：1ms
 * 方法 3 ：优先队列（堆）
 *      时间复杂度：O(logk * nk)
 *      优先队列中的元素不超过 k 个，那么插入和删除的时间代价为 O(logk)
 *      总体来说就是用优先队列（最小堆）维护了这个最小值 每次维护的成本是 O(logk)
 *      用时：4ms
 *
 * **/

import java.util.PriorityQueue;

/**
关于 Java 的 Comparable 接口

package java.lang;
public interface Comparable<E>{
	public int compareTo(E o);
}
// compareTo 方法判断这个对象相对于给定对象o 的顺序，并且当这个对象小于、等于或
// 大于给定对象o 时，分别返回负整数、0或正整数
// Comparable 接口是一个泛型接口。在实现该接口时，泛型类型E 被替换成一种具体的类型

**/

public class Leetcode_23_MergeLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) return null;
        else if (length == 1) return lists[0];
        else {
            ListNode res = lists[0];
            for (int i = 1; i < length; i++) {
                res = mergeTwoLists(res, lists[i]);
            }
            return res;
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode Node_i = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                Node_i.next = l1;
                Node_i = Node_i.next;
                l1 = l1.next;
            } else {
                Node_i.next = l2;
                Node_i = Node_i.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) Node_i.next = l1;
        else if (l2 != null) Node_i.next = l2;
        return dummy.next;
    }


    public ListNode mergeKLists11(ListNode[] lists) {
        int k = lists.length;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (true) {
            ListNode minNode = null;
            int minPointer = -1;
            for (int i = 0; i < k; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minPointer = i;
                }
            }
            if (minPointer == -1) {
                break;
            }
            tail.next = minNode;
            tail = tail.next;
            lists[minPointer] = lists[minPointer].next;
        }
        return dummyHead.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) return null;
        else if (length == 1) return lists[0];
        else {
            ListNode[] resultLists = new ListNode[length / 2 + length % 2];
            int index = 0;
            int i = 0;
            while (i < length - 1) {
                resultLists[index++] = mergeTwoLists(lists[i], lists[i + 1]);
                i += 2;
            }
            if (i == length - 1) resultLists[index] = lists[i];
            return mergeKLists2(resultLists);
        }
    }

    class firstNodeOfAList implements Comparable<firstNodeOfAList> {
        int value;
        ListNode Node;
        firstNodeOfAList(int val, ListNode n) {
            value = val;
            Node = n;
        }
        @Override
        public int compareTo(firstNodeOfAList o) {
            return this.value - o.value; // 这样的话就是正常比较，java 的 pq 是默认最小的在上面，用这个弄出的 pq 就是最小的在上面
        }
    }

    PriorityQueue<firstNodeOfAList> pq = new PriorityQueue<>(); // java 的 pq 是一个默认的小顶堆，或者说小根堆

    public ListNode mergeKLists3(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) return null;
        else if (length == 1) return lists[0];
        else {
            for (int i = 0; i < length; i++) {
                if (lists[i] != null) pq.offer(new firstNodeOfAList(lists[i].val, lists[i]));
            }
            ListNode head = new ListNode(0);
            ListNode tail = head;
            while (!pq.isEmpty()) {
                firstNodeOfAList minOne = pq.poll();
                tail.next = minOne.Node;
                tail = tail.next;
                if (minOne.Node.next != null) pq.offer(new firstNodeOfAList(minOne.Node.next.val, minOne.Node.next));
            }
            return head.next;
        }
    }
}
