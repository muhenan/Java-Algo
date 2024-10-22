package Problems;

import java.util.Arrays;

public class Test {
    int method(int[] nums, int p, int q) {
        int ans = 0;
        while (true) {
            int indexOfMax = -1;
            int max = 0;
            for (int i = 0; i < nums.length; i++) if (nums[i] > 0 && nums[i] > max) {
                indexOfMax = i;
                max = nums[i];
            }
            if (indexOfMax == -1) break;
            ans++;
            for (int i = 0; i < nums.length; i++) nums[i] -= (i == indexOfMax ? p : q);
        }
        return ans;
    }


    public int solution(int[] A) {
        // Implement your solution here
        int N = A.length;
        if (N == 1) return 1;
        if (N == 2) return 1;
        Arrays.sort(A);
        int result = A[N - 1] - A[0];
        for (int i = 0; i < N - 1; i++) {
            int board1 = N + 1;
            int board2 = N + 1;
            if (i == 0) {
                board1 = 1;
                board2 = A[N - 1] - A[i + 1];
            } else if (i == N - 2) {
                board1 = A[i] - A[0];
                board2 = 1;
            } else {
                board1 = A[i] - A[0];
                board2 = A[N - 1] - A[i + 1];
                System.out.println(board1 + " " + board2);
            }
            int longerBoard = Math.max(board1, board2);
            System.out.println("longer board " + longerBoard);
            result = Math.min(result, longerBoard);
            System.out.println(result);
        }
        System.out.println(result);
        return result;
    }







    public static void main(String[] args) {

        Test solu = new Test();
        int result = solu.solution(new int[]{0, 44, 32, 30, 42, 18, 34, 16, 35});
    }
}
