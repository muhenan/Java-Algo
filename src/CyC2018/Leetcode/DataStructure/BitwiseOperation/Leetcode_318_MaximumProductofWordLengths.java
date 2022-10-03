package CyC2018.Leetcode.DataStructure.BitwiseOperation;

public class Leetcode_318_MaximumProductofWordLengths {
    /**
     * 题目的核心是判断两个字符串是否含相同字符
     * 字符串中只有小写字母
     * 我们可以用一个 32 位的整数来描述一个字符串的情况，统计 26 个字母那个出现过，用 value 表示这个数
     * 如果 value1 & value2 == 0 就说明没有公共元素，否则就是有公共元素
     * */
    public int maxProduct(String[] words) {
        int length = words.length;
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            for (char c : words[i].toCharArray()) {
                values[i] |= 1 << (c - 'a');
            }
        }
        /**
         * 后面的操作全是无脑 n2 复杂度了
         * */
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((values[i] & values[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
}
