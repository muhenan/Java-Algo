package ByteDanceArray;

import java.util.*;

public class BDArray {

    // 盛水最多的容易，双指针，只要是一边短就往中间移动。
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }




    //下一个序列
    //自己有使用最小堆的这个意识了，但是弄的不对
    //不错有用堆保持数的顺序的意识了！！！！

    //完全自解方法，用两个栈完成任务，一遍遍历完成任务，时间效率无敌！！！！！
    //传统的也有找到那个转折的，然后再找到比它大一点的，然后交换，然后后面的一段数组进行反转
    public void nextPermutation(int[] nums) {
        int size = nums.length;
        Stack<Integer> bigStack = new Stack<Integer>();
        Stack<Integer> smallStack = new Stack<Integer>();
        bigStack.push(nums[size - 1]);
        for(int i = size - 2; i >= 0; i--){
            if(!bigStack.empty() && nums[i] >= bigStack.peek()) bigStack.push(nums[i]);
            else{
                while(!bigStack.empty() && bigStack.peek() > nums[i]){
                    smallStack.push(bigStack.peek());
                    bigStack.pop();
                }

                int temp = nums[i];
                if(!smallStack.empty()){
                    nums[i] = smallStack.peek();
                    smallStack.pop();
                }
                smallStack.push(temp);

                while(!bigStack.empty()){
                    smallStack.push(bigStack.peek());
                    bigStack.pop();
                }

                while (!smallStack.empty()){
                    nums[++i] = smallStack.peek();
                    smallStack.pop();
                }

                return;
            }
        }
        int i = size - 1;
        while(!bigStack.empty()){
            nums[i--] = bigStack.peek();
            bigStack.pop();
        }
        return;
    }





    // 寻找两个数组的中位数，hard 题
    // 在两个数组上进行 二分查找，实在太强
    // 找中位数就是淘汰，淘汰一半就行了
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    // 模块化处理，这里多了一个小模块是寻找两个数组排序后，第 k 大的值（这里的k是索引）
    // 其实重点就在于这个模块
    // 记住，hard 题只是多了更多的模块而已，做好每个小模块，一样做对题
    // k 是第几大！！！
    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            //最重要的其实就是上面三个边界情况

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }



    //42. 接雨水
    public int trap(int[] height) {
        int size = height.length;
        if(size < 3) return 0;

        int[] leftMax = new int[size];
        int leftMaxValue = 0;
        for(int i = 0; i < size; i++){
            leftMaxValue = Math.max(leftMaxValue, height[i]);
            leftMax[i] = leftMaxValue;
        }

        int[] rightMax = new int[size];
        int rightMaxValue = 0;
        for(int i = size - 1; i >= 0; i--){
            rightMaxValue = Math.max(rightMaxValue, height[i]);
            rightMax[i] = rightMaxValue;
        }

        int result = 0;
        for(int i = 0; i < size; i++){
            int temp = Math.min(leftMax[i], rightMax[i]);
            result += (temp - height[i]);
        }
        return result;
    }


    //45. 跳跃游戏 II
    public int jump(int[] nums) {
        int result = 0;
        int size = nums.length;
        int lastOneOfThisStep = 0;
        int maxIndex = 0;
        for(int i = 0; i < size - 1; i++){
            maxIndex = Math.max(maxIndex, nums[i] + i);
            if(lastOneOfThisStep == i){
                lastOneOfThisStep = maxIndex;
                result++;
            }
        }
        return result;
    }


    //84. 柱状图中最大的矩形
    //单调栈
    //有了单调栈是思想，就可以传统方法，两遍分别从两边的遍历找到左右边界，然后结算每个值对应的最大结果
    //最有方法：单调栈+常数优化，一遍遍历解决问题
    //这里单调栈里存的是索引不是值，重点！

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }


    //85. 最大矩形
    //84 的变化，每行都按 84 处理，就是85
//    public int maximalRectangle(char[][] matrix) {
//
//    }

    

    public static void main(String[] args) {
        int array[] = new int[]{2,5,4,2,1};
        BDArray test = new BDArray();
        test.nextPermutation(array);
        for(int i : array) System.out.println(i);
    }

}
