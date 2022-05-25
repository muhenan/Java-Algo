package CyC2018.Leetcode.DataStructure.Tree.Recursion;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_337_HouseRobberIII {
    /**
     * 这种方法谈不上错，就是时间复杂度太高了，有太多的重复运算，最后导致了超时
     * public int rob(TreeNode root)
     if (root == null) return 0;

     // take root.val
     int left = root.left != null ? rob(root.left.left) + rob(root.left.right) : 0;
     int right = root.right != null ? rob(root.right.left) + rob(root.right.right) : 0;
     int takeRoot = root.val + left + right;

     // do not take root.val
     left = rob(root.left);
     right = rob(root.right);
     int notTakeRoot = left + right;

     return Math.max(takeRoot, notTakeRoot);
     */

    /** 优化
     *  从上面的方法可以看出，每个 node，都会有一个对应的 rob(node) 值
     *  但这个值第一次被计算出来后，后面可能还会再被重复计算，这里我们用一个哈希表把每个 node 对应的 rob 值保持下来
     *  用的时候直接从哈希表里找，这样就避免了重复计算
     * */

    Map<TreeNode, Integer> record = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (record.containsKey(root)) return record.get(root);
        int Yes = root.val;
        if (root.left != null) Yes += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) Yes += rob(root.right.left) + rob(root.right.right);
        int No = rob(root.left) + rob(root.right);
        int max = Math.max(Yes, No);
        record.put(root, max);
        return max;
    }
    /**
     * 不要对顺序等问题考虑的太多，我们要的是一个通用的函数
     * 关于哈希表的使用，就是刚开始的时候直接看是否 contain root 如果 contain 就直接用
     * (这样就简化了这个哈希表的使用，直接把节点带到 rob 里，就相当于使用哈希表了)
     * 否则就开始算
     * 最后算完了把这个 key-value 对存进去
     * */

    /**
     * 这里有一个力扣的 动态规划方法的一个比较通用的写法
     * 注意这里一个非常通用的写法，dfs 的时候，上来不分什么情况直接先分别 dfs 左和右
     * 即先填 dp 表
     * 后面再是各种运算
     * */
//    class Solution {
//        Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
//        Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();
//
//        public int rob(TreeNode root) {
//            dfs(root);
//            return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
//        }
//
//        public void dfs(TreeNode node) {
//            if (node == null) {
//                return;
//            }
//            dfs(node.left);
//            dfs(node.right);
//            f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
//            g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
//        }
//    }
//
//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/house-robber-iii/solution/da-jia-jie-she-iii-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
