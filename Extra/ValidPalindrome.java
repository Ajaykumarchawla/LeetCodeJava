package Extra;
// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

// Given a string s, return true if it is a palindrome, or false otherwise.

// Example 1:

// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.
// Example 2:

// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.
// Example 3:

// Input: s = " "
// Output: true
// Explanation: s is an empty string "" after removing non-alphanumeric characters.
// Since an empty string reads the same forward and backward, it is a palindrome.

// Constraints:

// 1 <= s.length <= 2 * 105
// s consists only of printable ASCII characters.
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char iChar = s.charAt(i);
            char jChar = s.charAt(j);
            if (iChar >= '0' && iChar <= '9') {
            } else if (!((iChar >= 'A' && iChar <= 'Z') || (iChar >= 'a' && iChar <= 'z'))) {
                i++;
                continue;
            }
            if (iChar >= 'A' && iChar <= 'Z') {
                iChar = Character.toLowerCase(iChar);
            }
            if (jChar >= '0' && jChar <= '9') {
            } else if (!((jChar >= 'A' && jChar <= 'Z') || (jChar >= 'a' && jChar <= 'z'))) {
                j--;
                continue;
            }
            if (jChar >= 'A' && jChar <= 'Z') {
                jChar = Character.toLowerCase(jChar);
            }
            if (iChar != jChar) {
                System.out.println(iChar + " " + jChar);
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
