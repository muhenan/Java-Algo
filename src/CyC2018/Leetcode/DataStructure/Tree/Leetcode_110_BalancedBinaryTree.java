package CyC2018.Leetcode.DataStructure.Tree;

/**
 * 第一反应：如果配合最大深度的函数来解题的话，如果是分开用两个函数，那么会导致重复查找
 * 找了之前的代码，只要把判断平衡这步加到最大深度函数中即可
 * 这里还有一个反相的思维：
 *     即找反例
 *     找是平衡二叉树不好找，那就找非平衡二叉树，发现不是就返回
 * 该题其实是前面最大深度函数的变形，只要在最大深度函数中每个节点都去判断是否平衡即可
 * */

public class Leetcode_110_BalancedBinaryTree {
    private boolean result = true; // 用一个全局变量 result 表示结果，该变量初始化为 true，找到反例变成 false
    public boolean isBalanced(TreeNode root) {
        isBalancedMaxDepth(root);
        return result;
    }
    private int isBalancedMaxDepth(TreeNode root) { //主要就是这个函数，这是max depth的变形，加了平衡的判断
        if (root == null) return 0;
        int depthOfLeft = isBalancedMaxDepth(root.left);
        int depthOfRight = isBalancedMaxDepth(root.right);
        if (Math.abs(depthOfLeft - depthOfRight) > 1) result = false;
        return Math.max(depthOfLeft, depthOfRight) + 1;
    }
}

// 当一个问题从正面不好入手时要有反相的思维，以退为进
