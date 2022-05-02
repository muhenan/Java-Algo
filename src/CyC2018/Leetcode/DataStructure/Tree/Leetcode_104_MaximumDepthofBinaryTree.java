package CyC2018.Leetcode.DataStructure.Tree;

/**
 * 最经典的一个题目，树的最大深度，或者说树的高度
 * 传统的递归思想
 * 我将递归思想总结为：将复杂问题的解丢给递归函数，只追求过程间的逻辑
 * */

public class Leetcode_104_MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0; // 这里最好写空树的时候返回0，因为这样可以保证走到最后
        else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
