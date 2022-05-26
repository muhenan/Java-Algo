package CyC2018.Leetcode.DataStructure.Tree.BST;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

/**
 * 235 的进阶
 * 235 给的是 BST，所以题目非常简单
 * 这次不是 BST 了，但是说了树中的元素各不相同，所以难度其实也降低了
 * 如果这个树中的元素没有任何限制的话，那么题目才真正有难度
 *
 * 回到本题，既然各个元素都各不相同，那么只要这个元素等于 p q 中的一个就可以直接返回这个了
 * 但这样不一定两个都找到，所以左右树都要找
 * 如果左右树都找到了那么就是中间这个是答案
 * 否则就是唯一找到的那个是答案
 * */
public class Leetcode_236_LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}
