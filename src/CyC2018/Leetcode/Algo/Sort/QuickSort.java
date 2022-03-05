package CyC2018.Leetcode.Algo.Sort;

/**
 * 快排这个函数的重点就在于 partition 函数
 * 针对这个 partition 函数有两种实现
 *      一种是之前的比较简单的实现，思想简单代码多
 *      一种是外网大神的实现，代码简单但思维量大
 *      我这里还是推荐用我们之前的思想简单的做法
 * **/

public class QuickSort {

    /**
     * 快排：
     *      调用一下 partition
     *      然后递归调用 quick sort
     * **/
    public static void quickSort(int arr[],int low,int high){
        if (low < high) {
            int indexOfPivot = partition(arr, low, high);
            quickSort(arr, low, indexOfPivot - 1);
            quickSort(arr, indexOfPivot + 1, high);
        }
    }

    /**
     * 自己的思维简单的方式
     * 注意这里是先走大的一边，如果大于或者等于都走，后走小的那边
     * 所以最后 high 和 low 相等的时候，一定是指着小的一个
     * **/
    public static int partition(int[] arr,int low,int high){
        int pivot = arr[low];
        while (low < high){
            while (arr[high] >= pivot && low < high) high--;
            while (arr[low] < pivot && low < high) low++;
            if(low < high) swap(arr, low, high);
        }
        arr[0] = arr[low];
        arr[low] = pivot;
        return high; // 最后 low 和 high 是相等的
    }

    /**
     * 竞赛代码风的 partition
     * 重点就是这里的 i，这里的 i 指着的是，目前找到的最后一个小于 pivot 的
     * **/
    public static int partition2(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1); // 最后返回 i 的下一个，因为 i 是最后一个小的
    }

    /** swap 函数 **/
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
