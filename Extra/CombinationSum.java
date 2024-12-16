package Extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 39. Combination Sum
// Solved
// Medium
// Topics
// Companies
// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
// frequency
//  of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

// Example 1:

// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.
// Example 2:

// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]
// Example 3:

// Input: candidates = [2], target = 1
// Output: []

// Constraints:

// 1 <= candidates.length <= 30
// 2 <= candidates[i] <= 40
// All elements of candidates are distinct.
// 1 <= target <= 40

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> list = new ArrayList<>();
        Arrays.sort(candidates);

        for (int i = 0; i <= target; i++) {
            List<List<Integer>> subList = new ArrayList<>();
            for (int j : candidates) {

                if (i - j == 0) {
                    List<Integer> combination = new ArrayList<>();
                    combination.add(j);
                    subList.add(combination);
                } else if (i - j >= 0) {
                    List<List<Integer>> tempSubList = list.get(i - j);
                    for (List temp : tempSubList) {
                        if ((int) temp.get(temp.size() - 1) <= j) {
                            List<Integer> newList = new ArrayList<>(temp);
                            newList.add(j);
                            subList.add(newList);
                        }
                    }
                }

            }
            list.add(subList);
        }
        return list.get(target);
    }
}