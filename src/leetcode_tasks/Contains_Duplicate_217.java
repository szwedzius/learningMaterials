package leetcode_tasks;

import java.util.HashMap;
import java.util.Map;

public class Contains_Duplicate_217 {

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> container = new HashMap<>();
        for (int num : nums) {
            if (container.containsKey(num))
                return true;
            else
                container.put(num, 1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}