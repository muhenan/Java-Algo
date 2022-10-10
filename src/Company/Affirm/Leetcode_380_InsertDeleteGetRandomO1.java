package Company.Affirm;

import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_380_InsertDeleteGetRandomO1 {
}

/**
 * ArrayList + HashMap 的思想
 * */
class RandomizedSet {

    HashMap<Integer, Integer> dict;
    List<Integer> list;
    Random rand;

    public RandomizedSet() {
        dict = new HashMap<>();
        list = new LinkedList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (dict.containsKey(val)) return false;
        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (! dict.containsKey(val)) return false;

        /**
         * 把最后的挪到要删的那个那个位置
         * 然后删去最后的
         * */
        // move the last element to the place idx of the element to delete
        int lastElement = list.get(list.size() - 1);
        int idx = dict.get(val);
        list.set(idx, lastElement);
        dict.put(lastElement, idx);
        // delete the last element
        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}