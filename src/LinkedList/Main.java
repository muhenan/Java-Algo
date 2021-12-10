package LinkedList;

public class Main {
    public static void main(String[] args) {
        ListNode NodeA = new ListNode(4);
        ListNode NodeB = new ListNode(5);
        ListNode NodeBB = new ListNode(0);
        NodeB.next = NodeBB;
        ListNode NodeC = new ListNode(8);
        NodeA.next = NodeC;
        NodeBB.next = NodeC;
        NodeC.next = new ListNode(3);
        Solution s = new Solution();
        ListNode resNode = s.getIntersectionNode(NodeA, NodeB);
    }
}
