package JavaUtility;

import Company.EBay.Leetcode_179_LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 关于 Java 的 Comparator 的 Compare 的精髓
 *
 * 带入了 o1，o2
 *
 * 返回负数，o1 在前
 * 返回正数，o2 在前
 *
 *      o1 o2
 *      -1 1
 *
 * */
public class JavaComparator {
    /**
     *
     * 题目来自 Leetcode 179
     *
     * */
    public String largestNumber(int[] nums) {
        int length = nums.length;
        String[] strs = new String[length];
        for (int i = 0; i < length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            /**
             * 关于 Java 的 Comparator 的 Compare
             * 带入了 o1，o2
             * 返回 负数，就是 o1 放前面
             * 0 相等
             * 正数，就是 o2 放前面
             *
             * 你也可以认为，本来就是从小到大排序的，返回 -1 就是左边的小，返回 1 就是右边的小
             * */
            @Override
            public int compare(String o1, String o2) {
                int firstLength = o1.length();
                int secondLength = o2.length();
                int i = 0, j = 0;
                while (true) {
                    if (o1.charAt(i) < o2.charAt(j)) return 1;
                    else if (o1.charAt(i) > o2.charAt(j)) return -1;
                    else {
                        i++;
                        j++;
                    }
                    if (i == firstLength && j == secondLength) break;
                    if (i == firstLength) i = 0;
                    if (j == secondLength) j = 0;
                }
                return 0;
            }
        });
        StringBuffer res = new StringBuffer();
        for (String str:strs) res.append(str);
        if (res.charAt(0) == '0') return "0";
        return res.toString();
    }


    public static void main(String[] args) {
        Leetcode_179_LargestNumber solu = new Leetcode_179_LargestNumber();
        solu.largestNumber(new int[]{3,34,30,9,5});
    }
}
