package OfferArray;
import java.util.*;

public class OfferArray {

    //  数组中重复的数字 最简单的哈希的方法
    public int findRepeatNumber1(int[] nums) {
        int size = nums.length;
        int arr[] = new int[size];
        for(int i = 0; i < size; i++){
            if(arr[nums[i]] == 1) return nums[i];
            else arr[nums[i]] = 1;
        }
        return -1;
    }

    //  数组中重复的数字 尽量不占用外部空间，在一个数组里面换的做法
    public int findRepeatNumber(int[] nums) {
        int size = nums.length;
        for(int i = 0; i < size; i++){
            if(i == nums[i]) continue;
            int temp = nums[nums[i]];
            if(temp == nums[i]) return nums[i];
            nums[nums[i]] = nums[i];
            nums[i] = temp;
            i--;
        }
        return -1;
    }


    //二维数组中的查找
    //从最右上角开始搜
        //因为右上角表示了行的最大，列的最小，这样我们知道下一次往哪里移动
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int maxRow = matrix.length;
        if(maxRow == 0) return false;
        int maxCol = matrix[0].length;
        int row = 0, col = maxCol - 1;
        while (row < maxRow && col >= 0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }



    //选择数组中的最小数字
    public int minArray(int[] numbers) {
        int size = numbers.length;
        if(numbers[size-1] > numbers[0]) return numbers[0];
        int left = 0, right = size - 1;
        while (right > left){
            if(numbers[left] == numbers[right]){
                left++;
                continue;
            }
            int mid = left + (right - left)/2;
            if(numbers[mid] <= numbers[right]){
                right = mid;
            }
            else if(numbers[mid] >= numbers[left]){
                left = mid + 1;
            }
        }
        return numbers[right];
    }


    // 二分查找，查找一个数出现的第一个位置和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }

        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }

        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    // 找最左边的，思路很简单，就是找到相等的就把 right 往左移动，一直把区间往左边挤
    // 这里的做法我们是假设能找到
    // 最后找完的时候我们测试一下，找到是是不是正确的值
    // 最右边也是同样的道理，如果最左边的能找到，那么最右边的一定也能找到
    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 小于一定不是解
            if (nums[mid] < target) {
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                // 下一轮搜索区间是 [left, mid]
                right = mid;
            } else {
                // nums[mid] > target，下一轮搜索区间是 [left, mid - 1]
                right = mid - 1;
            }
        }

        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                // 下一轮搜索区间是 [left, mid - 1]
                right = mid - 1;
            } else if (nums[mid] == target){
                // 下一轮搜索区间是 [mid, right]
                left = mid;
            } else {
                // nums[mid] < target，下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }


    // 螺旋矩阵
    // 最后有个错误自己没看出来，然后用的只打印前面的方法，不过题还是做对了。
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int MaxRow = matrix.length;
        if(MaxRow == 0) return res;
        int MaxCol = matrix[0].length;
        int MinRow = 0, MinCol = 0;
        int iRow = MinRow, iCol = MinCol;
        while (true){

            while(iCol < MaxCol) res.add(matrix[iRow][iCol++]);
            iCol--;
            MaxCol--;
            if(++iRow >= MaxRow) break;

            while (iRow < MaxRow) res.add(matrix[iRow++][iCol]);
            iRow--;
            MaxRow--;
            if(--iCol < MinCol) break;

            while (iCol >= MinCol) res.add(matrix[iRow][iCol--]);
            iCol++;
            MinCol++;
            if(--iRow < MinRow) break;

            while (iRow > MinRow) res.add(matrix[iRow--][iCol]);
            iRow++;
            MinRow++;
            if(++iCol >= MaxCol) break;
        }
        return res.subList(0,matrix.length * matrix[0].length);
    }

    //和为 k 的子数组
    //前缀和 + 哈希表优化
    //不同的前缀和也可能出现一样的值，因为可能有负数，哈希表的 key 是 前缀和，value 是这个数值的前缀和出现的次数

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
