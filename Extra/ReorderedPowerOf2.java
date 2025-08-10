package Extra;

import java.util.Arrays;
import java.util.Set;

// 869. Reordered Power of 2
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

// Return true if and only if we can do this so that the resulting number is a power of two.

// Example 1:

// Input: n = 1
// Output: true
// Example 2:

// Input: n = 10
// Output: false

// Constraints:

// 1 <= n <= 109

public class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int n) {
        Set<String> set = Set.of("011237", "0122579", "012356789", "0124", "0134449", "0145678", "01466788", "0248",
                "0368888", "0469", "1", "112234778", "11266777", "122446", "125", "128", "1289", "13468", "16", "2",
                "224588", "23", "23334455", "234455668", "23678", "256", "35566", "4", "46", "8");
        String s = Integer.toString(n);
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return set.contains(new String(c));
    }
}

// Test Cases
// 100
// 1
// 61
// 8001
// 27131072
// 131072
// 368712509
// 842717231