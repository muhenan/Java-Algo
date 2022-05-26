package CyC2018.Leetcode.DataStructure.Tree.BST;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的思路依旧是，中序遍历，找到所有众数
 * 找这些众数的时候用一个 List，删减比较好操控，长度可变，在这里比 int 数组好用好操作
 * 这里 pre 也是从上题得到启示，用了 TreeNode
 * 总体来看代码杂乱一点，但实际题目无难度
 * */
public class Leetcode_501_FindModeinBinarySearchTree {
    List<Integer> ans;
    TreeNode pre;
    int maxCount;
    int count;
    public int[] findMode(TreeNode root) {
        ans = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        inOrder(root);
        int length = ans.size();
        int[] resArray = new int[length];
        for (int i = 0; i < length; i++) resArray[i] = ans.get(i);
        return resArray;
    }
    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (pre == null) {
            count = 1;
            maxCount = 1;
            ans.add(root.val);
        } else {
            if (root.val == pre.val) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                    ans.clear();
                    ans.add(root.val);
                } else if (count == maxCount) ans.add(root.val); // 这里的 if 判断太多太深了，最后这个判断相等 add 的是相同的，可以合并
            } else {
                count = 1;
                if (count == maxCount) ans.add(root.val);
            }

//            if (root.val == pre.val) count++; //优化的写法，没有嵌套的 if 判断了
//            else count = 1;
//            if (count > maxCount) {
//                maxCount = count;
//                ans.clear();
//                ans.add(root.val);
//            } else if (count == maxCount) ans.add(root.val);

        }
        pre = root;
        inOrder(root.right);
    }

//    public static void main(String[] args) {
//        Leetcode_501_FindModeinBinarySearchTree solu = new Leetcode_501_FindModeinBinarySearchTree();
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(2);
//        int[] res = solu.findMode(root);
//    }

    /**
     * 以下是 Cyc 的代码，思路一样，但代码简洁一些，if 判断没那么深
     * */
    private int curCnt = 1;
    private int maxCnt = 1;
    private TreeNode preNode = null;

    public int[] findMode2(TreeNode root) {
        List<Integer> maxCntNums = new ArrayList<>();
        inOrder2(root, maxCntNums);
        int[] ret = new int[maxCntNums.size()];
        int idx = 0;
        for (int num : maxCntNums) {
            ret[idx++] = num;
        }
        return ret;
    }

    private void inOrder2(TreeNode node, List<Integer> nums) {
        if (node == null) return;
        inOrder2(node.left, nums);
        if (preNode != null) {
            if (preNode.val == node.val) curCnt++;
            else curCnt = 1;
        }
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            nums.clear();
            nums.add(node.val);
        } else if (curCnt == maxCnt) {
            nums.add(node.val);
        }
        preNode = node;
        inOrder2(node.right, nums);
    }
}
