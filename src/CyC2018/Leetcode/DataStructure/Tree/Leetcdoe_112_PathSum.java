package CyC2018.Leetcode.DataStructure.Tree;

/**
 * 往下找即可，找到的判断标准是，刚好等于 target number，并且是叶子节点
 * */
public class Leetcdoe_112_PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false; // 直接是空，一般用于直接输入了空树
        else if (root.val == targetSum && root.left == null && root.right == null) return true; // 刚好找到
        else { // 继续往下找
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }
}

// 主要是审题，这里说了根节点到叶子节点才算一个路径，没有转弯的情况，说明题目题目给的已经非常简单了
// 注意 val 有正有负
