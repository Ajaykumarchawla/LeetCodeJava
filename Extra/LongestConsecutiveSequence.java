package Extra;

import java.util.HashMap;
import java.util.Map;
// 128. Longest Consecutive Sequence
// Solved
// Medium
// Topics
// Companies
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

// Example 1:

// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
// Example 2:

// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, 1);
        }

        int max = 0;

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                int i = 1;
                while (map.containsKey(key - i)) {

                    map.put(key - i, 0);
                    i++;
                }
                int j = 1;
                while (map.containsKey(key + j)) {
                    map.put(key + j, 0);
                    j++;
                }

                if ((j + i - 1) > max) {
                    max = (j + i - 1);
                }
            }

        }
        return max;
    }
}

// test cases
// [100,4,200,1,3,2]
// [0,3,7,2,5,8,4,6,0,1]
// []
// [1,2]
// [1,3]
// [10]
// [1,2,0,1]
// [0]