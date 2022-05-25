package CyC2018.Leetcode.DataStructure.Tree.BST;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

public class Leetcode_669_TrimaBinarySearchTree {

    /**
     * 自解方法
     * 为了思维清晰，分了 low 和 high 两种剪枝情况
     * 理解好 BST 中元素的大小关系即可
     *
     * 这里解说一下 trim Low 这个函数（ High的同理 ）
     * 如果是 null 当然要返回 null
     * 如果这个比边界小了，那么这个和这个左边的肯定不要了，继续剪这个的右边的
     * 如果是大于等于了，也就是在边界里，那么就剪这个的左边的
     * */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        root = trimLow(root, low);
        root = trimHigh(root, high);
        return root;
    }
    private TreeNode trimLow(TreeNode root, int num) {
        if (root == null) return root;
        if (root.val < num) return trimLow(root.right, num);
        root.left = trimLow(root.left, num);
        return root;
    }
    private TreeNode trimHigh(TreeNode root, int num) {
        if (root == null) return root;
        if (root.val > num) return trimHigh(root.left, num);
        root.right = trimHigh(root.right, num);
        return root;
    }

    /**
     * Cyc 方法，更简洁了，直接分情况递归 trimBST 即可
     * 直接简单粗暴！
     * */
    public TreeNode trimBST2(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val > R) return trimBST2(root.left, L, R);
        if (root.val < L) return trimBST2(root.right, L, R);
        root.left = trimBST2(root.left, L, R);
        root.right = trimBST2(root.right, L, R);
        return root;
    }
}
