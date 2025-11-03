package Extra;

import java.util.HashMap;
import java.util.Map;

// 697. Degree of an Array
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

// Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

// Example 1:

// Input: nums = [1,2,2,3,1]
// Output: 2
// Explanation: 
// The input array has a degree of 2 because both elements 1 and 2 appear twice.
// Of the subarrays that have the same degree:
// [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
// The shortest length is 2. So return 2.
// Example 2:

// Input: nums = [1,2,2,3,1,4,2]
// Output: 6
// Explanation: 
// The degree is 3 because the element 2 is repeated 3 times.
// So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.

// Constraints:

// nums.length will be between 1 and 50,000.
// nums[i] will be an integer between 0 and 49,999.

public class DegreeOfanArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                first.put(nums[i], i);
                last.put(nums[i], i);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
                last.put(nums[i], i);
            }
        }
        System.out.println(map);
        int max = 0;
        for (int i : map.keySet()) {
            if (map.get(i) > max) {
                max = map.get(i);
            }
        }
        int degree = nums.length;
        for (int i : map.keySet()) {
            if (map.get(i) == max) {
                int newDegree = last.get(i) - first.get(i);
                if (newDegree < degree) {
                    degree = newDegree;
                }
            }
        }
        return degree + 1;

    }
}
