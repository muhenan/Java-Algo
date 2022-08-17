package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.Backtracking;

import java.util.*;

/**
 * 这个 currentStr.deleteCharAt(index); 就代表着回溯
 *
 * 用的 StringBuffer
 * */

public class Leetcode_17_phonenumber {
    private Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    private List<String> combinations = new ArrayList<String>();
    private int lengthOfDigits = 0;

    public List<String> letterCombinations(String digits) {
        lengthOfDigits = digits.length();
        if (lengthOfDigits == 0) {
            return combinations;
        }
        backtrack(digits, 0, new StringBuffer());
        return combinations;
    }

    private void backtrack(String digits, int index, StringBuffer currentStr) {
        if (index < lengthOfDigits) {
            String tempStr = phoneMap.get(digits.charAt(index));
            int lengthOfTempStr = tempStr.length();
            for ( int i = 0; i < lengthOfTempStr; i++) {
                currentStr.append(tempStr.charAt(i));
                backtrack(digits, index + 1, currentStr);
                currentStr.deleteCharAt(index);
            }
        } else {
            combinations.add(currentStr.toString());
        }
    }
}
