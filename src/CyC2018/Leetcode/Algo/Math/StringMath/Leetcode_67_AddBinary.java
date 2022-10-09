package CyC2018.Leetcode.Algo.Math.StringMath;

public class Leetcode_67_AddBinary {
    public String addBinary(String a, String b) {
        char[] FirstArr = a.toCharArray();
        char[] SecondArr = b.toCharArray();
        if (FirstArr[0] == '0') return b;
        if (SecondArr[0] == '0') return a;
        int firstLength = a.length();
        int secondLength = b.length();
        StringBuffer res = new StringBuffer();
        boolean carry = false;
        int index = 0;

        int i = 0, j = firstLength - 1;
        while (i < j) {
            swap(FirstArr, i, j);
            i++;
            j--;
        }

        i = 0;
        j = secondLength - 1;
        while (i < j) {
            swap(SecondArr, i, j);
            i++;
            j--;
        }

        for (; index < firstLength && index < secondLength; index++) {
            if (carry) {
                if (FirstArr[index] == SecondArr[index]) {
                    res.append('1');
                    carry = FirstArr[index] == '0' ? false : true;
                } else {
                    res.append('0');
                    carry = true;
                }
            } else {
                if (FirstArr[index] == SecondArr[index]) {
                    res.append('0');
                    carry = FirstArr[index] == '0' ? false : true;
                } else {
                    res.append('1');
                    carry = false;
                }
            }
        }


        for (; index < firstLength; index++) {
            if (carry && FirstArr[index] == '1') {
                res.append('0');
                carry = true;
            } else if (!carry && FirstArr[index] == '0') {
                res.append('0');
                carry = false;
            } else {
                res.append('1');
                carry = false;
            }
        }


        for (; index < secondLength; index++) {
            if (carry && SecondArr[index] == '1') {
                res.append('0');
                carry = true;
            } else if (!carry && SecondArr[index] == '0') {
                res.append('0');
                carry = false;
            } else {
                res.append('1');
                carry = false;
            }
        }

        if (carry) res.append('1');


        return res.reverse().toString();
    }

    private void swap (char[] arr, int a, int b) {
        char old = arr[a];
        arr[a] = arr[b];
        arr[b] = old;
    }

    /**
     * 减少特殊情况的判断
     * */


    /**
     * 在提交记录里发现自己三年前 做对过这个题
     * 当时还是用的 C++
     * 当时居然想到了要在短的字符串前面补 0
     * 以保持长度一样，然后相加，对特殊情况的判断也特别简洁
     * 自己以前可真聪明，现在都想不到了
     * 哎 感慨万千。。。
     * */
//    class Solution {
//        public:
//        string addBinary(string a, string b) {
//            int al = a.size();
//            int bl = b.size();
//            while(al < bl) //让两个字符串等长，若不等长，在短的字符串前补零，否则之后的操作会超出索引
//            {
//                a = '0' + a;
//                ++ al;
//            }
//            while(al > bl)
//            {
//                b = '0' + b;
//                ++ bl;
//            }
//            bool carry = false;
//            for(int j = a.size() - 1; j >= 0; -- j) //从后到前遍历所有的位数，同位相加
//            {
//                //cout << a[j] << ' ' << b[j] << ' ';
//                if((a[j] == '1' && b[j] == '1') ||
//                        (a[j] == '1' && carry) ||
//                        (b[j] == '1' && carry))
//                {
//                    //cout << "carry" << endl;
//                    if(a[j] == '1' && b[j] == '1' && carry) a[j] = '1';
//                    else a[j] = '0';
//                    //cout << a[j] << endl;
//                    carry = true;
//                }
//                else{
//                    //cout << "no carry" << endl;
//                    if(a[j] == '1' || b[j] == '1' || carry) a[j] = '1';
//                    else a[j] = '0';
//                    //cout << a[j] << endl;
//                    carry = false;
//                }
//            }
//            if(carry) a = '1' + a;
//            return a;
//        }
//    };


    /**
     * Cyc 更 general 的解法
     * 直接让 carry 是一个 int 然后直接往上加
     * 然后在除或者 mod
     * */
    public String addBinary2(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder str = new StringBuilder();
        while (carry == 1 || i >= 0 || j >= 0) {
            if (i >= 0 && a.charAt(i--) == '1') {
                carry++;
            }
            if (j >= 0 && b.charAt(j--) == '1') {
                carry++;
            }
            str.append(carry % 2);
            carry /= 2;
        }
        return str.reverse().toString();
    }
}
