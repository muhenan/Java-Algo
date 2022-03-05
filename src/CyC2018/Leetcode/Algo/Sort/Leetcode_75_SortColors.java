package CyC2018.Leetcode.Algo.Sort;

public class Leetcode_75_SortColors {
    /**
     * 直接桶排序太简单了
     * 研究只走一遍，通过多指针解决问题
     * 三指针自解方法，太复杂了，代码有点太多了用的
     * **/
    public void sortColors(int[] nums) {
        int first_one = -1;
        int first_two = -1;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 2) {
                if (first_two == -1) first_two = i;
            } else if (nums[i] == 1) {
                if (first_one == -1) {
                    if (first_two == -1) first_one = i;
                    else {
                        swap(nums, first_two++, i);
                        first_one = first_two - 1;
                    }
                } else {
                    if (first_two == -1) continue;
                    else swap(nums, first_two++, i);
                }
            } else {
                if (first_one == -1 && first_two == -1) continue;
                else if (first_one == -1 && first_two != -1) swap(nums, first_two++, i);
                else if (first_one != -1 && first_two == -1) swap(nums, first_one++, i);
                else {
                    swap(nums, first_one++, i);
                    swap(nums, first_two++, i);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    /**
     * Cyc 大神方法，代码看起来简单，但思维非常有深度
     * 主要思想：有一个主要的指针，从左往右走，遇到 2，换到后面去，遇到 0，换到前面去，遇到 1 ，正常走过去
     * 这里 zero 和 two 的声明都在数组外，这是 Cyc 常用的方法，用的时候也是先操作后使用
     * （这里的 zero 和 two 的作用就是一定指着 0 和 2，因为 zero 和 two 一开始我们是找不到的，所以我们是先声明在数组外）
     * **/
    public void sortColors2(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) { /**第二个 if 这里有个非常重要的点，后面的换过去了，one 没有加加，因为这里我们不知道换过去的是什么**/
                swap(nums, --two, one);
            } else {
                ++one;
            }
        }
    }
    // 三指针的方法
    // 0 和 2 都是默认已经指着 0 和 2 了
    // 假设最左边出来一个是 0，假设最右边出来一个是 nums.length，这种在边界添一个的假设方法非常常用
    // 然后 换的时候，0 和 2都是先走一步再换
    // 和 0 换的时候 1 换完也走一步
    // 和 2 换的时候 换到 不是2为止，1才往前走

    public static void main(String[] args) {
        Leetcode_75_SortColors solu = new Leetcode_75_SortColors();
        solu.sortColors(new int[]{2,0,2,1,1,0});
    }
}
