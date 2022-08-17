package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.Backtracking;

import java.util.*;

/**
 * 非常琐碎的一个题目
 *
 * 特殊情况排除的不好的话，非常容易出 bug
 *
 *
 * */

public class Leetcode_93_IPAddress {

    private int lengOfS;
    private List<String> res = new LinkedList<>();
    private String str;

    public List<String> restoreIpAddresses(String s) {
        lengOfS = s.length();
        if (lengOfS < 4 || lengOfS > 12) return res;
        str = new String(s);
        backtracking(0, 0, new StringBuffer());
        return res;
    }





    void backtracking(int seg, int startid, StringBuffer tempStr) {
        if (seg == 4) {
            if (startid == lengOfS){ // !!!!!!
                tempStr.deleteCharAt(tempStr.length() - 1); // !!!!!
                res.add(tempStr.toString());
                tempStr.append('.'); // ！！！！！！！
            }
        } else {
            if (startid >= lengOfS) return; // !!!!!!!!!
            if (str.charAt(startid) == '0') {
                tempStr.append('0');
                tempStr.append('.');
                backtracking(seg + 1, startid + 1, tempStr);
                tempStr.delete(tempStr.length() - 2, tempStr.length()); // !!!!!!!!!!! 记得剪掉
            } else {
                for (int i = 1; i <= 3 && i + startid <= lengOfS; i++) {
                    String part = str.substring(startid, startid + i);
                    if (Integer.valueOf(part) <= 255) { // !!!!! 一般化
                        tempStr.append(part);
                        tempStr.append('.');
                        backtracking(seg + 1, startid + i, tempStr);
                        tempStr.delete(tempStr.length() - part.length() - 1, tempStr.length()); // !!!!!!!!
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Leetcode_93_IPAddress solu = new Leetcode_93_IPAddress();
        solu.restoreIpAddresses("101023");
    }


    /**
     *
     * 我认为解决 bug 的好的方式，主要做到两点
     *
     * 1. 排除特殊情况
     * //        if (k == 4 || s.length() == 0) {
     * //            if (k == 4 && s.length() == 0) {
     * //                addresses.add(tempAddress.toString());
     * //            }
     * //            return;
     * //        }
     *
     * //            if (i != 0 && s.charAt(0) == '0') {
     * //                break;
     * //            }
     * 以上这些，就都是为了排除特殊情况
     *
     * 这里有一个例子，就是这里 '0' 打头的情况，要选择排除特殊情况，下面的Cyc大神的解法就是排除特殊情况
     * 而我上面采取的措施是开一种新情况，这不好，要排除特殊情况比如 '023' 这种
     *
     * 2. 尽量进行一般化统一化的处理
     *
     * //            String part = s.substring(0, i + 1);
     * //            if (Integer.valueOf(part) <= 255) {
     * //                if (tempAddress.length() != 0) {
     * //                    part = "." + part;
     * //                }
     * //                tempAddress.append(part);
     * //                doRestore(k + 1, tempAddress, addresses, s.substring(i + 1));
     * //                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
     * //            }
     *
     * part 这段，就是对 part 的 length 分别是 1 2 3 的情况进行了统一的处理
     *
     * */

//    private void doRestore(int k, StringBuilder tempAddress, List<String> addresses, String s) {
//        if (k == 4 || s.length() == 0) {
//            if (k == 4 && s.length() == 0) {
//                addresses.add(tempAddress.toString());
//            }
//            return;
//        }
//        for (int i = 0; i < s.length() && i <= 2; i++) {
//            if (i != 0 && s.charAt(0) == '0') {
//                break;
//            }
//            String part = s.substring(0, i + 1);
//            if (Integer.valueOf(part) <= 255) {
//                if (tempAddress.length() != 0) {
//                    part = "." + part;
//                }
//                tempAddress.append(part);
//                doRestore(k + 1, tempAddress, addresses, s.substring(i + 1));
//                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
//            }
//        }
//    }
}

/**
 * leetcode 官方解法
 *
 * 这里有个思路，就是小函数，大的复杂的问题，用一些小的函数，或许能让问题变得简单。
 * */

//import java.util.ArrayDeque;
//        import java.util.ArrayList;
//        import java.util.Deque;
//        import java.util.List;
//
//public class Solution {
//
//    public List<String> restoreIpAddresses(String s) {
//        int len = s.length();
//        List<String> res = new ArrayList<>();
//        if (len > 12 || len < 4) {
//            return res;
//        }
//
//        Deque<String> path = new ArrayDeque<>(4);
//        dfs(s, len, 0, 4, path, res);
//        return res;
//    }
//
//    // 需要一个变量记录剩余多少段还没被分割
//
//    private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
//        if (begin == len) {
//            if (residue == 0) {
//                res.add(String.join(".", path));
//            }
//            return;
//        }
//
//        for (int i = begin; i < begin + 3; i++) {
//            if (i >= len) {
//                break;
//            }
//
//            if (residue * 3 < len - i) {
//                continue;
//            }
//
//            if (judgeIpSegment(s, begin, i)) {
//                String currentIpSegment = s.substring(begin, i + 1);
//                path.addLast(currentIpSegment);
//
//                dfs(s, len, i + 1, residue - 1, path, res);
//                path.removeLast();
//            }
//        }
//    }
//
//    private boolean judgeIpSegment(String s, int left, int right) {
//        int len = right - left + 1;
//        if (len > 1 && s.charAt(left) == '0') {
//            return false;
//        }
//
//        int res = 0;
//        while (left <= right) {
//            res = res * 10 + s.charAt(left) - '0';
//            left++;
//        }
//
//        return res >= 0 && res <= 255;
//    }
//}
