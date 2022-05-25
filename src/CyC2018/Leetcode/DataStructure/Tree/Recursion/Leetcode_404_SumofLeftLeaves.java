package CyC2018.Leetcode.DataStructure.Tree.Recursion;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

public class Leetcode_404_SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || isLeafNode(root)) return 0;
        else if (isLeafNode(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
        else return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    private boolean isLeafNode(TreeNode root) {
        if (root != null && root.left == null && root.right == null) return true;
        return false;
    }
    // else 还是加上比较好，更规范一些，避免了这个 if 进去出来之后回来的 if 还会进去
}
