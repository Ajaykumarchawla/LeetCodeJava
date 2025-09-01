package Extra;
// 434. Number of Segments in a String

// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given a string s, return the number of segments in the string.

// A segment is defined to be a contiguous sequence of non-space characters.

// Example 1:

// Input: s = "Hello, my name is John"
// Output: 5
// Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
// Example 2:

// Input: s = "Hello"
// Output: 1

// Constraints:

// 0 <= s.length <= 300
// s consists of lowercase and uppercase English letters, digits, or one of the following characters "!@#$%^&*()_+-=',.:".
// The only space character in s is ' '.

public class NumberOfSegmentsInAString {

    public int countSegments(String s) {
        if (s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int i = 0;
        int count = 0;
        boolean charac = false;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                if (charac) {
                    count++;
                    charac = false;
                }
            } else {
                charac = true;
            }
            i++;
        }
        if (charac)
            return count + 1;
        return count;
    }
}

// Test Cases
// " "
// "Hello"
// ", , , , a, eaefa"
// "Hello, my name is John"
// " He"
// ""
// " h h "
// ", , , , a, e a e f a"