package CyC2018.Leetcode.Algo.DynamicProgramming.Bag01;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_139_WordBreak {
    boolean[] dp;
    int length;
    public boolean wordBreak(String s, List<String> wordDict) {
        length = s.length();
        dp = new boolean[length + 1];
        wordDp(s, 0, wordDict);
        return dp[length];
    }

    private void wordDp(String str, int index, List<String> wordDict) {
        for (String word : wordDict) {
            int lengthOfword = word.length();
            if (index + lengthOfword > length || dp[index + lengthOfword]) continue;
            else {
                if (str.substring(index).startsWith(word)) {
                    dp[index + lengthOfword] = true;
                    if (index + lengthOfword == length) break;
                    wordDp(str, index + lengthOfword, wordDict);
                }
            }
        }
        return;
    }

    /**
     * 自底向上 2 for
     * 完全背包问题，内层 for 循环物品
     * */
    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {   // 对物品的迭代应该放在最里层
                int len = word.length();
                if (len <= i && word.equals(s.substring(i - len, i))) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        //System.out.println("AA".startsWith("AABC")); {"cats","dog","sand","and","cat","an"}
        List<String> my_list = new ArrayList<String>();
        my_list.add("cats");
        my_list.add("dog");
        my_list.add("sand");
        my_list.add("and");
        my_list.add("cat");
        my_list.add("an");
        Leetcode_139_WordBreak solu = new Leetcode_139_WordBreak();

        System.out.println(solu.wordBreak("catsandogcat",my_list));
    }
}
