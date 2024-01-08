package MyHashTable;

import java.util.HashMap;
import java.util.Map;
// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

// Example 1:

// Input: s = "egg", t = "add"
// Output: true
// Example 2:

// Input: s = "foo", t = "bar"
// Output: false
// Example 3:

// Input: s = "paper", t = "title"
// Output: true

// Constraints:

// 1 <= s.length <= 5 * 104
// t.length == s.length
// s and t consist of any valid ascii character.
public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> smap = new HashMap<Character, Character>();
        char temp = 'a';
        String tempString = "";
        String tempString2 = "";

        for (char c : s.toCharArray()) {
            if (!smap.containsKey(c)) {
                smap.put(c, temp);
                temp++;
            }
            tempString = tempString + smap.get(c);
        }
        smap.clear();
        temp = 'a';
        for (char c : t.toCharArray()) {
            if (!smap.containsKey(c)) {
                smap.put(c, temp);
                temp++;
            }
            tempString2 = tempString2 + smap.get(c);
        }
        if (tempString.equals(tempString2))
            return true;
        else
            return false;
    }
}
