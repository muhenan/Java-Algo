package CyC2018.Leetcode.DataStructure.String.Rotation;

public class Leetcode_796_RotateString {
    /**
     * 常规的方法，从不同的位置遍历，遍历时用了 % n
     * 时间复杂度 N2
     * */
    public boolean rotateString(String s, String goal) {
        int m = s.length(), n = goal.length();
        if (m != n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (s.charAt((i + j) % n) != goal.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }


    /**
     * 连在一起，直接应该包含 goal
     * 时间复杂度 N
     * 时间复杂度：O(n)O(n)，其中 nn 是字符串 ss 的长度。\text{KMP}KMP 算法搜索子字符串的时间复杂度为 O(n)O(n)，其他搜索子字符串的方法会略有差异。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/rotate-string/solution/xuan-zhuan-zi-fu-chuan-by-leetcode-solut-4hlp/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * */
    public boolean rotateString2(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
