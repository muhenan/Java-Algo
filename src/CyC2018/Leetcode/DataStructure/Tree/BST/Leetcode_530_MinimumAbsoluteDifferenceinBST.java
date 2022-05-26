package CyC2018.Leetcode.DataStructure.Tree.BST;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

/**
 * 最直接的思路就是把所有的元素都两两匹配一下就好了，找出差值最小的
 * 给的是 BST 就更简单了，中序遍历从小到大找差值皆可，记录最小的
 * */
public class Leetcode_530_MinimumAbsoluteDifferenceinBST {
    int ans;
    int pre;
    public int getMinimumDifference(TreeNode root) {
        ans = 100005;
        pre = root.val;
        inOrder(root);
        return ans;
    }
    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        int temp = root.val - pre;
        if (temp > 0 && temp < ans) ans = temp;
        pre = root.val;
        inOrder(root.right);
    }

    /**
     * 下面是 Cyc 的解法，思路是一样的，但 Cyc 给的更好看一点，pre 用的是 TreeNode，初始化的时候可以用 null
     * */
//    private int minDiff = Integer.MAX_VALUE;
//    private TreeNode preNode = null;
//
//    public int getMinimumDifference(TreeNode root) {
//        inOrder(root);
//        return minDiff;
//    }
//
//    private void inOrder(TreeNode node) {
//        if (node == null) return;
//        inOrder(node.left);
//        if (preNode != null) minDiff = Math.min(minDiff, node.val - preNode.val);
//        preNode = node;
//        inOrder(node.right);
//    }
}
