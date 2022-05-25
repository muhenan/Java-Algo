package CyC2018.Leetcode.DataStructure.Tree.Recursion;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

import java.util.*;


public class Leetcdoe_112_PathSum {
    /**
     * Path Sum 1
     * 往下找即可，找到的判断标准是，刚好等于 target number，并且是叶子节点
     * */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false; // 直接是空，一般用于直接输入了空树
        else if (root.val == targetSum && root.left == null && root.right == null) return true; // 刚好找到
        else { // 继续往下找
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }
    // 主要是审题，这里说了根节点到叶子节点才算一个路径，没有转弯的情况，说明题目题目给的已经非常简单了
    // 注意 val 有正有负

    /**
     * Path Sum 2
     * 统计所有等于 target number 的路径，并且要记录路径
     *
     * 其实解题的逻辑倒不是很难
     * 这里比较复杂的操作就是 Java 的各种数据结构的转换
     *
     * 解题的话，在 1 的基础上，我们传递一个 LinkedList，注意只传递这一个 LinkedList
     * 通过在不同地方时增减 val 来保证只用这一个 LinkedList 就可以模拟所有的情况
     *
     * 每当找到一个正确的序列时，深拷贝这个 LinkedList，保存到最终结果中
     * */
    List<List<Integer>> resultList = new LinkedList<>();
    Deque<Integer> mylist = new LinkedList<>();
    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        pathSumWithList(root, targetSum, mylist);
        return resultList;
    }
    private void pathSumWithList(TreeNode root, int targetSum, Deque<Integer> mylist) {
        if (root == null) return;
        else if (root.val == targetSum && root.left == null && root.right == null) { // 找到了
            mylist.add(root.val);
            resultList.add(new ArrayList<>(mylist));
            mylist.removeLast(); // 用完之后 remove last
            return;
        } else {
            mylist.add(root.val);
            pathSumWithList(root.left, targetSum - root.val, mylist); // 往左树找
            pathSumWithList(root.right, targetSum - root.val, mylist); // 往右树找
            mylist.removeLast();
            return;
        }
    }

    /**
     * Path Sum 3
     *
     * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * */
//    private int resultCount = 0;
//    private int oldTarget = 0;
//    public int pathSum(TreeNode root, int targetSum) {
//        if (root == null) return resultCount;
//        oldTarget = targetSum;
//        fromThisNode(root);
//        return resultCount;
//    }
//    private void currentTarget(TreeNode root, int targetSum) {
//        if (root == null) return;
//        if (root.val == targetSum) resultCount++;
//        currentTarget(root.left, targetSum - root.val);
//        currentTarget(root.right, targetSum - root.val);
//    }
//    private void fromThisNode(TreeNode root) {
//        if (root == null) return;
//        if (root.val == oldTarget) resultCount++;
//        fromThisNode(root.left);
//        fromThisNode(root.right);
//        currentTarget(root.left, oldTarget - root.val);
//        currentTarget(root.right, oldTarget - root.val);
//    }

    /**
     * 这道题需要我们对过程有更深刻的理解
     *
     * 当题目处在一个多变的条件中，我们要从确定的东西开始
     * 题目看起来路径不从根节点开始了，但实际解决问题时，我们还是当作从根节点开始，只是把每个节点都当成根节点
     * 在这道题目中路径是比较随意的，但我们可以定下路径的起点，通过路径的起点进行分情况讨论
     * 对于一棵树，路径的起点无非在：1 根节点，或者 2 左树的某个节点，或者 3 右树的某个节点
     *
     * 对于 2 这种情况，结果为 pathSum(root.left, sum)，即把左树带到这个函数中即可
     * 这就是对过程的抽象，相信过程，把结果交给过程
     * 3 这种情况亦然
     *
     * 所以问题就变成了，根节点为起点，找有多少个符合条件的路径，即我们要写的函数：
     * private int pathSumStartWithRoot(TreeNode root, int sum)
     * 写这个函数并不难，每次根据 val 减 target 的值即可
     * 这里注意的是，即使对了，也不要停（不要忙着 return）比如 1->(-2) 对了, 继续向下可能有 1->(-2)->(-1)->1 这种情况，前面对的话，那么这个就也是对的
     * */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int ret = pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return ret;
    }

    private int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) return 0;
        int ret = 0;
        if (root.val == sum) ret++;
        ret += pathSumStartWithRoot(root.left, sum - root.val) + pathSumStartWithRoot(root.right, sum - root.val);
        return ret;
    }
    /**
     * 更多的去体会函数的意思，不要陷在函数的具体实现中，要体会函数抽象的意义，体会抽象背后的逻辑
     * */
    //leetcode测试中，我的方法和大神的方法运行速度和内存消耗并没有很大区别（甚至我写的冗余的代码还略快2ms）
    /**
     * 优化：
     *      可以看到每个节点不止别遍历了一遍，所以这绝不是最佳的解法，相反，这是一个时间复杂度比较高的解法
     *      我们可以粗略的认为每个节点都被当成起点去遍历了其他的所有节点，所以时间复杂度是 n 乘 n，即平方的复杂度（粗略计算）
     *      我们希望能够尽力优化到每个点只遍历一次，这种最优情况
     * */
    /**
     * 这里提到一种叫 前缀和 的方法（prefix）
     * https://leetcode-cn.com/problems/path-sum-iii/solution/dui-qian-zhui-he-jie-fa-de-yi-dian-jie-s-dey6/
     *
     * 一个节点的前缀和就是该节点到根之间的路径和
     *
     * 题目要求的是找出路径和等于给定数值的路径总数, 而:
     * 两节点间的路径和 = 两节点的前缀和之差
     *
     * 当我们讨论两个节点的前缀和差值时，有一个前提：
     * 一个节点必须是另一个节点的祖先节点
     *
     * 理解了这个之后，问题就得以简化：
     * 我们只用遍历整颗树一次，记录每个节点的前缀和，并查询该节点的祖先节点中符合条件的个数，将这个数量加到最终结果上。
     *
     * 即保证长的那条路径包括短的那条路径
     * 用先序遍历的方法，能保证当遍历到一个节点 X 时，之前遍历的节点 B 一定在路径 OX 中，这里的 O 指的是根节点
     * 注意这里会有很重要的一个操作，就是遍历完自己也遍历完左子树右子树后，把自己去除掉
     * 这个去除的动作至关重要，可以保证这里的操作不影响另一个子树上的操作
     * (即当我们要遍历5，9这个子树时，要把 Map 中记录的 4，7，8这部分子树的情况都删掉)
     * */
    private int oldTarget = 0;
    private Map<Integer, Integer> prefixMap = new HashMap<>();
    public int pathSum4(TreeNode root, int sum) {
        if (root == null) return 0;
        oldTarget = sum;
        prefixMap.put(0, 1);
        return dfs(root, 0);
    }
    private int dfs(TreeNode root, int currentSum) {
        int result = 0;
        if (root == null) return result;
        currentSum += root.val;
        int here = prefixMap.getOrDefault(currentSum - oldTarget, 0); // 这个 here 很精髓，指的是在这里结束
        prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1); // 把自己这里的前缀和 put 进去
        int left = dfs(root.left, currentSum); // 在左树上结束有多少可能的路径
        int right = dfs(root.right, currentSum); // 在右树上结束有多少可能的路径
        result = here + left + right; // 三种情况的可能路径数加一起
        prefixMap.put(currentSum, prefixMap.get(currentSum) - 1); // 去除在自己这里结束的这种情况
        return result;
    }
    // 体验 dfs 深度优先搜索，体验先序遍历
}


