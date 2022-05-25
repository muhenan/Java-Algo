package CyC2018.Leetcode.DataStructure.Tree.BST;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

import java.util.*;

public class Leetcode_230_KthSmallestElementinaBST {


    /**
     * 首先最简单直接的方法，中序遍历
     * 按大小顺序走一遍
     *      两种方法找到 k
     *          1. 一种是遍历一个数就 count++ 一下，到 k 的时候直接返回
     *          2. 把遍历的数按顺序存到一个数据结构中，用的时候直接用即可
     *
     * 以下是力扣网友写的一个代码，直接写了循环形式的中序遍历
     * 可以看出网友对循环形式的中序遍历极其熟练，可以好好学学这里的写法
     * */
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> d = new ArrayDeque<>();
        while (root != null || !d.isEmpty()) {
            while (root != null) {
                d.addLast(root);
                root = root.left; // 刚从这个 while 出来的时候 root 一定是 null，所以下面直接 root 用 poll 的
            } // 这里while出来后，Deque里肯定是有东西的
            root = d.pollLast(); // 到这里 root 就肯定有东西了
            if (--k == 0) return root.val;
            root = root.right;
        }
        return -1;

//        作者：nickBean
//        链接：https://leetcode.cn/problems/kth-smallest-element-in-a-bst/solution/nick-by-nickbean-s1c9/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }



    /**
     * Cyc 的第二种方法
     * 递归原函数的方法，还用了一个记录节点数的子函数
     * 个人感觉时间复杂度比较高，意义不大
     * */
    public int kthSmallest2(TreeNode root, int k) {
        int leftCnt = count(root.left);
        if (leftCnt == k - 1) return root.val;
        if (leftCnt > k - 1) return kthSmallest2(root.left, k);
        return kthSmallest2(root.right, k - leftCnt - 1);
    }

    private int count(TreeNode node) {
        if (node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }


    /**
     * 多年前的自解方法
     * 直接用原函数递归，中序遍历，思路非常简单，也是计数 count，计到了 k 就记录 result
     * */
//    int count = 0;
//    int result = 0;
//    int kthSmallest(TreeNode* root, int k) {
//        if(!root) return result;
//        if(root->left) kthSmallest(root->left,k);
//        count++;
//        if(count == k) result = root->val;
//        if(root->right) kthSmallest(root->right,k);
//        return result;
//    }
}
