package CyC2018.Leetcode.DataStructure.ArrayAndMatrix;

// 最高 最低 最高 最低，一个上下折线图，越往后空隙越小，非常非常简单的一道题目，直方图折线图的思维。

public class Leetcode_667_BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int max = n;
        int min = 2;
        result[0] = 1;
        boolean isLow = true; // 这里的布尔值可以用 index 的奇数偶数代替，比如偶数 index 放小，奇数 index 放大
        int i = 1;
        while (k > 1) {
            if (isLow) result[i++] = max--;
            else result[i++] = min++;
            isLow = !isLow;
            k--;
        }
        for ( ; i < n; i++) {
            if (isLow) result[i] = result[i - 1] + 1;
            else result[i] = result[i - 1] - 1;
        }
        return result;
    }
}
