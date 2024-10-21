package Extra;

import java.util.Map;
import java.util.HashMap;
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:

// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:

// Input: nums = [1,2,3], k = 3
// Output: 2

// Constraints:

// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107
public class SubarraySumEqualsK {
    public int subarraySumBruteForce(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            int newSum = 0;
            if ((sum - newSum) == k) {
                count++;
            }
            for (int j = 0; j < i; j++) {

                newSum = newSum + nums[j];
                if ((sum - newSum) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();

        int count = 0, sum = 0, rem = 0;
        preSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            rem = sum - k;

            if (preSum.get(rem) != null) {
                int sub = preSum.get(rem);
                count = count + sub;
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}
