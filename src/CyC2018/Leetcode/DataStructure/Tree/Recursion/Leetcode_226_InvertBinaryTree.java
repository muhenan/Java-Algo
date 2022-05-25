package CyC2018.Leetcode.DataStructure.Tree.Recursion;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

/**
 * 经典题目
 * 对于每一个小的子结构，这里我所说的子结构指的是只有一个根节点和两个子节点的小结果
 * 翻转，无非就是让其左右的树换一下，这就是过程，这就是整个问题中一个小的通用的过程
 * 如果每个小的子结构都能实现这样的翻转，那么整个树将得到翻转
 * */
public class Leetcode_226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode newRight = invertTree(root.left);
            TreeNode newLeft = invertTree(root.right);
            root.left = newLeft;
            root.right = newRight;
        }
        return root;
    }
}
