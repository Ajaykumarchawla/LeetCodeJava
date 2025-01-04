package Contests;

public class BiweeklyContest147 {

    // Q1. Substring Matching Pattern
    // Solved
    // Easy
    // 3 pt.
    // You are given a string s and a pattern string p, where p contains exactly one
    // '*' character.

    // The '*' in p can be replaced with any sequence of zero or more characters.

    // Return true if p can be made a substring of s, and false otherwise.

    // A substring is a contiguous non-empty sequence of characters within a string.

    // Example 1:

    // Input: s = "leetcode", p = "ee*e"

    // Output: true

    // Explanation:

    // By replacing the '*' with "tcod", the substring "eetcode" matches the
    // pattern.

    // Example 2:

    // Input: s = "car", p = "c*v"

    // Output: false

    // Explanation:

    // There is no substring matching the pattern.

    // Example 3:

    // Input: s = "luck", p = "u*"

    // Output: true

    // Explanation:

    // The substrings "u", "uc", and "uck" match the pattern.

    // Constraints:

    // 1 <= s.length <= 50
    // 1 <= p.length <= 50
    // s contains only lowercase English letters.
    // p contains only lowercase English letters and exactly one '*'

    public boolean hasMatch(String s, String p) {
        char[] string = s.toCharArray();
        char[] pattern = p.toCharArray();

        int m = 0;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                m = i;
                break;
            }
        }

        int firstEnd = -1;
        if (m != 0) {
            for (int i = 0; i < string.length; i++) {

                boolean flag = true;
                for (int j = 0; j < pattern.length; j++) {
                    if (pattern[j] == '*') {
                        firstEnd = (i + j) - 1;
                        break;
                    }
                    if ((i + j) < string.length && pattern[j] == string[i + j]) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    firstEnd = i + m - 1;
                    break;
                }
            }
            if (firstEnd == -1) {
                return false;
            }
        }

        if (m != pattern.length - 1) {
            for (int i = firstEnd + 1; i < string.length; i++) {

                boolean flag = true;
                for (int j = m + 1; j < pattern.length; j++) {
                    // System.out.println(pattern[j]+" "+string[i+j -(m+1)]+" "+(i+j -(m+1)));
                    if ((i + j - (m + 1)) < string.length && pattern[j] == string[i + j - (m + 1)]) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    return true;
                }
            }
            return false;
        }

        return true;
    }
    // testcases

    // "leetcode"
    // "ee*e"
    // "car"
    // "c*v"
    // "luck"
    // "u*"
    // "leetcode"
    // "ee*de"
    // "leetcode"
    // "*code"
    // "leetcode"
    // "leet*code"
    // "ckckkk"
    // "ck*kc"
    // "kvb"
    // "k*v"©leetcode
}