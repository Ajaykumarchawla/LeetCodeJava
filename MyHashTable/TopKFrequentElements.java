package MyHashTable;

import java.util.HashMap;
import java.util.Map;
// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// k is in the range [1, the number of unique elements in the array].
// It is guaranteed that the answer is unique.

// Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            // System.out.println()
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        int[] values = new int[k], frequencies = new int[k];
        for (int value : map.keySet()) {
            int frequecy = map.get(value);
            for (int i = 0; i < k; i++) {
                if (frequecy > frequencies[i]) {
                    int temp = value;
                    value = values[i];
                    values[i] = temp;

                    temp = frequecy;
                    frequecy = frequencies[i];
                    frequencies[i] = temp;
                }
            }
        }
        System.out.println(map2);
        return values;
    }
}
