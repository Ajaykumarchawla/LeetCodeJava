package Extra;

// 2210. Count Hills and Valleys in an Array

// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// You are given a 0-indexed integer array nums. An index i is part of a hill in nums if the closest non-equal neighbors of i are smaller than nums[i]. Similarly, an index i is part of a valley in nums if the closest non-equal neighbors of i are larger than nums[i]. Adjacent indices i and j are part of the same hill or valley if nums[i] == nums[j].

// Note that for an index to be part of a hill or valley, it must have a non-equal neighbor on both the left and right of the index.

// Return the number of hills and valleys in nums.

// Example 1:

// Input: nums = [2,4,1,1,6,5]
// Output: 3
// Explanation:
// At index 0: There is no non-equal neighbor of 2 on the left, so index 0 is neither a hill nor a valley.
// At index 1: The closest non-equal neighbors of 4 are 2 and 1. Since 4 > 2 and 4 > 1, index 1 is a hill. 
// At index 2: The closest non-equal neighbors of 1 are 4 and 6. Since 1 < 4 and 1 < 6, index 2 is a valley.
// At index 3: The closest non-equal neighbors of 1 are 4 and 6. Since 1 < 4 and 1 < 6, index 3 is a valley, but note that it is part of the same valley as index 2.
// At index 4: The closest non-equal neighbors of 6 are 1 and 5. Since 6 > 1 and 6 > 5, index 4 is a hill.
// At index 5: There is no non-equal neighbor of 5 on the right, so index 5 is neither a hill nor a valley. 
// There are 3 hills and valleys so we return 3.
// Example 2:

// Input: nums = [6,6,5,5,4,1]
// Output: 0
// Explanation:
// At index 0: There is no non-equal neighbor of 6 on the left, so index 0 is neither a hill nor a valley.
// At index 1: There is no non-equal neighbor of 6 on the left, so index 1 is neither a hill nor a valley.
// At index 2: The closest non-equal neighbors of 5 are 6 and 4. Since 5 < 6 and 5 > 4, index 2 is neither a hill nor a valley.
// At index 3: The closest non-equal neighbors of 5 are 6 and 4. Since 5 < 6 and 5 > 4, index 3 is neither a hill nor a valley.
// At index 4: The closest non-equal neighbors of 4 are 5 and 1. Since 4 < 5 and 4 > 1, index 4 is neither a hill nor a valley.
// At index 5: There is no non-equal neighbor of 1 on the right, so index 5 is neither a hill nor a valley.
// There are 0 hills and valleys so we return 0.

// Constraints:

// 3 <= nums.length <= 100
// 1 <= nums[i] <= 100
public class CountHillsAndValleysinanArray {
    public int countHillValley(int[] nums) {

        int i = 1;
        while (i < nums.length && nums[i] == nums[i - 1]) {
            i++;
        }
        if (i == nums.length) {
            return 0;
        }

        int count = 0;
        boolean greater = nums[i - 1] < nums[i] ? true : false;
        for (; i < nums.length - 1; i++) {

            if (greater && nums[i] > nums[i + 1]) {
                count++;
                greater = false;
            } else if (!greater && nums[i] < nums[i + 1]) {
                count++;
                greater = true;

            }

        }
        return count;
    }
}

// Test Cases:

// [1, 1, 1, 1]
// [1, 1, 2, 2, 2, 2, 2, 1]
// [1, 2, 3, 2, 1]
// [18, 87, 35, 78, 74, 3, 86, 66, 60, 7, 67]
// [34, 64, 9, 58, 15, 66, 83, 30, 86, 58, 76, 3, 61, 46, 56, 90, 61, 23, 73,
// 69, 69, 30, 52, 35, 54, 8, 42, 60, 82, 45, 50, 90, 95, 6, 42, 85, 67, 91, 56,
// 18, 17, 33, 6, 66, 34, 77, 62, 17, 1, 40, 7, 75, 29, 34, 51, 84, 88, 60, 56,
// 29, 74, 29, 86, 13, 7, 84, 77, 11, 64, 7, 34, 84, 97, 80, 23, 63, 77, 68, 1,
// 78, 33, 39, 78, 71, 64, 74, 90, 59, 42, 73, 79, 79, 89, 36, 14, 69, 51, 36,
// 50, 29]
// [20, 2, 88, 80, 75, 50, 58, 24, 48, 32, 19, 67, 9, 91, 6, 19, 86, 87, 96, 73,
// 2, 14, 60, 83, 28, 48, 96, 30, 85, 2, 6, 33, 14, 92, 31, 87, 38, 3, 44, 5,
// 99, 22, 63, 35, 17, 62, 27, 91, 56, 42, 34, 66, 58, 23, 92, 36, 85, 10, 55,
// 12, 97, 85, 76, 6, 14, 5, 49, 95, 100, 53, 87, 17, 84, 20, 48, 11, 79, 21,
// 96, 95, 30, 86, 80, 96]
// [42, 3, 38, 64, 23, 37, 58, 30, 77, 31, 39, 93, 48, 51, 93, 88, 64, 73, 44,
// 70, 78, 5, 75, 61, 32, 12, 33, 43, 91, 30, 17, 10, 45, 19, 26, 35, 26, 19,
// 42, 93, 25, 50, 95, 87, 16, 6]
// [47, 9, 85, 61, 8, 87, 15, 97, 34, 73, 90, 5, 38, 90, 31, 81, 88, 75, 7, 30,
// 82, 95, 4, 44, 98, 26, 56, 29, 25, 74, 46, 50, 8, 39, 40, 23, 39, 50, 32, 40,
// 65, 18, 25, 57, 34, 31, 24, 99, 4, 36, 83, 23, 80]