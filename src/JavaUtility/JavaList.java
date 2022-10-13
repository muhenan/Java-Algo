package JavaUtility;

import java.util.*;

public class JavaList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 7));

        printList(list);

        list.set(2, list.get(2) + 2);

        printList(list);

        list.remove(1);

        printList(list);



    }

    public static void printList (List<Integer> list) {
        for (Integer ele:list) {
            System.out.print(ele);
            System.out.print(" ");
        }
        System.out.println();
    }
}
