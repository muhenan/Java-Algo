package Sort;

// 代码是非常的简练，但是划分那段好像并不是非常的清楚，隐藏了很多的细节，感觉不好灵活运用，也不是那么好懂。

/*
*
* 重点就在于这个划分，把划分弄明白，这个题目也就OK了
* 划分的话还是背下来吧
*
* 一、有一个大的 while(low < high)
* 二、先 high 在 (arr[high] >= basic && low < high) 情况下走（顺序不能错，先走high）
* 三、同样的情况走 low
* 四、满足(low < high)即交换
* 五、整个 while结束后，low位置的值和basic换，这样low就是最后返回的划分位置了
*
* */

public class QuickSort {

    // 普通的快排
    public static void quickSort(int arr[],int _left,int _right){
        int left = _left;
        int right = _right;
        int temp = 0;
        if(left <= right){   //待排序的元素至少有两个的情况
            temp = arr[left];  //待排序的第一个元素作为基准元素
            while(left != right){   //从左右两边交替扫描，直到left = right
                while(right > left && arr[right] >= temp)
                    right --;        //从右往左扫描，找到第一个比基准元素小的元素
                arr[left] = arr[right];  //找到这种元素arr[right]后与arr[left]交换
                while(left < right && arr[left] <= temp)
                    left ++;         //从左往右扫描，找到第一个比基准元素大的元素
                arr[right] = arr[left];  //找到这种元素arr[left]后，与arr[right]交换
            }
            arr[right] = temp;    //基准元素归位
            quickSort(arr,_left,left-1);  //对基准元素左边的元素进行递归排序
            quickSort(arr, right+1,_right);  //对基准元素右边的进行递归排序
        }
    }

    public static void quickSort2(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort2(arr, low, j-1);
        //递归调用右半数组
        quickSort2(arr, j+1, high);
    }

    // 划分函数
    public static int position(int[] arr,int low,int high){
        int basic = arr[low];
        while (low < high){
            while (arr[high] >= basic && low < high) high--;
            while (arr[low] <= basic && low < high) low++;
            if(low < high){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
        arr[0] = arr[low];
        arr[low] = basic;
        return high;
    }

    public static void main(String[] args) {

        int array[] = {6,5,3,1,7,2,8};

        System.out.println("排序之前：");
        for(int element : array){
            System.out.print(element+" ");
        }

        //quickSort(array,0,array.length-1);
        int res = position(array,0, array.length-1);
        System.out.println("Outpue is " + res);

        System.out.println("\n排序之后：");
        for(int element : array){
            System.out.print(element+" ");
        }

    }




}
