package quiz;

import java.util.LinkedList;
import java.util.List;

public class Quiz1 {
    public static void main(String[] args) {
        System.out.println(22);
        List<Integer> ans  = new LinkedList<>();
        ans.add(1);
        ans.add(2);
//        Integer[] arr = ans.toArray();
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
