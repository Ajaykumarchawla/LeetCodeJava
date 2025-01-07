package Extra;

import java.util.ArrayList;
import java.util.List;

// 1408. String Matching in an Array
// Solved
// Easy
// Topics
// Companies
// Hint
// Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.

// A substring is a contiguous sequence of characters within a string

// Example 1:

// Input: words = ["mass","as","hero","superhero"]
// Output: ["as","hero"]
// Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
// ["hero","as"] is also a valid answer.
// Example 2:

// Input: words = ["leetcode","et","code"]
// Output: ["et","code"]
// Explanation: "et", "code" are substring of "leetcode".
// Example 3:

// Input: words = ["blue","green","bu"]
// Output: []
// Explanation: No string of words is substring of another string.

// Constraints:

// 1 <= words.length <= 100
// 1 <= words[i].length <= 30
// words[i] contains only lowercase English letters.
// All the strings of words are unique.
public class StringMatchingInArray {

    private boolean checkWords(String w1, String w2) {
        char[] word1 = w1.toCharArray();
        char[] word2 = w2.toCharArray();

        for (int i = 0; i < word2.length - word1.length + 1; i++) {
            int j = 0;
            for (; j < word1.length; j++) {
                if (word1[j] != word2[j + i]) {
                    break;
                }
            }
            if (j == word1.length) {
                return true;
            }
        }
        return false;
    }

    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {

                if (i != j && words[i].length() < words[j].length()) {

                    if (checkWords(words[i], words[j])) {
                        list.add(words[i]);
                        break;
                    }
                }
            }
        }
        return list;

    }
}

// Test cases
// ["mass","as","hero","superhero"]
// ["leetcode","et","code"]
// ["blue","green","bu"]
// ["leetcoder","leetcode","od","hamlet","am"]
// ["mass","as","hero","superhero", "xyzuiov", "uiknhdi", "peuish", "peusih",
// "xyzui", "ov"]
// ["leetcodeeeeeeee","efse","esfe","fes", "sef","eff","se","ef", "sem", "you",
// "yu", "o", "pen", "si", "enp", "p", "e", "n", "goal", "ol", "lol", "al",
// "midgo"]
// ["this", "is", "the", "weather", "fish"]