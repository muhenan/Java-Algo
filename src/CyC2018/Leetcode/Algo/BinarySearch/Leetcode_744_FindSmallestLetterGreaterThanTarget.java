package CyC2018.Leetcode.Algo.BinarySearch;

/**
 * char 可以像 int 一样，直接比较
 *
 * 本次变种的二分查找：
 *      找到一个比 target 大的最小的元素
 *      如果找不到的话，我的算法是指向最后一个
 *
 * **/

public class Leetcode_744_FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        int low = 0;
        int high = length - 1;
        /**
         * 如果给下面的 while 中带上等于，那么就得写成 high = mid - 1
         * 最后 high 是答案，如果找不到这种元素，high 指着外面第一个即 high 等于 length
         * **/
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return letters[low] > target ? letters[low] : letters[0];
    }

}
