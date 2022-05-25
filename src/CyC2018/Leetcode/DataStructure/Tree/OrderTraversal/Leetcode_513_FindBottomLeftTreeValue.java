package CyC2018.Leetcode.DataStructure.Tree.OrderTraversal;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 最底层 最左边 第一个
 * 层次遍历即可
 * */
public class Leetcode_513_FindBottomLeftTreeValue {
    /**
     * 非常简单 自解方法 无难度
     * 层次遍历记录最底层最左边第一个即可
     * */
    public int findBottomLeftValue(TreeNode root) {
        TreeNode res = root;
        Deque<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        while (!myQueue.isEmpty()) {
            int length = myQueue.size();
            for (int i = 0; i < length; i++) {
                TreeNode head = myQueue.poll();
                if (i == 0) res = head;
                if (head.left != null) myQueue.add(head.left);
                if (head.right != null) myQueue.add(head.right);
            }
        }
        return res.val;
    }

    /**
     * Cyc 的方法
     * 简化了代码，层次遍历用的是从右到左的顺序
     * 这样遍历到的最后一个自然就是我们要找的答案
     * */
    public int findBottomLeftValue2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }
}
