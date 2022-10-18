package Company;

import java.util.List;

public class TestOA {
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int max = arr.get(0);
        int min = arr.get(0);
        long sum = 0;
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            sum += num;
        }
        System.out.print(sum - max);
        System.out.print(' ');
        System.out.print(sum - min);
    }
}
