package CyC2018.Leetcode.DataStructure.Tree.PreInPostTraversal;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Leetcode_144_BinaryTreePreorderTraversal {

    // 非常简单的递归的先序遍历
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) dfs(root);
        return res;
    }
    private void dfs(TreeNode root) {
        if (root != null) {
            res.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }

    // 循环的 用一个stack
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> myStack = new Stack<>();
        myStack.push(root);
        while (!myStack.isEmpty()) {
            TreeNode head = myStack.pop();
            ans.add(head.val);
            if (head.right != null) myStack.push(head.right);
            if (head.left != null) myStack.push(head.left);
        }
        return ans;
    }

    // 中序 和 后序的递归写法不在赘述了

    // 中序 和 后序的循环写法

    /**
     * 中序 中序就是按 BST 的话，正好是从左到右，从小到大输出
     *
     * 从中序的核心意义出发，中序的核心意义就是，每一次都去找最左
     *
     * 中序遍历，找最左的逻辑是重点，重点看！！！
     * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root; // cur 记录一下当前指着的一个
        /**
         * 正文开始
         * 如果指着东西或者 stack 不空，就进入循环
         * */
        while (cur != null || !stack.isEmpty()) {
            while (cur != null && cur.left != null) { // 找到最左边的一个
                stack.add(cur); // 在一路找最左的过程中，把路径上的都存进 stack 去
                cur = cur.left;
            }
            if (cur == null) cur = stack.pop(); // 是 null 说明到最后了，这时从 stack 里取之前存的，这时拿出来肯定是要用了，所以下面直接处理
            ret.add(cur.val); // 找到后直接处理这个，这个肯定是要输出的了
            cur = cur.right; // 找完这个找这个的右边
        }
        return ret;
    }

    /**
     * 后序
     * 前序遍历为 root -> left -> right，后序遍历为 left -> right -> root。
     * 可以修改前序遍历成为 root -> right -> left，那么这个顺序就和后序遍历正好相反。
     *
     * 先序和后序可以通过一些小的换顺序互相转换
     * */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            ret.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(ret);
        return ret;
    }


}
