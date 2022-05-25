package CyC2018.Leetcode.DataStructure.Tree.Recursion;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

/**
 * 我认为依旧是最大深度的变形，只是这次要在每个节点加上统计左右树深度相加的值
 * 并且记录这个值的最大值
 * */
public class Leetcode_543_DiameterofBinaryTree {
    private int diameter = 0; // 关于这种记录的问题，依旧使用一个全局变量来记录
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depthOfLeft = maxDepth(root.left);
        int depthOfRight = maxDepth(root.right);
        diameter = Math.max(diameter, depthOfLeft + depthOfRight);
        return Math.max(depthOfLeft, depthOfRight) + 1;
    }
}
