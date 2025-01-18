package Contests;

import java.util.Arrays;

import javax.lang.model.util.Elements;

public class BiweeklyContest148 {
    // 2. Minimum Cost to Make Arrays Identical
    // Solved
    // Medium
    // 4 pt.
    // You are given two integer arrays arr and brr of length n, and an integer k.
    // You can perform the following operations on arr any number of times:

    // Split arr into any number of contiguous subarrays and rearrange these
    // subarrays in any order. This operation has a fixed cost of k.
    // Choose any element in arr and add or subtract a positive integer x to it. The
    // cost of this operation is x.

    // Return the minimum total cost to make arr equal to brr.

    // A subarray is a contiguous non-empty sequence of elements within an array.

    // Example 1:

    // Input: arr = [-7,9,5], brr = [7,-2,-5], k = 2

    // Output: 13

    // Explanation:

    // Split arr into two contiguous subarrays: [-7] and [9, 5] and rearrange them
    // as [9, 5, -7], with a cost of 2.
    // Subtract 2 from element arr[0]. The array becomes [7, 5, -7]. The cost of
    // this operation is 2.
    // Subtract 7 from element arr[1]. The array becomes [7, -2, -7]. The cost of
    // this operation is 7.
    // Add 2 to element arr[2]. The array becomes [7, -2, -5]. The cost of this
    // operation is 2.
    // The total cost to make the arrays equal is 2 + 2 + 7 + 2 = 13.

    // Example 2:

    // Input: arr = [2,1], brr = [2,1], k = 0

    // Output: 0

    // Explanation:

    // Since the arrays are already equal, no operations are needed, and the total
    // cost is 0.

    // Constraints:

    // 1 <= arr.length == brr.length <= 105
    // 0 <= k <= 2 * 1010
    // -105 <= arr[i] <= 105
    // -105 <= brr[i] <= 105
    public long minCost(int[] arr, int[] brr, long k) {
        long cost = 0;

        for (int i = 0; i < arr.length; i++) {
            int num1 = arr[i];
            int num2 = brr[i];

            if (num1 < num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            cost = cost + num1 - num2;
        }
        long newCost = 0;

        Arrays.sort(arr);
        Arrays.sort(brr);

        for (int i = 0; i < arr.length; i++) {
            int num1 = arr[i];
            int num2 = brr[i];

            if (num1 < num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            newCost = newCost + num1 - num2;
        }
        if ((newCost + k) < cost) {
            return newCost + k;
        }
        return cost;
    }

    // Q1. Maximum Difference Between Adjacent Elements in a Circular Array
    // Solved
    // Easy
    // 3 pt.
    // Given a circular array nums, find the maximum absolute difference between
    // adjacent elements.

    // Note: In a circular array, the first and last elements are adjacent.

    // Example 1:

    // Input: nums = [1,2,4]

    // Output: 3

    // Explanation:

    // Because nums is circular, nums[0] and nums[2] are adjacent. They have the
    // maximum absolute difference of |4 - 1| = 3.

    // Example 2:

    // Input: nums = [-5,-10,-5]

    // Output: 5

    // Explanation:

    // The adjacent elements nums[0] and nums[1] have the maximum absolute
    // difference of |-5 - (-10)| = 5.

    // Constraints:

    // 2 <= nums.length <= 100
    // -100 <= nums[i] <= 100
    public int maxAdjacentDistance(int[] nums) {
        int max = 0;

        for (int i = 1; i <= nums.length; i++) {
            int i1 = i % nums.length;
            int i2 = (i - 1) % nums.length;
            if (nums[i1] < nums[i2]) {
                int temp = i1;
                i1 = i2;
                i2 = temp;
            }
            System.out.println(nums[i1] + " " + nums[i2] + " " + i1 + " " + i2);
            if (nums[i1] - nums[i2] > max) {
                max = nums[i1] - nums[i2];
            }
        }
        return max;
    }
}
