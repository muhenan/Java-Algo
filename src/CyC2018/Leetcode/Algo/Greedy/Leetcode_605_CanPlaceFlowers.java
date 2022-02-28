package CyC2018.Leetcode.Algo.Greedy;

/**
 * 我们的思路都是这里是不是三个零的排布，这样的话我就可以放个1在中间
 * **/

public class Leetcode_605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int length = flowerbed.length;
        if (length == 1) {
            if (flowerbed[0] == 0 && n == 1) return true;
            else return false;
        }
        int CanPlace = 0;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 1) continue;
            if (i == 0) {
                if (flowerbed[i+1] == 0){
                    i++;
                    CanPlace++;
                }
            }
            else if (i == length - 1) {
                if (flowerbed[i-1] == 0) {
                    CanPlace++;
                }
            }
            else {
                if (flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                    i++;
                    CanPlace++;
                }
            }
        }
        return CanPlace >= n;
    }

    /**
     * Cyc 方法
     * 巧妙处理了开头和结尾的情况，遍历时没有激进的跳 i（这种处理方式就处理了各种特殊情况，非常值得学习，很具有普适性！！！）
     * 用时更长了一点，但是代码更工整，更有可读性
     * **/
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < len && cnt < n; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }
}
