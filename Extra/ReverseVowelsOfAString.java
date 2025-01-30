package Extra;

import java.util.List;
import java.util.stream.Collectors;

// 345. Reverse Vowels of a String
// Solved
// Easy
// Topics
// Companies
// Given a string s, reverse only all the vowels in the string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

// Example 1:

// Input: s = "IceCreAm"

// Output: "AceCreIm"

// Explanation:

// The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

// Example 2:

// Input: s = "leetcode"

// Output: "leotcede"

// Constraints:

// 1 <= s.length <= 3 * 105
// s consist of printable ASCII characters.

public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int i = 0, j = s.length() - 1;
        String v = "aeiouAEIOU";
        List<Character> list = v.chars() // Convert String to IntStream (stream of chars)
                .mapToObj(c -> (char) c) // Map each int (char) to Character
                .collect(Collectors.toList());
        ;
        while (i < j) {
            while (i < j) {
                if (list.contains(array[i])) {
                    break;
                }
                i++;
            }

            while (i < j) {
                if (list.contains(array[j])) {
                    break;
                }
                j--;

            }

            if (i < j) {
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        return String.valueOf(array);
    }
}
// test cases
// "IceCreAm"
// "leetcode"
// "race car"
// "aA"
// "A man, a plan, a canal: Panama"
