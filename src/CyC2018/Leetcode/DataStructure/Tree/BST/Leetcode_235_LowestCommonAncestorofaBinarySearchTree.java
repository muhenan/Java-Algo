package CyC2018.Leetcode.DataStructure.Tree.BST;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

/**
 * p q 没有说大小顺序，所以先确定了一下，然后就是按大小规律 dfs 的去找
 * 题目给的 BST 其实反而没有难度了
 * */
public class Leetcode_235_LowestCommonAncestorofaBinarySearchTree {
    TreeNode low;
    TreeNode high;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        low = p.val < q.val ? p : q;
        high = q.val > p.val ? q : p;
        return dfs(root, low, high);
    }
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root.val < p.val) return dfs(root.right, p, q);
        if (root.val > q.val) return dfs(root.left, p, q);
        return root;
    }

    /**
     * Cyc 写的更好，直接都不用看 p q 的大小了
     * 如果都小，那么公共祖先在左边；如果都大，那么公共祖先在右边
     * 除此以外的情况就是分居两侧，那么公共祖先就是中间的root
     * */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor2(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor2(root.right, p, q);
        return root;
    }
}
