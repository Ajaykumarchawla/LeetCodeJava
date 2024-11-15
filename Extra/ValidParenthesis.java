package Extra;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{')
                stack.push('}');
            else if (ch == '[')
                stack.push(']');
            else if (ch == '(')
                stack.push(')');
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == ch) {
                    stack.pop();
                } else
                    return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
