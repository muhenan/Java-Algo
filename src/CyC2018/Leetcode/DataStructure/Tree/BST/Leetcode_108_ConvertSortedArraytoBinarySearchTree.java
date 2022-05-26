package CyC2018.Leetcode.DataStructure.Tree.BST;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

import java.awt.*;

/**
 * 想了一个比较笨的方法，既然有数组我们就知道 length，即知道有多少个
 * 我们可以先根据个数构造出一个高度平衡的树（用层次遍历的方法构造）
 * 再把数字一个一个的填进树里，这里填的时候用中序遍历的方法
 * */

/**
 * Cyc 方法
 * 几个重要的点：
 *      1 递归的思想，只解决本节点，左树和右树的事都交给函数
 *      2 数组是线性存储的数据结构，但遍历数组的元素不一定要线性的从左到右遍历，遍历数组的原理是通过索引，也可以用中间的索引从中间遍历
 *
 * 这道题的一个重要思路是，我们构建树，一定是从中间那个元素开始构建，或者说我们肯定自顶向下构建，因为我们要保证平衡
 * 这就意味着，我们放入的数字的顺序不能是从小到大的了
 * 这就意味着遍历数组时，不是从左到右，而是想其他的方法遍历，这里用的方式就是从中间遍历，类似于二分查找的那种遍历
 * */
public class Leetcode_108_ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) { // 这里函数的参数传一个数组，其实也只是传了一个地址
        return dfs(nums, 0, nums.length - 1);
    }
    private TreeNode dfs(int[] nums, int beginIndex, int endIndex) {
        if (beginIndex > endIndex) return null;
        int mid = beginIndex + (endIndex - beginIndex) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, beginIndex, mid - 1);
        root.right = dfs(nums, mid + 1, endIndex);
        return root;
    }
}
