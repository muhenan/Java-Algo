package JavaUtility;

public class JavaCharInt {
    public static void main(String[] args) {
        /**
         * Java 的 char 和 int 一起操作，会 cast 成 int
         * 如果希望这个 int 变成 char，要强制类型转换，强转的时候要有两对括号
         * */

        System.out.println('a' + 3);
        System.out.println((char)('a' + 3));
    }
}
