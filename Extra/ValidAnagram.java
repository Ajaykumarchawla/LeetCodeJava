package Extra;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        char[] t1 = t.toCharArray();
        Arrays.sort(t1);

        s = new String(s1);
        t = new String(t1);

        if (s.equals(t)) {
            return true;
        } else {
            return false;
        }

    }
}