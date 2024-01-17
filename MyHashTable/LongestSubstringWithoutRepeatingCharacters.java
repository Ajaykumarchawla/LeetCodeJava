package MyHashTable;
// Given a string s, find the length of the longest substring without repeating characters.

import java.util.HashMap;
import java.util.Map;

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

// Constraints:

// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0, index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (index < map.get(s.charAt(i)))
                    index = map.get(s.charAt(i));
            }

            if (max < i - index)
                max = i - index;

            map.put(s.charAt(i), i);
        }
        return max;
    }
}
