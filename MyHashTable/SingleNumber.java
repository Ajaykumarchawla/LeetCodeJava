package MyHashTable;
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

import java.util.HashSet;
import java.util.Set;

// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 1:

// Input: nums = [2,2,1]
// Output: 1
// Example 2:

// Input: nums = [4,1,2,1,2]
// Output: 4
// Example 3:

// Input: nums = [1]
// Output: 1

// Constraints:

// 1 <= nums.length <= 3 * 104
// -3 * 104 <= nums[i] <= 3 * 104
// Each element in the array appears twice except for one element which appears only once.
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int i : nums) {
            if (set1.contains(i)) {
                set1.remove(i);
            } else {
                set1.add(i);
            }
        }
        for (Integer i : set1) {
            return i;
        }
        return -1;
    }
}
