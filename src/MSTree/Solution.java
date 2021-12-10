package MSTree;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    //98. 验证二叉搜索树
    // 这个方法不行没考虑大的上下界的问题！
//    public boolean isValidBST(TreeNode root) {
//        if(root == null) return false;
//        if(root.left == null && root.right == null) return true;
//        if(root.left != null && root.right != null){
//            return (root.left.val < root.val
//                    && root.val < root.right.val
//                    && isValidBST(root.left)
//                    && isValidBST(root.right));
//        }
//        else if(root.left != null){
//            return (root.left.val < root.val) && isValidBST(root.left);
//        }else{
//            return (root.val < root.right.val) && isValidBST(root.right);
//        }
//    }
        // 递归的方法，直接就是带着上下界递归看是否不是BST，什么样的不是BST，只要把根的值和上下界比即可
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    // 中序遍历的方式，记住BST中序遍历后就是一个从小到大的排序
    // 这种中序遍历和之前的不同这种是通过直接到最左这样找的
    // 非常经典和特殊的中序遍历方法！！！！！！！！！！！！！！！！！
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

}
