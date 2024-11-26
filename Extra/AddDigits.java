package Extra;
// 258. Add Digits

// Solved
// Easy
// Topics
// Companies
// Hint
// Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

// Example 1:

// Input: num = 38
// Output: 2
// Explanation: The process is
// 38 --> 3 + 8 --> 11
// 11 --> 1 + 1 --> 2 
// Since 2 has only one digit, return it.
// Example 2:

// Input: num = 0
// Output: 0

// Constraints:

// 0 <= num <= 231 - 1

// Follow up: Could you do it without any loop/recursion in O(1) runtime?
public class AddDigits {
    int getDigitsSum(int num, int sum) {
        if (num == 0) {
            if (sum <= 9) {
                return sum;
            } else {
                return getDigitsSum(sum, 0);
            }
        } else {
            sum = sum + num % 10;
            return getDigitsSum(num / 10, sum);
        }
    }

    public int addDigits(int num) {
        return getDigitsSum(num, 0);

    }
}
