package quiz;

import java.util.List;

public class Quiz2 {
    public static char nextGreatestLetter(List<Character> letters, char target) {
        int length = letters.size();
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = (right - left)/2 + left;
            char midC = letters.get(mid);
            if (midC <= target) left = mid + 1;
            else if (midC > target) right = mid;
        }
        char leftOne = letters.get(left);
        if (leftOne > target) return leftOne;
        else return letters.get(0);
    }
}
