package Sort;

public class sortColors {

    // 三指针的方法
    // 0 和 2 都是默认已经指着 0 和 2 了
        // 假设最左边出来一个是 0，假设最右边出来一个是 nums.length，这种在边界添一个的假设方法非常常用
    // 然后 换的时候，0 和 2都是先走一步再换
    // 和 0 换的时候 1 换完也走一步
    // 和 2 换的时候 换到 不是2为止，1才往前走

    public void sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                swap(nums, --two, one);
            } else {
                ++one;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
