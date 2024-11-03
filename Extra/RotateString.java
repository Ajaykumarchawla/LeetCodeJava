package Extra;

public class RotateString {
    public boolean rotateString(String s, String goal) {

        int length = goal.length();
        if (length != s.length()) {
            return false;
        }
        for (int i = 0; i < goal.length(); i++) {
            if (goal.charAt(i) == s.charAt(0)) {
                int j = 1;
                while (j < length && goal.charAt((i + j) % length) == s.charAt(j)) {
                    j++;
                }
                if (j == length) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean rotateStringOptimal(String s, String goal) {
        if (goal.length() != s.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }
}
