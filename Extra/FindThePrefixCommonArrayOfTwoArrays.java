package Extra;

import java.util.HashSet;
import java.util.Set;
// 2657. Find the Prefix Common Array of Two Arrays
// Solved
// Medium
// Topics
// Companies
// Hint
// You are given two 0-indexed integer permutations A and B of length n.

// A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.

// Return the prefix common array of A and B.

// A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.

// Example 1:

// Input: A = [1,3,2,4], B = [3,1,2,4]
// Output: [0,2,3,4]
// Explanation: At i = 0: no number is common, so C[0] = 0.
// At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
// At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
// At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.
// Example 2:

// Input: A = [2,3,1], B = [3,1,2]
// Output: [0,1,3]
// Explanation: At i = 0: no number is common, so C[0] = 0.
// At i = 1: only 3 is common in A and B, so C[1] = 1.
// At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.

// Constraints:

// 1 <= A.length == B.length == n <= 50
// 1 <= A[i], B[i] <= n
// It is guaranteed that A and B are both a permutation of n integers.
public class FindThePrefixCommonArrayOfTwoArrays {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int count = 0;
        int[] C = new int[A.length];
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < A.length; i++) {

            if (set.contains(A[i])) {
                set.remove(A[i]);
                count++;
            } else {
                set.add(A[i]);
            }
            if (set.contains(B[i])) {
                set.remove(B[i]);
                count++;
            } else {
                set.add(B[i]);
            }
            C[i] = count;
        }
        return C;
    }

}
// test cases
// [1]
// [1]
// [1,2]
// [2,1]
// [7,6,5,4,3,2,1]
// [1,2,3,4,5,6,7]
// [2,6,7,5,4,3,1,8]
// [5,1,4,2,7,3,8,6]
// [5,18,11,3,9,12,13,4,16,1,14,17,8,20,15,10,2,7,6,19]
// [7,18,11,9,19,3,12,6,8,16,13,14,5,2,1,15,10,20,17,4]
// [24,31,37,10,38,5,32,47,42,39,6,3,33,43,21,25,18,4,9,16,13,29,23,36,35,7,48,44,49,28,34,22,46,8,20,45,14,41,12,17,2,30,15,27,1,19,40,26,11]
// [46,25,23,12,45,40,6,20,35,19,33,15,39,37,27,43,47,11,13,49,41,10,18,24,4,38,44,16,2,9,1,21,34,31,3,22,48,5,7,26,32,28,36,29,42,14,30,8,17]
// [40,11,49,3,41,32,16,23,38,35,12,28,36,21,8,33,2,14,22,5,44,37,34,27,10,47,43,26,24,48,31,19,4,42,18,30,9,39,7,45,13,20,17,25,29,15,1,6,46]
// [10,9,35,47,29,11,38,4,1,14,19,39,31,44,2,8,26,18,27,23,5,28,6,13,33,30,42,12,25,15,36,17,21,34,3,43,16,49,48,24,20,37,22,32,45,7,46,40,41]
// [29,47,40,19,31,34,12,18,27,37,50,13,35,16,42,22,6,32,39,5,38,15,9,25,3,24,36,23,33,11,49,21,43,45,44,4,48,28,10,26,8,46,20,1,7,14,17,41,2,30]
// [13,10,44,17,3,29,16,41,45,30,25,48,18,39,42,34,2,8,6,47,36,50,31,7,21,38,19,4,32,27,26,43,46,9,40,35,12,22,20,23,11,33,5,24,28,37,1,15,49,14]