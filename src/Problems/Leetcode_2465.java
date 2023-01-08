package Problems;

import java.util.Arrays;
import java.util.HashSet;

public class Leetcode_2465 {
    public int distinctAverages(int[] nums) {
        HashSet<Integer> my_set = new HashSet<>();
        int half = nums.length / 2;
        Arrays.sort(nums);
        for (int i = 0; i < half; i++) {
            if (!my_set.contains(nums[i] + nums[nums.length - 1 - i]))
                my_set.add(nums[i] + nums[nums.length - 1 - i]);
        }
        return my_set.size();
    }
}
