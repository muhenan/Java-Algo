package CyC2018.Leetcode.DataStructure.String;

import Array.Array;

public class KMP {
    private int[] getNextArr(String pattern) {
        int length = pattern.length();
        int next[] = new int[length];
        if (length == 0) return next;
        next[0] = 0;
        int i = 1, now = 0;
        while (i < length) {
            if (pattern.charAt(i) == pattern.charAt(now)) {
                now++;
                next[i] = now;
                i++;
            } else if (now != 0) {
                now = next[now - 1];
            } else {
                next[i] = now;
                i++;
            }
        }
        return next;
    }

    public int search(String haystack, String needle) {
        int next[] = getNextArr(needle);
        int lengthOfS = haystack.length();
        int lengthOfP = needle.length();
        if(lengthOfP == 0) return 0;
        int position = -1;
        int i = 0, j = 0;
        while (i < lengthOfS) {
            if (haystack.charAt(i) == needle.charAt(j)) { //匹配成功，两个字符串都往下走
                if(j == 0) position = i;
                if(j == lengthOfP - 1) return position;
                i++;
                j++;
            } else { // 标尺不指着 0，推标尺，主字符串不往下走
                if (j != 0){
                    int old_j = j;
                    j = next[j - 1];
                    position += (old_j - j);
                } else { // 标尺指着 0，只推主字符串
                    i++;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String patttern = new String("abaabac");
        KMP Solu = new KMP();
        int next[] = Solu.getNextArr(patttern);
        for (int i : next) {
            System.out.println(i);
        }
    }
}
