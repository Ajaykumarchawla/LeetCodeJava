package Extra;
// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.

// Example 1:

// Input: nums = [1,3,5,6], target = 5
// Output: 2
// Example 2:

// Input: nums = [1,3,5,6], target = 2
// Output: 1
// Example 3:

// Input: nums = [1,3,5,6], target = 7
// Output: 4

// Constraints:

// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums contains distinct values sorted in ascending order.
// -104 <= target <= 104
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j - 1) {
            if (nums[(j + i) / 2] == target) {
                return (j + i) / 2;
            } else if ((nums[(j + i) / 2]) > target) {
                j = (j + i) / 2;
            } else {
                i = (j + i) / 2;
            }
        }
        if (nums[i] >= target) {
            return i;
        } else if (nums[j] < target) {
            return j + 1;
        }
        return j;
    }
}