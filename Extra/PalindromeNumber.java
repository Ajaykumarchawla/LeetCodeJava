package Extra;
// Given an integer x, return true if x is a 

// palindrome
// , and false otherwise.

// Example 1:

// Input: x = 121
// Output: true
// Explanation: 121 reads as 121 from left to right and from right to left.
// Example 2:

// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
// Example 3:

// Input: x = 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

public class PalindromeNumber {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }

        int x_copy = x, count = 1;
        while (x_copy > 9) {
            x_copy = x_copy / 10;
            count = count * 10;
        }

        System.out.println(count);
        int first, last;

        while (x > 0 || count > 0) {
            first = x % 10;
            last = x / count;
            x = x % count;
            x = x / 10;
            count = count / 100;
            if (first != last)
                return false;
        }
        return true;
    }
}
