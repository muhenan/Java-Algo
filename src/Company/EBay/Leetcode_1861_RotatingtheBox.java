package Company.EBay;

public class Leetcode_1861_RotatingtheBox {
    public char[][] rotateTheBox(char[][] box) {
        int row = box.length;
        int col = box[0].length;
        char[][] res = new char[col][row];
        for (int i = 0; i < row; i++) {
            /**
             * 两个指针，一个 low 一个 high 来解决问题
             * 不占用额外空间，在一个数组上，前后走，重复赋值，双指针
             * */
            int low = col - 1;
            int high = low;
            while (high >= 0) {
                res[high][row - i - 1] = '.'; /** 先默认把所有都赋值为空 */
                if (box[i][high] == '.') {
                    /**
                     * 如果 high 走到了空，那么 high 就继续往上走
                     * */
                    high--;
                    continue;
                } else if (box[i][high] == '#') {
                    /**
                     * 如果 high 走到了 stone
                     * 落下来，把 low 赋值为 stone
                     * 同时 high 和 low 都往上走
                     * */
                    res[low][row - i - 1] = '#';
                    low--;
                    high--;
                    continue;
                } else {
                    /**
                     * 如果 high 走到了 stationary obstacle
                     * 把 high 直接赋给 low
                     * 把这个 stationary obstacle 保存下来
                     * high 和 low 都往上走
                     * */
                    low = high;
                    res[low][row - i - 1] = '*';
                    high--;
                    low--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode_1861_RotatingtheBox solu = new Leetcode_1861_RotatingtheBox();
        char[][] test = new char[][]{{'#','.','#'}};
        solu.rotateTheBox(test);
    }
}
