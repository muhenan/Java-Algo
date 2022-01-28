package CyC2018.Leetcode.DataStructure.String;

import java.util.ArrayList;

public class Manacher {

    public void manacher(String s) {

        int length = s.length();

        // 给原字符串中间插#
        StringBuffer t = new StringBuffer("&#");
        for (int i = 0; i < length; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('*');
        String longString = t.toString();
        int lengOfLongStr = longString.length();

        // 半径数组
        int radius[] = new int[length * 2 + 3];

        // 开始manacher式的中心拓展
        int center = 0, minRightOutsider = 0, newMinRightOutsider = 0;

        for (int i = 1; i < lengOfLongStr - 1; i++) {
            if (minRightOutsider > i) radius[i] = Math.min(radius[2 * center - i], minRightOutsider - i);
            else radius[i] = 1;
            while (longString.charAt(i + radius[i]) == longString.charAt(i - radius[i])) radius[i]++;
            newMinRightOutsider = i + radius[i]; // 从 i 中心拓展后得到新的 min right outsider
            if (newMinRightOutsider > minRightOutsider) {
                minRightOutsider = newMinRightOutsider;
                center = i;
            }
        }

        // 结束，已得到 radius 数组，接下来处理结果
        int maxLength = 0, countOfPalin = 0, PositionOfLongestPalind = 0;
        for (int i = 0; i < lengOfLongStr; i++) {
            if (radius[i] > maxLength) {
                maxLength = radius[i];
                PositionOfLongestPalind = i;
            }
            countOfPalin += (radius[i] / 2);
        }
        maxLength -= 1;

        // 展示结果
        System.out.println(longString);
        for (int element: radius) System.out.print(element);
        System.out.println();
        System.out.println(maxLength);
        System.out.println(countOfPalin);
        System.out.println(PositionOfLongestPalind);

        int maxRadius = (radius[PositionOfLongestPalind] - 1) / 2;
        int realCenter = (PositionOfLongestPalind - 1) / 2;
        int beginIndex = realCenter - maxRadius;
        System.out.println(s);
        System.out.println(realCenter);
        System.out.println(maxRadius);
        String subPalind = s.substring(beginIndex, beginIndex + maxLength);
        System.out.println(subPalind);

    }

    public static void main(String[] args) {
        Manacher solu = new Manacher();
        String testStr = new String("xbabbazzal");
//        System.out.println(testStr);
//        System.out.println(solu.longestPalindrome(testStr));
        solu.manacher(testStr);
    }
}
