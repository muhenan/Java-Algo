package Problems;

public class L337 {
    public int findSmallestInteger(int[] nums, int value) {
        boolean[] my_set = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            my_set[i] = false;
        }
        for (int n = 0; n < nums.length; n++) {
            boolean ok = false;
            for (int i = 0; i < nums.length; i++) {
                if (!my_set[i] && (n - nums[i]) % value == 0) {
                    my_set[i] = true;
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                return n;
            }
        }
        return nums.length;
    }
}
