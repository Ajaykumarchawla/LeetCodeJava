package Array101;

// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int count = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[i - count] = nums[i];
            } else {
                count++;
            }
            i++;
        }
        while (count > 0) {
            nums[nums.length - count] = 0;
            count--;
        }
    }
}
