package Extra;

// 1695. Maximum Erasure Value

// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

// Return the maximum score you can get by erasing exactly one subarray.

// An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

// Example 1:

// Input: nums = [4,2,4,5,6]
// Output: 17
// Explanation: The optimal subarray here is [2,4,5,6].
// Example 2:

// Input: nums = [5,2,1,2,5,2,1,2,5]
// Output: 8
// Explanation: The optimal subarray here is [5,2,1] or [1,2,5].

// Constraints:

// 1 <= nums.length <= 105
// 1 <= nums[i] <= 104
public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int[] sum = new int[nums.length];
        int[] ans = new int[nums.length];

        sum[0] = nums[0];
        ans[0] = nums[0];
        int max = -1;
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
            int j = i - 1;
            while (j > max) {
                if (nums[j] == nums[i]) {
                    max = j;
                    break;
                }
                j--;
            }

            if (max > -1) {
                ans[i] = sum[i] - sum[max];
            } else {
                ans[i] = sum[i];
            }

        }

        max = 0;
        for (int i : ans) {
            if (i > max) {
                max = i;
            }
        }
        return max;

    }
}
// Test cases
// [1, 1, 1, 1, 2, 2, 2]
// [1, 9, 7, 10, 7, 8, 8, 2, 2, 2, 3, 1, 5, 7, 7, 10, 10, 4, 3, 8]
// [187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434]
// [8, 15, 6, 12, 3, 4, 2, 15, 10, 20, 7, 14, 5, 17, 1, 20, 7, 2, 3, 16, 13, 19,
// 8, 15, 16, 15, 7, 15, 18, 9, 17, 3, 8, 14, 4, 9, 13, 19, 1, 7, 8, 15, 19, 2,
// 10, 20, 7, 16, 6, 8]
// [1, 10, 3, 8, 19, 5, 12, 3, 17, 3, 8, 18, 19, 9, 5, 11, 1, 6, 8, 1, 7, 20, 2,
// 8, 11, 15, 4, 14, 11, 13, 20, 18, 6, 16, 5, 11, 8, 1, 5, 13, 19, 11, 15, 9,
// 8, 4, 4, 6, 7, 2]
// [10, 17, 10, 7, 4, 12, 16, 4, 20, 13, 7, 18, 9, 16, 20, 3, 5, 6, 1, 6, 12,
// 16, 15, 10, 13, 3, 4, 17, 1, 11, 11, 6, 15, 12, 1, 17, 11, 10, 2, 18, 15, 4,
// 5, 1, 14, 15, 9, 8, 8, 5]
// [10, 1, 4, 15, 14, 14, 1, 6, 11, 14, 1, 9, 12, 17, 4, 7, 8, 1, 1, 5, 20, 9,
// 6, 17, 17, 11, 5, 18, 7, 17, 13, 10, 17, 20, 5, 10, 9, 3, 17, 2, 1, 2, 20,
// 11, 3, 10, 7, 15, 1, 19]
// [18, 8, 8, 19, 3, 1, 19, 1, 15, 13, 10, 4, 12, 2, 3, 3, 11, 4, 20, 11, 12, 4,
// 14, 9, 8, 1, 13, 15, 9, 20, 12, 13, 11, 8, 7, 8, 15, 10, 5, 17, 4, 10, 18, 5,
// 12, 18, 5, 16, 13, 2]