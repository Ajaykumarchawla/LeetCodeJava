package MyHashTable;
// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

// Example 1:

// Input: s = "leetcode"
// Output: 0
// Example 2:

// Input: s = "loveleetcode"
// Output: 2
// Example 3:

// Input: s = "aabb"
// Output: -1

// Constraints:

// 1 <= s.length <= 105
// s consists of only lowercase English letters.
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (!map.containsKey((Character) c)) {
                map.put((Character) c, count);
            } else {
                map.put((Character) c, -1);
            }
            count++;
        }
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c) && map.get(c) != -1) {
                return map.get(c);
            }
        }

        return -1;
    }
}
