package Array101;
// Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

// Example 1:

// Input: nums = [3,2,1]
// Output: 1
// Explanation:
// The first distinct maximum is 3.
// The second distinct maximum is 2.
// The third distinct maximum is 1.
// Example 2:

// Input: nums = [1,2]
// Output: 2
// Explanation:
// The first distinct maximum is 2.
// The second distinct maximum is 1.
// The third distinct maximum does not exist, so the maximum (2) is returned instead.
// Example 3:

// Input: nums = [2,2,3,1]
// Output: 1
// Explanation:
// The first distinct maximum is 3.
// The second distinct maximum is 2 (both 2's are counted together since they have the same value).
// The third distinct maximum is 1.

// Constraints:

// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1

// Follow up: Can you find an O(n) solution?
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        int[] max = new int[3];
        int count = 0;
        for (int i = 0; i < nums.length && count < 3; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            System.out.println(nums[i]);

            int newNum = nums[i];
            int trigger = 1;
            for (int k = 0; k < count; k++) {
                if (max[k] == newNum) {
                    trigger = 0;
                    break;
                }
                if (max[k] < newNum) {
                    int temp = max[i];
                    max[i] = newNum;
                    newNum = temp;
                }
            }
            if (trigger == 1 && count < 3) {
                max[count] = newNum;
                count++;
            }
        }

        if (count == 3) {
            return max[2];
        }
        return max[0];
    }
}