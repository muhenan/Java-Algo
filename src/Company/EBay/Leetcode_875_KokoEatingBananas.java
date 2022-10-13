package Company.EBay;

import java.util.Arrays;

public class Leetcode_875_KokoEatingBananas {
    /**
     * 最简单的方法就是试，从 1 开始试
     * 优化一下，不从 1 开始试了，最小从 sum / h 开始试
     *
     * 下面这个方法是最简单粗暴的方法，时间复杂度 N2
     * 显然时间是过不了的
     *
     * 走一遍肯定是无法避免
     * 研究里面那一遍怎么走
     * 里面这一遍，这个 result 是有范围的，最小的你已经算了，最大的就是最大值
     * 所以在这个里面找哪个正确，可以用 binary search
     *
     * */
    public int minEatingSpeed2(int[] piles, int h) {
        int length = piles.length;
        int result = 0;
        for (int ele : piles) result += (ele / h);
        if (result == 0) result++;
        while (true) {
            int temp = 0;
            for (int pile : piles) {
                temp += (pile / result);
                if (pile % result != 0) temp++;
                if (temp > h) {
                    temp = h + 1;
                    break;
                }
            }
            if (temp <= h) {
                break;
            }
            result++;
        }
        return result;
    }


    /**
     * 二分查找！二分查找！二分查找！！！！！！！！！
     * 只要数组有关的，找数的，二分查找就完事！！！！！！！！
     * */
    public int minEatingSpeed(int[] piles, int h) {
        int length = piles.length;
        int low = 0;
        for (int ele : piles) low += (ele / h);
        if (low == 0) low++;
        int high = Arrays.stream(piles).max().getAsInt();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (check(piles, h, mid)) high = mid;
            else {
                low = mid + 1;
            }
        }
        return high;
    }

    private boolean check(int[] piles, int h, int result) {
        int temp = 0;
        for (int pile : piles) {
            temp += (pile / result);
            if (pile % result != 0) temp++;
            if (temp > h) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Leetcode_875_KokoEatingBananas solu = new Leetcode_875_KokoEatingBananas();
        int res = solu.minEatingSpeed(new int[]{10, 9, 12, 6}, 3);
        System.out.println();
    }
}

//
//[332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184]
//        823855818
