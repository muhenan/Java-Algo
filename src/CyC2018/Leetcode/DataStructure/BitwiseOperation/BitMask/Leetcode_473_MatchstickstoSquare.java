package CyC2018.Leetcode.DataStructure.BitwiseOperation.BitMask;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 通过了这里用 BitMask 就是用其来表示火柴的使用情况
 * 即用一个 int 变量就表示了所以可能的 火柴的出现情况
 *
 * 然后主要思想是用了 DFS
 * 这里没有回溯的过程，就是用了一个 DFS
 * 用了 DP 表来减少计算
 * for (int i = index; i < length; i++) 这里也用了很小很小的一个剪枝
 *
 * */
public class Leetcode_473_MatchstickstoSquare {

    HashMap<Integer, Boolean> dp_map;
    int length;
    int sum;

    public boolean makesquare(int[] matchsticks) {
        length = matchsticks.length;
        sum = 0;
        for (int ele:matchsticks) sum += ele;
        if (sum % 4 != 0) return false;
        dp_map = new HashMap<>();
        return bt(0, sum / 4, 0, matchsticks);
    }

    private boolean bt(int index, int currentLength, int included, int[] matchsticks) {
        if (dp_map.containsKey(included)) return dp_map.get(included);
        if (currentLength == 0) {
            if (included == (Math.pow(2, length) - 1)) return true;
            else return bt(0, sum / 4, included, matchsticks);
        }
        boolean flag = false;
        for (int i = index; i < length; i++) {
            if (((1 << i) & included) == 0 && matchsticks[i] <= currentLength) { // 没出现过
                flag = bt(index + 1, currentLength - matchsticks[i], included ^ ( 1 << i ), matchsticks);
            }
            if (flag) {
                dp_map.put(included, true);
                return true;
            }
        }
        dp_map.put(included, false);
        return false;
    }

//    public static void main(String[] args) {
//        System.out.println(2);
//        System.out.println(2^5);
//    }



    /**
     * 也用到了 BitMask 去保持状态和看状态
     * 并且 pow 都没了，直接位运算 1 << n
     * dp 表
     * buttom-up
     * O 2^n * n
     *
     * DP 其实是最容易理解，最容易写的，但是时间复杂度不如上一个各种剪枝的
     * */
    public boolean makesquare2(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        int len = totalLen / 4, n = matchsticks.length;
        /**
         * 这里 1 << n 就是 2^n，即 Math.pow(2, n)
         * 如果一共有 5 个，那么每个用一个二进制位表示，一共有 32 种组合
         * 这个 dp 表也是用来表示每种组合的情况
         * */
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0; // 这个状态当前 % len 的值
        for (int s = 1; s < (1 << n); s++) { // 对于每一种组合，都去计算
            for (int k = 0; k < n; k++) { // 遍历每一个火柴
                if ((s & (1 << k)) == 0) { // 让这个火柴不出现
                    continue;
                }
                // 能到这下面就是说这个火柴出现
                int s1 = s & ~(1 << k); // 把这一个火柴去掉，其他的都留下
                if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) { // 之前的有并且这个可以放进去
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break; // 找到一个就可以 break 了，因为每个 dp[i] 定了以后都是确定的，不会再改变
                }
            }
        }
        return dp[(1 << n) - 1] == 0; // 最后一个，看是不是 mod 0
    }

    public static void main(String[] args) {
        Leetcode_473_MatchstickstoSquare solu = new Leetcode_473_MatchstickstoSquare();
        solu.makesquare(new int[]{1,1,2,2,2});
    }

    /**
     * 除此以外
     * 还有火柴拼成 N 边形 等等题目
     * 473 火柴拼成 四边形 经典中的经典：BitMask DP DFS 剪枝 回溯
     * BitMask 的使用，经典题目
     * */
}
