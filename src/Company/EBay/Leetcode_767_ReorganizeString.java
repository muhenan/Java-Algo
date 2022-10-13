package Company.EBay;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode_767_ReorganizeString {
    /**
     * 我的想法
     * （注意到都是小写字母）类似奇数排序，把字母排一下
     * 然后一个一个放上去，最后看一遍是不是有两个一样的
     *
     * 每次操作堆的时候，时间复杂度是 logn，所以总的时间复杂度是 nlogn
     *
     * 思考优化成 N 的方法
     * */
    public String reorganizeString(String s) {
        /** find frequency */
        char[] charArrS = s.toCharArray();
        int[] map = new int[26];
        for (char c:charArrS) map[c - 'a']++;


        /** build pq 大根堆*/
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0)
                pq.offer(new int[]{i, map[i]});
        }


        /** 从堆顶，把与元素放进去 */
        StringBuffer res = new StringBuffer();
        while (pq.size() > 1) {
            int[] first = pq.poll();
            int[] second = pq.poll();
            res.append((char)('a' + first[0]));
            res.append((char)('a' + second[0]));
            if (first[1] != 1) {
                first[1]--;
                pq.offer(first);
            }
            if (second[1] != 1) {
                second[1]--;
                pq.offer(second);
            }
        }

        /**
         * 如果恰好剩一个字符，放在后面即可
         * 剩多个，废了
         * */
        if (pq.size() == 1) {
            int[] lastOne = pq.poll();
            if (lastOne[1] != 1) return "";
            else {
                res.append((char)('a' + lastOne[0]));
            }
        }

        return res.toString();
    }

    /**
     * 想了一个优化到 N 的方法
     * 把 pq 换了，用一个二维数组
     * 比如 aaaabbbccc
     * 记成
     * 4 : a
     * 3 : b, c
     *
     * */


    /**
     * Leetcode 方法
     * 按照数量最多的字母，一个隔一个放
     * 走完一遍之后，第二遍的时候，从 index 1 开始
     * */
    public String reorganizeString2(String S) {
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        }
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return "";
        }
        char[] res = new char[S.length()]; /** 用 char arr 更加提高时间效率 */
        int idx = 0;
        while (hash[letter] > 0) {
            /**
             * 这里感觉好像也没必要这么做，直接正常放就可以了
             * */
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }


    public static void main(String[] args) {
        Leetcode_767_ReorganizeString solu = new Leetcode_767_ReorganizeString();
        solu.reorganizeString("aaaabbbccc");
    }
}
