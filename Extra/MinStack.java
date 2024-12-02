package Extra;

import java.util.Stack;

class MinStruct {
    int value;
    int min;
}

public class MinStack {
    Stack<MinStruct> stack = new Stack<>();
    // int min = Integer.MAX_VALUE;

    public MinStack() {
    }

    public void push(int val) {
        MinStruct element = new MinStruct();
        int min = val;
        if (stack.size() >= 1 && stack.peek().min < min) {
            min = stack.peek().min;
        }
        element.value = val;
        element.min = min;
        stack.push(element);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }
}
