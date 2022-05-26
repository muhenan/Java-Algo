package CyC2018.Leetcode.DataStructure.Tree.BST;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode_653_TwoSumIVInputisaBST {
    /**
     * 个人感觉思路非常简单，就是中序遍历，从小到大走，用哈希表记录即可
     * */
    boolean result;
    Set<Integer> mySet = new HashSet<>();
    int myK;
    public boolean findTarget(TreeNode root, int k) {
        result = false;
        myK = k;
        inOrder(root);
        return result;
    }
    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (mySet.contains(root.val)) {
            result = true;
            return;
        } else mySet.add(myK - root.val);
        inOrder(root.right);
        return;
    }

    /**
     * Cyc 的方法是把树通过中序遍历变成一个 Sorted array （回到最早的两数字和了）
     * 然后双指针头尾往中间走，找两数之和
     * 会快一点点
     * */
    public boolean findTarget2(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            int sum = nums.get(i) + nums.get(j);
            if (sum == k) return true;
            if (sum < k) i++;
            else j--;
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }
}
