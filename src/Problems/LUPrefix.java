package Problems;

// 6197. 最长上传前缀  Longest Uploaded Prefix
public class LUPrefix {

    boolean[] arr;
    int index;
    int my_n;
    public LUPrefix(int n) {
        my_n = n;
        arr = new boolean[n + 1];
        index = 0;
    }

    public void upload(int video) {
        arr[video] = true;
    }

    public int longest() {
        while (index != arr.length - 1 && arr[index + 1]) index++;
        return index;
    }
}
