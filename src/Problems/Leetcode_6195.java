package Problems;

public class Leetcode_6195 {
    // Classic DP
    int length;
    int[] my_dp_arr; // dp 数组
    public int deleteString(String s) {
        length = s.length();

        // For the situation, all the characters are same
        if (length == 1) return 1;
        boolean my_flag = true;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                my_flag = false;
                break;
            }
        }
        if (my_flag) return length;


        my_dp_arr = new int[length];
        return dp(s, 0);
    }
    private int dp (String s, int index) {
        if (index == length) return 0;
        if (my_dp_arr[index] != 0) return my_dp_arr[index];
        int currentLength = length - index;
        int temp = 0;
        for (int i = 1; i <= currentLength / 2; i++) {
            boolean flag = true;
            for (int iterator = 0; iterator < i; iterator++) {
                if (s.charAt(index + iterator) == s.charAt(index + i + iterator)) flag = true;
                else {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                temp = Math.max(temp, dp(s, index + i));
            }
        }
        my_dp_arr[index] = temp + 1;
        return my_dp_arr[index];
    }
}

/**
 * 这个方法的时间效率还不如我们
 * 但是把最长公共前缀用在这了
 * 也是一种办法
 * 一个字符串自己的最长公共子串
 *
 * 可以学一下 n2 构建 LCP 的写法
 *
class Solution {
    public int deleteString(String S) {
        var s = S.toCharArray();
        var n = s.length;
        var lcp = new int[n + 1][n + 1]; // lcp[i][j] 表示 s[i:] 和 s[j:] 的最长公共前缀
        for (var i = n - 1; i >= 0; --i)
            for (var j = n - 1; j >= 0; --j)
                if (s[i] == s[j])
                    lcp[i][j] = lcp[i + 1][j + 1] + 1;
        var f = new int[n];
        for (var i = n - 1; i >= 0; --i) {
            for (var j = 1; i + j * 2 <= n; ++j)
                if (lcp[i][i + j] >= j) // 说明 s[i:i+j] == s[i+j:i+j*2]
                    f[i] = Math.max(f[i], f[i + j]);
            ++f[i];
        }
        return f[0];
    }
}**/

/**
class Solution {
    int N = 4010;
    long[] h = new long[N], p = new long[N];
    int P = 13331;
    public int deleteString(String s) {
        int n = s.length();

        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i-1] * P;
            h[i] = h[i-1] * P + s.charAt(i - 1);
        }
        int[] f = new int[n];

        char[] a = s.toCharArray();
        f[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            f[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (j - i > n - j) break;
                if (get(i + 1, j) == get(j + 1, j + j - i))
                    f[i] = Math.max(f[i], f[j] + 1);
            }
        }
        System.out.println(Arrays.toString(f));
        return f[0];
    }

    long get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }
}
**/

/**
class Solution {
    private HashMap<Integer, Integer> cache = new HashMap<>();

    public int deleteString(String s) {
        return dfs(s.toCharArray(), 0);
    }

    private int dfs(char[] chars, int i) {
        if (chars.length == i) {
            return 0;
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        int ans = 0, j = 1, len = (chars.length - i) / 2;
        while (j <= len) {
            if (Arrays.equals(chars, i, i + j, chars, i + j, i + j + j)) {
                ans = Math.max(dfs(chars, i + j) + 1, ans);
            }
            j++;
        }
        ans = Math.max(ans, 1);
        cache.put(i, ans);
        return ans;
    }
}**/