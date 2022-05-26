package CyC2018.Leetcode.DataStructure.Tree.BST;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

/**
 * 109 就是在 108 的基础上，把数组变成链表了，对遍历数字有了更高要求，遍历没那么容易了
 * Cyc 采取的方法就还是和以前一样，还是找中间值，只不过这次找链表的中间值要用特定的函数来找一找了
 * 时间复杂度 nlogn，时间复杂度不低
 *
 * 这里注意学习一下找链表中点的上一个节点的这个函数的写法
 *
 * */
public class Leetcode_109_ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;
        preMid.next = null;  // 断开链表
        TreeNode t = new TreeNode(mid.val);
        t.left = sortedListToBST(head);
        t.right = sortedListToBST(mid.next);
        return t;
    }

    /**
     * 这个 preMid 函数很重点，认真学习 pre 到底指着哪个
     * 这个 pre 每次都指着 slow 的上一个（除了只有一个的情况外）
     * 如果偶数个的时候，比如 1 2 3 4 5 6，那么最后 slow 是 3，fast 是 6，pre 就是 2，这里认为的中间一个就是 3
     *      3 用了以后，左边剩的是 1 2，右边剩的是 4 5 6
     * 如果奇数个，比如 1 2 3 4 5，最后 slow 是 3，fast 已经是 5 后面的 null 了，这时候 pre 是 2，没毛病！
     * */
    private ListNode preMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }

    /**
     * 自解方法，其实可以直接把链表转换成数组再弄，会简单很多
     * */

    /**
     * Leetcode 官方方法
     * 遍历链表的时候正常遍历，保证时间复杂度 n
     * 构建树之前，算一下链表长度，构建树的时候就可以根据这个链表长度构建出平衡树
     * 构建的时候还是 dfs 的方式构建
     * 构建出来以后填数的时候，中序遍历的方式填数，这样就保证了时间复杂度 n
     *
     * 其实就是用到了数的个数定了，其实树的形状就也已经定了
     * 然后再中序遍历填数就好了，能保证时间复杂度 n
     *
     * 具体见下面解说，构建树是先序遍历，填数是中序遍历
     * */

    ListNode globalHead;

    public TreeNode sortedListToBST3(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    /**
     * 这里有一个很巧妙的地方
     * 构建树的话，可以看到顺序是
     *      TreeNode root = new TreeNode();
     *      root.left = buildTree(left, mid - 1);
     *      root.right = buildTree(mid + 1, right);
     *      所以构建树用的是一个先序遍历，而且还根据数的个数构建，这样肯定能保证构建出平衡树
     * 填数的时候，顺序是这样
     *      root.left = buildTree(left, mid - 1);
     *      root.val = globalHead.val;
     *      globalHead = globalHead.next;
     *      root.right = buildTree(mid + 1, right);
     *      先左再填数再记录下一个再右，这里填数用的是中序遍历
     *  很巧妙两种遍历方式同时使用了
     *
     *  这里给人一个启示，遍历函数，函数中的不同部分，可能是不同的遍历方式
     *  不能直接说一个遍历函数是什么顺序的遍历，只能说这个函数的某一块内容是什么顺序的遍历
     * */
    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/solution/you-xu-lian-biao-zhuan-huan-er-cha-sou-suo-shu-1-3/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
