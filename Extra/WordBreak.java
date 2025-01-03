package Extra;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;
// 139. Word Break
// Solved
// Medium
// Topics
// Companies
// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

// Example 1:

// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".
// Example 2:

// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
// Note that you are allowed to reuse a dictionary word.
// Example 3:

// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false

// Constraints:

// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int maxlength = 0;
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
            maxlength = Math.max(maxlength, word.length());
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; (j <= (i + maxlength) && j <= s.length()); j++) {
                String newWord = s.substring(i, j);
                System.out.println("this worked " + newWord);

                if (dp[i] == true && set.contains(newWord)) {
                    dp[j] = true;

                }
            }
        }
        if (dp[s.length()] == true) {
            return true;
        }
        return false;
    }
}