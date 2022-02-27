package CyC2018.Leetcode.Algo.BinarySearch;

public class Leetcode_278_FirstBadVersion {

    private boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (!isBadVersion(mid)) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
