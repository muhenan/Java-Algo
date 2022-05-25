package CyC2018.Leetcode.DataStructure.Tree.OrderTraversal;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

import java.util.*;

/**
 * 层次遍历
 *
 * 只用一个队列，遍历完一层就记录一下此时队列的长度，这样也就记录了这一层的长度
 *
 * 通过记录长度的方式，把每一层分开
 *
 * （为避免特殊情况，不 add null 的节点）
 * */
public class Leetcode_637_AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        double oldLength = 1;
        double sum = 0;
        while (!myQueue.isEmpty()) {
            for (int i = 0; i < oldLength; i++) {
                TreeNode head = myQueue.poll();
                sum += head.val;
                if (head.left != null) myQueue.add(head.left);
                if (head.right != null) myQueue.add(head.right);
            }
            res.add(sum / oldLength);
            oldLength = myQueue.size();
            sum = 0;
        }
        return res;
    }
}
