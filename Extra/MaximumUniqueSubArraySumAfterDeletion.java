package Extra;

import java.util.HashSet;
import java.util.Set;

// 3487. Maximum Unique Subarray Sum After Deletion
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// You are given an integer array nums.

// You are allowed to delete any number of elements from nums without making it empty. After performing the deletions, select a subarray of nums such that:

// All elements in the subarray are unique.
// The sum of the elements in the subarray is maximized.
// Return the maximum sum of such a subarray.

// Example 1:

// Input: nums = [1,2,3,4,5]

// Output: 15

// Explanation:

// Select the entire array without deleting any element to obtain the maximum sum.

// Example 2:

// Input: nums = [1,1,0,1,1]

// Output: 1

// Explanation:

// Delete the element nums[0] == 1, nums[1] == 1, nums[2] == 0, and nums[3] == 1. Select the entire array [1] to obtain the maximum sum.

// Example 3:

// Input: nums = [1,2,-1,-2,1,0,-1]

// Output: 3

// Explanation:

// Delete the elements nums[2] == -1 and nums[3] == -2, and select the subarray [2, 1] from [1, 2, 1, 0, -1] to obtain the maximum sum.

// Constraints:

// 1 <= nums.length <= 100
// -100 <= nums[i] <= 100

public class MaximumUniqueSubArraySumAfterDeletion {
    public int maxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (i > 0) {
                if (!set.contains(i)) {
                    sum = sum + i;
                    set.add(i);
                }
            } else {
                max = Math.max(max, i);
            }
        }

        if (sum > 0) {
            return sum;
        } else {
            return max;
        }

    }
}

// Test cases:
// [0]
// [-1]
// [6, 4, 6, 1, 4, 2, -2, -7, 5, -6]
// [0, 3, -10, -9, 6, -9, 2, 7, -2, -8]
// [-6, 8, -6, 8, -10, -3, 4, -7, 1, 6]
// [-7, -6, -6, -6, 0, -4, -8, -3, -2, -7]
// [-86, -73, -2, -84, -22, -72, -55, -97, -34, -3]
// [-59, 77, 81, -32, -58, -73, 22, -28, 48, -43, -34, -43, -45, 3, 78, 78, 6,
// -74, -91, -84, 6, -47, 80, 0, -88, 4, -44, 8, 42, 99, 72, -96, -13, -32, 12,
// 91, 59, -26, 18, -11, 60, 85, -67, 14, -85, 20, -34, -95, -91, 62, 75, -87,
// 14, -81, 30, 5, -31, -43, 68, 74, 71, 9, 36, -72, 38, -55, 38, 1, -13, 31,
// -62, 37, -44, -38, 28, 75, -54, -43, 22, -20, -23, 36, -30, -23, 27, -24, 2,
// 50, -14, -2, -78, 81, 31, 32, -70, -20, 11, 39, 58, 23]