package leetcode_tasks;

import java.util.*;

public class Top_K_Frequent_Elements_347 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> container = new HashMap<>();
        int[] result = new int[k];
        for (int num : nums) {
            container.put(num, container.getOrDefault(num,0) + 1);
        }

        ArrayList<Integer>[] values = new ArrayList[nums.length+1];

        container.forEach((key,value) -> {
            if(values[value] == null)
                values[value] = new ArrayList<>();
            values[value].add(key);
        });
        int index = 0;
        for(int i=nums.length; i>=0 && index < k;i--){
            if(values[i] == null)
                continue;
            for(Integer x: values[i]){
                result[index++] = x;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

}
