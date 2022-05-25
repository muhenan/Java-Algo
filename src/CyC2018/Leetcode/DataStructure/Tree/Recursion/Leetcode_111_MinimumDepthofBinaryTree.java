package CyC2018.Leetcode.DataStructure.Tree.Recursion;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

public class Leetcode_111_MinimumDepthofBinaryTree {
    /**
     * 该题为 104 的变形，104 是找最大深度，本题找最小深度
     * */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
    // 注意左或者右是空树的情况

//    CyC
//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        int left = minDepth(root.left);
//        int right = minDepth(root.right);
//        if (left == 0 || right == 0) return left + right + 1;
//        return Math.min(left, right) + 1;
//    }
}
