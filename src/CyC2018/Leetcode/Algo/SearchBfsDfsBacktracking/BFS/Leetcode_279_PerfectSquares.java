package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.BFS;

import java.util.Deque;
import java.util.*;

/**
 * BFS 的模版问题就在于，这个东西的结构可以看作是一圈一圈的，找最短路径可以一圈一圈的往外走，圈数就是答案路径长度
 * 该题目也可以看作是一圈一圈，比如 13 对应的第一圈是 1 2 3，其中这个 1 又连着一圈 1 2 3，这种情况下，显然 2 3 这样走是最快可以到的了
 * */
public class Leetcode_279_PerfectSquares {
    /**
     * //目前还是超时，平方那块也优化了，最重点的优化只能是优化开始的位置，优化数的顺序，不能再这样简单的从大到小了
     * 之前一直都是超时，加了标记之后，不走走过的路了，效率提高，不超时了！！！
     * 虽然相比其他的，效率不高，可能是因为从小到大的缘故，从大到小会更快，但是已经过了！！！
     * */
    public int numSquares(int n) {
        int length = (int) Math.sqrt(n);
        Deque<Node> myQueue = new LinkedList<>();
        for (int i = 1; i <= length; i++) myQueue.add(new Node(0, i));
        int[] squareArray = new int[length + 1];
        int square = 1;
        int diff = 3;
        for (int i = 1; i <= length; i++) {
            squareArray[i] = square;
            square += diff;
            diff += 2;
        }
        int ans = 0;

        //加个标记
        boolean[] marked = new boolean[n + 1];

        /**
         * 关于这个标记的必要性，举一个最简单的例子
         * 比如 1 - 1 - 1 - 1 - 1 - 这个路径，如果没有标记，就用无尽的走下去
         * 而有了标记之后，走了四个的时候就会判断到这个 currSum 4 已经记录过了，就不会再继续向下走了
         * */

        while (!myQueue.isEmpty()) {
            ans++;
            int size = myQueue.size();
            while (size-- > 0) {
                Node currNode = myQueue.poll();
                int currSum = currNode.sum + squareArray[currNode.value];
                if (currSum == n) return ans;
                if (currSum > n) continue;
                if (marked[currSum]) continue;
                for (int i = currNode.value; i <= length; i++) myQueue.add(new Node(currSum, i));
                marked[currSum] = true;
            }
        }
        return ans;
    }

    private class Node {
        int sum;
        int value;
        Node(int s, int v) {
            sum = s;
            value = v;
        }
    }

    /**
     * 力扣官方，动态规划方式，解析见 Note
     * 时间复杂度：n sqrt(n)
     * */
    public int numSquares2(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }

    /**
     * 数学的方法就不说了，Note 中有，了解一下即可
     * */

    public static void main(String[] args) {
        Leetcode_279_PerfectSquares solu = new Leetcode_279_PerfectSquares();
        System.out.println(solu.numSquares(12));
    }


    /**
     * Cyc 给的 BFS 的方法，和 Note 中的图一样，从最大数开始走
     * 这里用到了这个很重要的标记，如果这个大数走过，就不再走了！！！这非常重要，提高效率，降低时间损耗！
     * */
    public int numSquares3(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) { // 从小到大即可
                    int next = cur - s;
                    if (next < 0) break; // 过了
                    if (next == 0) return level; // 找到正确答案
                    if (marked[next]) continue; // 已经记录了这个大数了，直接跳过
                    marked[next] = true; // 记录这个大数
                    queue.add(next); // 添加到队列中
                }
            }
        }
        return n;
    }

    /**
     * 生成小于 n 的平方数序列
     * @return 1,4,9,...
     */
    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}
