package Extra;

import java.util.Set;

// 3136. Valid Word
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// A word is considered valid if:

// It contains a minimum of 3 characters.
// It contains only digits (0-9), and English letters (uppercase and lowercase).
// It includes at least one vowel.
// It includes at least one consonant.
// You are given a string word.

// Return true if word is valid, otherwise, return false.

// Notes:

// 'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
// A consonant is an English letter that is not a vowel.

public class ValidWord {

    public static boolean isValid(String word) {
        if (word == null || word.length() < 3)
            return false;

        if (!word.chars().allMatch(Character::isLetterOrDigit))
            return false;

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        boolean hasVowel = word.chars().mapToObj(c -> (char) c)
                .anyMatch(vowels::contains);
        boolean hasConsonant = word.chars().mapToObj(c -> (char) c)
                .anyMatch(c -> Character.isLetter(c) && !vowels.contains(c));

        return hasVowel && hasConsonant;
    }

}

// test cases
// "234Adas"
// "b3"
// "a3$e"
// "IS"