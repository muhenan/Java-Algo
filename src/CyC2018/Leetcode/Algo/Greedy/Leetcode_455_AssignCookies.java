package CyC2018.Leetcode.Algo.Greedy;

// 贪心的思想：保证每次操作都是局部最优的，并且最后得到的结果是全局最优的。

import java.util.Arrays;

/**
 * 还是跳不过排序，先把两个数组都排序
 * 然后最小胃口的匹配最小且满足他的饼干
 * **/

public class Leetcode_455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int lengthOfG = g.length;
        int lengthOfS = s.length;
        if (lengthOfG == 0 || lengthOfS == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < lengthOfG && si < lengthOfS) {
            if (g[gi] <= s[si++]) gi++;
        }
        return gi;
    }
}
