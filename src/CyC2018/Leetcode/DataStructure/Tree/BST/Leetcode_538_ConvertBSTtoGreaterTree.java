package CyC2018.Leetcode.DataStructure.Tree.BST;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

import java.util.Deque;
import java.util.Stack;

public class Leetcode_538_ConvertBSTtoGreaterTree {
    /**
     * 思路：还是中序遍历，只是这次左右树的顺序换一下，先从最大的开始
     * 直接尝试写循环式的中序遍历！！
     * */
    public TreeNode convertBST(TreeNode root) {
        TreeNode curr = root;
        int sum = 0;
        Stack<TreeNode> myStack = new Stack<>();
        while (curr != null || !myStack.isEmpty()) {
            while (curr != null) {
                myStack.push(curr);
                curr = curr.right;
            }
            curr = myStack.pop();

            sum += curr.val;
            curr.val = sum;

            curr = curr.left;
        }
        return root;
    }



    /**
     * 比较无脑一点的递归写法
     * */
    private int sum = 0;

    public TreeNode convertBST2(TreeNode root) {
        traver(root);
        return root;
    }

    private void traver(TreeNode node) {
        if (node == null) return;
        traver(node.right);
        sum += node.val;
        node.val = sum;
        traver(node.left);
    }
}
