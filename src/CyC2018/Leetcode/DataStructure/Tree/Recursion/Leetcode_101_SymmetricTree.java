package CyC2018.Leetcode.DataStructure.Tree.Recursion;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

public class Leetcode_101_SymmetricTree {
    /**
     * 用一个小函数，注意左右的互换（也就是说左右子树是对称的）
     * */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return isSymmetricAB(root.left, root.right);
    }
    private boolean isSymmetricAB(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        if (A.val != B.val) return false;
        return isSymmetricAB(A.left, B.right) && isSymmetricAB(A.right, B.left);
    }
}
