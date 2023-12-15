package RecursionI;
// Write a function that reverses a string. The input string is given as an array of characters s.

// You must do this by modifying the input array in-place with O(1) extra memory.

// Example 1:

// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
// Example 2:

// Input: s = ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]

// Constraints:

// 1 <= s.length <= 105
// s[i] is a printable ascii character.
//    Hide Hint #1  
// The entire logic for reversing a string is based on using the opposite directional two-pointer approach!
public class ReverseStringRecursive {
    public void reverseString(char[] s) {
        helper(s.length, s);
    }

    public void helper(int length, char[] s) {
        if (length == 0) {
            return;
        }
        char temp = s[length - 1];
        helper(length - 1, s);
        s[s.length - length] = temp;
    }
}
