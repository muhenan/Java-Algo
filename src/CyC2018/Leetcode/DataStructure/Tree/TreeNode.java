package CyC2018.Leetcode.DataStructure.Tree;

public class TreeNode {
    int val;
    MSTree.TreeNode left;
    MSTree.TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, MSTree.TreeNode left, MSTree.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
