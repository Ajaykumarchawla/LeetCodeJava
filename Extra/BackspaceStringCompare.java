package Extra;

import java.util.ArrayDeque;
import java.util.Deque;

// 844. Backspace String Compare
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

// Note that after backspacing an empty text, the text will continue empty.

// Example 1:

// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".
// Example 2:

// Input: s = "ab##", t = "c#d#"
// Output: true
// Explanation: Both s and t become "".
// Example 3:

// Input: s = "a#c", t = "b"
// Output: false
// Explanation: s becomes "c" while t becomes "b".

// Constraints:

// 1 <= s.length, t.length <= 200
// s and t only contain lowercase letters and '#' characters.

// Follow up: Can you solve it in O(n) time and O(1) space?

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '#')
                stack1.pollLast();
            else
                stack1.addLast(c);
        }

        for (char c : t.toCharArray()) {
            if (c == '#')
                stack2.pollLast();
            else
                stack2.addLast(c);
        }
        if (stack1.size() != stack2.size()) {
            return false;
        }

        while (!stack1.isEmpty()) {
            if (stack1.pop() != stack2.pop())
                return false;
        }
        return true;

    }
}
