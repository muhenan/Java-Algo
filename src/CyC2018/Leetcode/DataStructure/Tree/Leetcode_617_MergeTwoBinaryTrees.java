package CyC2018.Leetcode.DataStructure.Tree;

/**
 * 树中的递归：对于左子树的事，将左子树当成新树交给函数，右边亦然，我们只注重当前这个节点的事
 * */
public class Leetcode_617_MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        else if (root2 == null) return root1;
        else {
            root1.val += root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }
}
