package ArrayAndString;

// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

// Example 1:

// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
// Example 2:

// Input: s = "God Ding"
// Output: "doG gniD"

// Constraints:

// 1 <= s.length <= 5 * 104
// s contains printable ASCII characters.
// s does not contain any leading or trailing spaces.
// There is at least one word in s.
// All the words in s are separated by a single space.
public class ReverseWordsInStringII {
    public String reverseWords(String s) {
        String newString = "";

        int i = 0, j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                int k = i - 1;
                while (k >= j) {
                    newString = newString + s.charAt(k);
                    k--;
                }
                newString = newString + " ";

                j = i + 1;
            }
            i++;
        }
        if (i != j) {
            int k = i - 1;
            while (k >= j) {
                newString = newString + s.charAt(k);
                k--;
            }

            j = i + 1;
        }

        return newString;
    }
}