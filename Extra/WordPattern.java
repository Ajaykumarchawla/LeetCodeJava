package Extra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 290. Word Pattern
// Solved
// Easy
// Topics
// Companies
// Given a pattern and a string s, find if s follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

// Each letter in pattern maps to exactly one unique word in s.
// Each unique word in s maps to exactly one letter in pattern.
// No two letters map to the same word, and no two words map to the same letter.

// Example 1:

// Input: pattern = "abba", s = "dog cat cat dog"

// Output: true

// Explanation:

// The bijection can be established as:

// 'a' maps to "dog".
// 'b' maps to "cat".
// Example 2:

// Input: pattern = "abba", s = "dog cat cat fish"

// Output: false

// Example 3:

// Input: pattern = "aaaa", s = "dog cat cat dog"

// Output: false

// Constraints:

// 1 <= pattern.length <= 300
// pattern contains only lower-case English letters.
// 1 <= s.length <= 3000
// s contains only lowercase English letters and spaces ' '.
// s does not contain any leading or trailing spaces.
// All the words in s are separated by a single space.

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        String[] words = s.split(" ");
        int i = 0;
        for (char c : pattern.toCharArray()) {
            if (i >= words.length) {
                return false;
            }
            if (map.containsKey(c)) {
                if (!words[i].equals(map.get(c))) {
                    return false;
                }
            } else {
                if (list.contains(words[i])) {
                    return false;
                }
                map.put(c, words[i]);
                list.add(words[i]);
            }
            i++;
        }
        if (words.length != i) {
            return false;
        }
        return true;
    }
}
// Test Cases:
//
// "abba"
// "dog cat cat fish"
// "aaaa"
// "dog cat cat dog"
// "abba"
// "dog constructor constructor dog"
// "e"
// "eureka"
// "aaa"
// "aa aa aa aa"
// "abba"
// "dog dog dog dog"
// "syys"
// "a abc abc a"
// "jquery"
// "jquery"