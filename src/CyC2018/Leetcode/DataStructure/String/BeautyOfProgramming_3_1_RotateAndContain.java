package CyC2018.Leetcode.DataStructure.String;

public class BeautyOfProgramming_3_1_RotateAndContain {

    // 编程之美，高端方法，简洁方法
    private boolean IsRotateAndContain (String s1, String s2) {
        String s1s1 = s1.concat(s1);
//        System.out.println(s1);
//        System.out.println(s1s1);
        return s1s1.contains(s2);
    }

    // 字符串的 rotate
    private String RotateString (String str) {
        int lengOfStr = str.length();
        if (lengOfStr == 0 || lengOfStr == 1) return str;
        String tempStr1 = str.substring(1);
        String tempStr2 = str.substring(0,1);
        return tempStr1.concat(tempStr2);
    }

    // 传统方法，一次一次的 rotate，然后看每次的结果是否 contain s2
    private boolean IsRotateAndContain2 (String s1, String s2) {
        int lengOfS1 = s1.length();
        for (int i = 0; i < lengOfS1; i++) {
            System.out.println(s1);
            if (s1.contains(s2)) return true;
            s1 = RotateString(s1);
        }
        return false;
    }

    // test
    public static void main(String[] args) {
        String s1 = new String("AABCD");
        String s2 = new String("CDAA");
        BeautyOfProgramming_3_1_RotateAndContain solu = new BeautyOfProgramming_3_1_RotateAndContain();
        System.out.println(solu.IsRotateAndContain(s1, s2));
        System.out.println(solu.RotateString(s1));
        System.out.println(solu.IsRotateAndContain2(s1, s2));
    }
}
