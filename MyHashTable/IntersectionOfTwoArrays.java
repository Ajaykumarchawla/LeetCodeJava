package MyHashTable;
// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

import java.util.HashSet;
import java.util.Set;

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Explanation: [4,9] is also accepted.

// Constraints:

// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>(), iSet = new HashSet<>();
        for (int i : nums1) {
            if (!nums1Set.contains(i)) {
                nums1Set.add(i);
            }
        }

        for (int i : nums2) {
            if (nums1Set.contains(i) && !iSet.contains(i)) {
                iSet.add(i);
            }
        }

        int[] array = new int[iSet.size()];
        int iterator = 0;
        for (int i : iSet) {
            array[iterator] = i;
            iterator++;
        }
        return array;

    }
}
