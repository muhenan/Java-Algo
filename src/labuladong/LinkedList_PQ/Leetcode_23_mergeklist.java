package labuladong.LinkedList_PQ;

import CyC2018.Leetcode.DataStructure.LinkedList.ListNode;

import java.util.PriorityQueue;

public class Leetcode_23_mergeklist {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int length = lists.length;
        if (length == 0) return dummy.next;
//        PriorityQueue<ListNode> pq = new PriorityQueue<>(length, (a, b) -> (a.val - b.val));
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(length, (a, b) -> {
            System.out.println("Hello");
            return a.val - b.val;
        });
        for (ListNode node:lists) {
            if (node != null) pq.add(node);
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = new ListNode(node.val);
            p = p.next;
            node = node.next;
            if (node != null) pq.add(node);
        }
        return dummy.next;
    }
}

/**
 * O(Nlogk)
 * */