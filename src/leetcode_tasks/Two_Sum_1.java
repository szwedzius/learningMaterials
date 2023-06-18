package leetcode_tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum_1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> container = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(container.containsKey(target - nums[i]))
                return new int[]{i, container.get(target - nums[i])};
            container.put(nums[i], i);
        }
        return new int[2];
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
