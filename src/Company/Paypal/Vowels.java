package Company.Paypal;

import java.util.*;

public class Vowels {

    public static List<Integer> hasVowels(List<String> strArr, List<String> query) {
        int length = strArr.size();
        int[] pre = new int[length+1];
        for (int i = 0; i < pre.length; i++) pre[i] = 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
            String test = strArr.get(i);
            int lengthOfStr = test.length();
            System.out.println(lengthOfStr);
            if ((test.charAt(0) == 'a' || test.charAt(0) == 'e' || test.charAt(0) == 'i' || test.charAt(0) == 'o' || test.charAt(0) == 'u') && (test.charAt(lengthOfStr - 1) == 'a' || test.charAt(lengthOfStr - 1) == 'e' || test.charAt(lengthOfStr - 1) == 'i' || test.charAt(lengthOfStr - 1) == 'o' || test.charAt(lengthOfStr - 1) == 'u')) {
                count++;
            }
            pre[i + 1] = count;
        }
        int lengthOfQ = query.size();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < lengthOfQ; i++) {
//            int left = query.get(i).charAt(0) - '0';
//            int right = query.get(i).charAt(2)- '0';
            String[] leftAndright = query.get(i).split("-");
            int left = Integer.parseInt(leftAndright[0]);
            int right = Integer.parseInt(leftAndright[1]);
            res.add(pre[right] - pre[left - 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Vowels solu = new Vowels();
        List<String> strArr = new ArrayList<>();
        strArr.add("aab");
        strArr.add("a");
        strArr.add("bcd");
        strArr.add("awe");
        strArr.add("bbbbu");
        List<String> q = new ArrayList<>();
        q.add("2-3");
        q.add("4-5");
        solu.hasVowels(strArr, q);
    }


}
