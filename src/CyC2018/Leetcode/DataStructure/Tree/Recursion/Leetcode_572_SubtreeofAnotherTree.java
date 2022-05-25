package CyC2018.Leetcode.DataStructure.Tree.Recursion;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

public class Leetcode_572_SubtreeofAnotherTree {
    /**
     * 这里我的思路就是用了一个小函数，就是判断从根节点开始，subTree 是不是 Tree 的子树
     * 时间复杂度：相当于在大树的每个点上都去作为根节点和子树进行匹配（目前来看好像没有什么优化）时间复杂度是 m * n ，m n 分别是两个树的节点数
     * */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return isSubTreeStartFromHere(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    // 这里的 isSubtree 第二个参数带进去的永远是 subRoot 所以肯定不是空树， 所以第一个参数绝不能是空树

    private boolean isSubTreeStartFromHere(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        else if (root == null || subRoot == null) return false;
        else if (root.val != subRoot.val) return false;
        else return isSubTreeStartFromHere(root.left, subRoot.left) && isSubTreeStartFromHere(root.right, subRoot.right);
    }
    // 用小函数，把复杂的问题拆分成简单的函数
}
