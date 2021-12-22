package CyC2018.Leetcode.DataStructure.Hash;

import java.util.HashSet;

/**
 * 217 Contains Duplicate E
 *
 * HashSet 的经典应用
 *
 * 一个数组，找是否有重复的数
 * 直接一个 HashSet 看最后是不是少了即可
 * 复杂度 N， N
 *
 * // 关于涉及排序的方法，看力扣官方题解吧
 *
 * */

public class Leetcode_217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }
}
