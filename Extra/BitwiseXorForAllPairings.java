package Extra;
// 2425. Bitwise XOR of All Pairings

// Solved
// Medium
// Topics
// Companies
// Hint
// You are given two 0-indexed arrays, nums1 and nums2, consisting of non-negative integers. There exists another array, nums3, which contains the bitwise XOR of all pairings of integers between nums1 and nums2 (every integer in nums1 is paired with every integer in nums2 exactly once).

// Return the bitwise XOR of all integers in nums3.

// Example 1:

// Input: nums1 = [2,1,3], nums2 = [10,2,5,0]
// Output: 13
// Explanation:
// A possible nums3 array is [8,0,7,2,11,3,4,1,9,1,6,3].
// The bitwise XOR of all these numbers is 13, so we return 13.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 0
// Explanation:
// All possible pairs of bitwise XORs are nums1[0] ^ nums2[0], nums1[0] ^ nums2[1], nums1[1] ^ nums2[0],
// and nums1[1] ^ nums2[1].
// Thus, one possible nums3 array is [2,5,1,6].
// 2 ^ 5 ^ 1 ^ 6 = 0, so we return 0.

// Constraints:

// 1 <= nums1.length, nums2.length <= 105
// 0 <= nums1[i], nums2[j] <= 109

public class BitwiseXorForAllPairings {

    public int xorAllNums(int[] nums1, int[] nums2) {
        int num = 0;
        if (nums2.length % 2 != 0) {
            for (int i : nums1) {
                num = num ^ i;
            }
        }
        if (nums1.length % 2 != 0) {
            for (int i : nums2) {
                num = num ^ i;
            }
        }
        return num;
    }
}
// Testcases
// [2]
// [4]
// [27,6,15]
// [8,23,15,16,25,5]
// [10,0,15,25,29,3,2]
// [12]
// [16,15,8,6,29,2,96,29]
// [24,12,13]
// [29,10,25,6]
// [24,11,1,17,11,5,1,1,27]
// [947,662,559,0,967,251,90,234,864,402,101,889,146,358,940,264,411,962,448,369,485,925,558,347,53,245,598]
// [440,506,176,480,787,124,989,649,750,508,494]
// [115,870,587,434,15,758,641,217,834,760,32,750,659]
// [412,942,574,687,960,398,756,153,449,217,639,260,885,710,68,454,327,367,531,483,875,511,555,912,559,962,80,979,656]
// [588,12,471,895,265,749,373,151,317,603,721,197,312,650,777,340,754,410,648,905,719,636,398,102,687,586,250,820,482,396,277,881,744,190]
// [837,785,292,275,830,157,615,845,278,664,997,959,767,493,577,611,710,644,438,205,972,753,385,819,215,382,706,76,673,798,858,774,154,243,473,700,973,59,855,225,154,668,595,253,45,949]