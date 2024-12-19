package Extra;
// 55. Jump Game

// Solved
// Medium
// Topics
// Companies
// You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

// Return true if you can reach the last index, or false otherwise.

// Example 1:

// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Example 2:

// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

// Constraints:

// 1 <= nums.length <= 104
// 0 <= nums[i] <= 105
public class JumpGame {
    private boolean jump(int[] nums, int current) {
        if (current >= nums.length) {
            return true;
        } else {
            for (int i = current; i <= (current + nums[current]); i++) {
                int newCurrent = nums[i] + current;

                if (newCurrent != current && jump(nums, newCurrent) == true) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean canJump(int[] nums) {
        return jump(nums, 0);
    }

    public boolean canJumpOptimal(int[] nums) {
        int[] dp = new int[nums.length + 1];
        if (nums[0] == 0 && nums.length != 1) {
            return false;
        }
        if (nums[0] == 0) {
            return true;
        }
        dp[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            if (dp[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
