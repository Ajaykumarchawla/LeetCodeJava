package Extra;

// 367. Valid Perfect Square
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given a positive integer num, return true if num is a perfect square or false otherwise.

// A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

// You must not use any built-in library function, such as sqrt.

// Example 1:

// Input: num = 16
// Output: true
// Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
// Example 2:

// Input: num = 14
// Output: false
// Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.

// Constraints:

// 1 <= num <= 231 - 1

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int i = 0, j = num;
        while (i < j) {
            int mid = (int) ((long) i + j) / 2 + (int) ((long) i + j) % 2;

            long midSquare = (long) mid * mid;
            if (midSquare == num) {
                return true;
            }
            if (midSquare < num) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}
// Test Cases:
// 2147483647
// 109748
// 48439032
// 28230482
// 90432502
// 156076256
// 2950
