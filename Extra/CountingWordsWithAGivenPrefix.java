package Extra;

public class CountingWordsWithAGivenPrefix {
    public int prefixCount(String[] words, String pref) {
        char[] prefix = pref.toCharArray();
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= prefix.length) {

                for (int j = 0; j < words[i].length(); j++) {
                    if (words[i].charAt(j) != prefix[j]) {
                        break;
                    }
                    if (j == (prefix.length - 1)) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}

// Test cases
// ["pay","attention","practice","attend"]
// "at"
// ["leetcode","win","loops","success"]
// "code"
// ["a", "ab", "abc", "bca", "bac"]
// "a"
// ["hello", "world", "prefix"]
// "a"
// ["cat", "dog", "bird"]
// "elephant"
// ["foo", "foobar", "foo", "barfoo"]
// "foo"
// ["pre", "prefix", "prelude", "presentation"]
// "pre"
// ["word"]
// "wo"