package Extra;

import java.util.Stack;
// 2116. Check if a Parentheses String Can Be Valid
// Solved
// Medium
// Topics
// Companies
// Hint
// A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:

// It is ().
// It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
// It can be written as (A), where A is a valid parentheses string.
// You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only of '0's and '1's. For each index i of locked,

// If locked[i] is '1', you cannot change s[i].
// But if locked[i] is '0', you can change s[i] to either '(' or ')'.
// Return true if you can make s a valid parentheses string. Otherwise, return false.

// Example 1:

// Input: s = "))()))", locked = "010100"
// Output: true
// Explanation: locked[1] == '1' and locked[3] == '1', so we cannot change s[1] or s[3].
// We change s[0] and s[4] to '(' while leaving s[2] and s[5] unchanged to make s valid.
// Example 2:

// Input: s = "()()", locked = "0000"
// Output: true
// Explanation: We do not need to make any changes because s is already valid.
// Example 3:

// Input: s = ")", locked = "0"
// Output: false
// Explanation: locked permits us to change s[0]. 
// Changing s[0] to either '(' or ')' will not make s valid.

// Constraints:

// n == s.length == locked.length
// 1 <= n <= 105
// s[i] is either '(' or ')'.
// locked[i] is either '0' or '1'.
public class CheckIfParenthesisStringCanBeValid {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Integer> indices = new Stack<>();
        Stack<Integer> freeIndices = new Stack<>();
        for (int i = 0; i < locked.length(); i++) {
            char c = s.charAt(i);
            // System.out.println(stack+" "+c+" "+locked.charAt(i));

            if (locked.charAt(i) == '1') {
                if (c == ')') {
                    if (indices.isEmpty()) {
                        if (freeIndices.isEmpty()) {
                            return false;
                        } else {
                            freeIndices.pop();
                        }
                    } else {
                        indices.pop();
                    }
                } else {
                    indices.push(i);

                }
            } else {
                freeIndices.push(i);
            }
        }

        while (!indices.isEmpty()) {
            if (freeIndices.isEmpty()) {
                return false;
            } else {
                if (indices.peek() < freeIndices.peek()) {
                    indices.pop();
                    freeIndices.pop();
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}

// Testcases
// "((())(((()()"
// "100000111010"
// "()()()()(((()("
// "10000000000001"
// "))()()()(((())"
// "10000000000001"
// "((()(()()))()((()()))))(((()(()"
// "1011110010010100111010000001001"
// "())(()(()(())()())(())((())(()())((())))))(((((((())(()))))("
// "100011110110011011010111100111011101111110000101001101001111"
// "())()))()(()(((())(()()))))((((()())(())"
// "1011101100010001001011000000110010100101"
// "())()))()(()(((())(()()))))((((()())(())"
// "1011101100010001001011000000110010100101"