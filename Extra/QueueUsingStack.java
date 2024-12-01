package Extra;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> stack;

    public QueueUsingStack() {
        stack = new Stack<>();
    }

    public void printStack() {
        System.out.print("printing Stack: ");
        for (int i : stack) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private int popFromStack(int x) {
        if (stack.size() == 0) {
            return stack.push(x);
        } else {
            int newValue = stack.pop();
            int returnValue = this.popFromStack(x);
            stack.push(newValue);
            return returnValue;
        }
    }

    public void push(int x) {
        this.popFromStack(x);
        this.printStack();
    }

    public int pop() {
        int value = stack.pop();
        this.printStack();
        return value;
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.size() == 0 ? true : false;
    }
}
