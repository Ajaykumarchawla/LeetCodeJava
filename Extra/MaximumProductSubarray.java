package Extra;
// 152. Maximum Product Subarray

// Solved
// Medium
// Topics
// Companies
// Given an integer array nums, find a 
// subarray
//  that has the largest product, and return the product.

// The test cases are generated so that the answer will fit in a 32-bit integer.

// Example 1:

// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
// Example 2:

// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

// Constraints:

// 1 <= nums.length <= 2 * 104
// -10 <= nums[i] <= 10
// The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0)
                i++;
            else {
                if (nums[i - 1] != 0) {
                    nums[i] = nums[i] * nums[i - 1];
                }
            }
        }

        int max = nums[0];
        int hasZero = 0;
        int minN = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                hasZero = 1;
                minN = 0;
            } else if (nums[i] > 0) {
                if (max < nums[i]) {
                    max = nums[i];
                }
            } else {
                if (minN != 0 && max < (nums[i] / minN)) {
                    max = nums[i] / minN;
                }
                if (minN == 0 || nums[i] > minN) {
                    minN = nums[i];

                }
            }
        }
        if (hasZero == 1 && max < 0) {
            return 0;
        }
        return max;
    }
}