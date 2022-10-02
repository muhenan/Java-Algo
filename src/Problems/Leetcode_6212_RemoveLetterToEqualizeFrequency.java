package Problems;

import java.util.LinkedList;
import java.util.List;

public class Leetcode_6212_RemoveLetterToEqualizeFrequency {
    public boolean equalFrequency(String word) {
        int length = word.length();
        int[] arr = new int[26];
        for (int i = 0; i < length; i++) {
            arr[word.charAt(i) - 'a']++;
        }
        int[] count = new int[length + 1];
        for (int ele : arr) {
            if (ele != 0){
                count[ele]++;
            }
        }

        count[0] = 0;


        List<Integer> myList = new LinkedList<>();
        for (int i = 1; i < length + 1; i++) {
            if (count[i] != 0) myList.add(i);
        }
        int size = myList.size();
        if (size > 2) return false;
        if (size == 1) {
            int a = myList.get(0);
            if (a == 1) return true;
            else if (count[a] == 1) return true;
            else return false;
        }



        int isHigh = 0;
        int low = 0;
        for (int i = 1; i < length + 1; i++) {
            if (count[i] != 0) {
                if (isHigh == 0) {
                    isHigh = 1;
                    low = i;
                } else if (isHigh == 1) {
                    if (i == low + 1 && count[i] == 1) return true;
                    if (low == 1 && count[low] == 1) return true;
                }
            }
        }
        return false;

    }

//    public static void main(String[] args) {
//        Leetcode_6212_RemoveLetterToEqualizeFrequency solu = new Leetcode_6212_RemoveLetterToEqualizeFrequency();
//        solu.equalFrequency(new String("ddaccb"));
//    }
}
