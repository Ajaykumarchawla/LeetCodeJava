package ArrayAndString;

import java.util.Arrays;

// Given an integer array nums of 2 n integers,group these integers into n pairs(a1,b1),(a2,b2),...,(an,bn)such that the sum of min(ai,bi)for all i is maximized.Return the maximized sum.

// Example 1:

// Input: nums = [1,4,3,2]
// Output: 4
// Explanation: All possible pairings (ignoring the ordering of elements) are:
// 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
// 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
// 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
// So the maximum possible sum is 4.
// Example 2:

// Input: nums = [6,2,6,5,1,2]
// Output: 9
// Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.

// Constraints:

// 1 <= n <= 104
// nums.length == 2 * n
// -104 <= nums[i] <= 104
//    Show Hint #1  
//    Hide Hint #2  
// How will you make pairs to get the result? There must be some pattern.
//    Hide Hint #3  
// Did you observe that- Minimum element gets add into the result in sacrifice of maximum element.
//    Hide Hint #4  
// Still won't able to find pairs? Sort the array and try to find the pattern.
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum = sum + nums[i];
            System.out.println(nums[i]);
        }
        return sum;
    }
}
