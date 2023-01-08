package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] counts = new int[10000];
        for (int i = 0; i < deck.length; i++) {
            counts[deck[i]]++;
        }
        List<Integer> my_list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            if (counts[i] != 0){
                my_list.add(counts[i]);
            }
        }

        int[] arr = new int[my_list.size()];
        for (int i = 0; i < my_list.size(); i++) arr[i] = my_list.get(i);
        Arrays.sort(arr);
        if (arr[0] < 2) return false;
        if (my_list.size() == 1) return true;

        int[] arr2 = new int[arr[0] - 1];
        for (int i = 0; i < arr[0] - 1; i++) arr2[i] = i + 2;


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr2[j] != -1) {
                    int reminder = arr[i] % arr2[j];
                    if (reminder != 0) arr2[j] = -1;
                }
            }
        }
        for (int j = 0; j < arr2.length; j++) if (arr2[j] != -1) return true;
        return false;
    }


    public static void main(String[] args) {
        Leetcode_914 solu = new Leetcode_914();
        int[] arr = new int[]{1,1,1,2,2,2,3,3};
        solu.hasGroupsSizeX(arr);
    }
}
