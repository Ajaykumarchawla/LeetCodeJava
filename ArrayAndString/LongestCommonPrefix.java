package ArrayAndString;
// Write a function to find the longest common prefix string amongst an array of

// strings.

// If there is no common prefix, return an empty string "".

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.

// Constraints:

// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lowercase English letters.
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        char[] prefix = strs[0].toCharArray();
        int count = prefix.length;
        for (int i = 1; i < strs.length && count != 0; i++) {
            char[] word = strs[i].toCharArray();
            int j = 0;
            for (; j < word.length && j < count; j++) {
                if (word[j] != prefix[j]) {
                    break;
                }
            }
            count = j;
        }

        String strReturn = "";
        count--;
        while (count >= 0) {
            strReturn = prefix[count] + strReturn;
            count--;
        }
        return strReturn;

    }
}
