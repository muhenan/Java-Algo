package CyC2018.Leetcode.Algo.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/**
 * 关于树的一个分治，递归的问题
 * 题目不难，注意这种 TreeNode 数据结构，要搞出新的一个的时候要用 new，否则会改变之前的，指针还指着之前的，内存不会被销毁
 * 每次都从根结点开始分治即可
 *
 * 树的简单题目！
 * **/
public class Leetcode_95_UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int low, int high) {
        List<TreeNode> trees = new ArrayList<>();
        if (low > high) {
            trees.add(null);
            return trees;
        }
        else if (low == high) {
            trees.add(new TreeNode(low));
            return trees;
        }
        for (int i = low; i <= high; i++) {
            List<TreeNode> leftTrees = generateTrees(low, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, high);
            TreeNode left, right;
            for(TreeNode l_i: leftTrees) {
                left = l_i;
                for (TreeNode r_i: rightTrees) {
                    right = r_i;
                    trees.add(new TreeNode(i, left, right));
                }
            }
        }
        return trees;
    }

    public static void main(String[] args) {
        Leetcode_95_UniqueBinarySearchTreesII solu = new Leetcode_95_UniqueBinarySearchTreesII();
        solu.generateTrees(3);
    }

}
