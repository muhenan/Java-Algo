package CyC2018.Leetcode.DataStructure.String;

// 经典中的经典，字符串匹配
// 1. 暴力两个 for
// 2. 自己的写的，看起来像一遍遍历，其实还是 1 的思路，只是写法简单了一点，效果还是 O(n2)
// 3. KMP

public class Leetcode_28_strStr {

    // 1. 暴力两个 for
    public int strStr(String haystack, String needle) {
        int lengthOfS = haystack.length();
        int lengthOfP = needle.length();
        if(lengthOfP == 0) return 0;
        for (int i = 0; i < lengthOfS; i++) {
            if (lengthOfS - i < lengthOfP) break;
            for (int j = 0; j < lengthOfP; j++) {
                if (haystack.charAt(i + j) == needle.charAt(j)) {
                    if (j == lengthOfP - 1) return i;
                } else break;
            }
        }
        return -1;
    }

    // 2. 自己的写法 O(n2)
    public int strStr2(String haystack, String needle) {
        int lengthOfS = haystack.length();
        int lengthOfP = needle.length();
        if(lengthOfP == 0) return 0;
        int j = 0;
        int ans = -1;
        for (int i = 0; i < lengthOfS; i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == 0) ans = i;
                if (j == lengthOfP - 1) return ans;
                j++;
            } else {
                if(j != 0){
                    j = 0;
                    i = ans;
                }
            }
        }
        return -1;
    }

    // 3. KMP
    public int strStr3(String haystack, String needle) {
        int lengthOfS = haystack.length();
        int lengthOfP = needle.length();
        if(lengthOfP == 0) return 0;
        return -1;
    }

}
