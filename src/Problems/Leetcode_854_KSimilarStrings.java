package Problems;

public class Leetcode_854_KSimilarStrings {



    // Backtracking
    /**
     * 使用了 s1.toCharArray()，全程操作 char[]
     * */
    int result = Integer.MAX_VALUE;
    public int kSimilarity(String s1, String s2) {
        return backtracking(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }

    public int backtracking(char[] sc1, char[] sc2, int start, int current) {
        if (current >= result) return result; // 如果交换次数已经超过"目前最小交换次数result"，终止递归
        if (start == sc1.length - 1) return result = Math.min(current, result); // 到最后一个了，肯定是正确的

        for (int i = start; i < sc1.length; i++) {
            if (sc1[i] != sc2[i]) { // 对位不正确，即开始操作
                for (int j = i + 1; j < sc2.length; j++) {
                    if (sc2[j] == sc1[i] && sc2[j] != sc1[j]) { // 换这种，换过去是对的，且之前它在老的地方也不对
                        swap(sc2, i, j); // 交换
                        backtracking(sc1, sc2, i + 1, current + 1); // Backtracking
                        swap(sc2, i, j); // 回溯
                        if (sc2[i] == sc1[j]) break; // 如果sc1和sc2的i位于j位互为相等，那么就是最优交换
                    }
                }
                return result;
            }
        }

        return result = Math.min(current, result);
    }

    public void swap(char[] sc, int i, int j){
        char temp = sc[i];
        sc[i] = sc[j];
        sc[j] = temp;
    }
}
