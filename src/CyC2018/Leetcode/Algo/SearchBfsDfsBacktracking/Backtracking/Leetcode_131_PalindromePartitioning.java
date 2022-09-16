package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.Backtracking;

import java.util.*;

/**
 * 问的是所有可能的分割方式
 *
 * 回溯！
 * **/
public class Leetcode_131_PalindromePartitioning {
    private int lengthOfS;
    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> tempPartition = new ArrayList<>();
        lengthOfS = s.length();
        //doPartition(s, partitions, tempPartition);
        bt(s, partitions, tempPartition, 0);
        return partitions;
    }
//    private void doPartition(String s, List<List<String>> partitions, List<String> tempPartition) {
//        if (s.length() == 0) {
//            partitions.add(new ArrayList<>(tempPartition));
//            return;
//        }
//        /**
//         * 这里的思路就是，从前面隔一小段，这一小段是回文的，然后后面剩下的，扔到 backtrack 函数里再继续去割
//         * **/
//        for (int i = 0; i < s.length(); i++) {
//            if (isPalindrome(s, 0, i)) {
//                tempPartition.add(s.substring(0, i + 1));
//                doPartition(s.substring(i + 1), partitions, tempPartition);
//                tempPartition.remove(tempPartition.size() - 1);
//            }
//        }
//    }

    private void bt(String s, List<List<String>> partitions, List<String> tempPartition, int startIndex) {
        if (startIndex == lengthOfS) {
            partitions.add(new ArrayList<>(tempPartition));
            return;
        }
        for (int i = startIndex; i < lengthOfS; i++) {
            if (isPalindrome(s, startIndex, i)) {
                tempPartition.add(s.substring(startIndex, i + 1)); // 左闭右开
                bt(s, partitions, tempPartition, i + 1);
                tempPartition.remove(tempPartition.size() - 1);
            }
        }
    }


    // 判断回文
    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Leetcode_131_PalindromePartitioning solu = new Leetcode_131_PalindromePartitioning();
        solu.partition(new String("aab"));
    }

}
