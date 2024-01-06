package MyHashTable;

import java.util.HashMap;
import java.util.Map;

public class TwoSumHashMap {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            value = target - nums[i];
            if (map.containsKey(value) && i != map.get(value)) {
                return new int[] { i, map.get(value) };
            }
        }

        return new int[2];
    }
}
