package Extra;
// 225. Implement Stack using Queues

// Easy
// Topics
// Companies

import java.util.LinkedList;
import java.util.Queue;

// Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

// Implement the MyStack class:

//     void push(int x) Pushes element x to the top of the stack.
//     int pop() Removes the element on the top of the stack and returns it.
//     int top() Returns the element on the top of the stack.
//     boolean empty() Returns true if the stack is empty, false otherwise.

// Notes:

//     You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
//     Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.

// Example 1:

// Input
// ["MyStack", "push", "push", "top", "pop", "empty"]
// [[], [1], [2], [], [], []]
// Output
// [null, null, null, 2, 2, false]

// Explanation
// MyStack myStack = new MyStack();
// myStack.push(1);
// myStack.push(2);
// myStack.top(); // return 2
// myStack.pop(); // return 2
// myStack.empty(); // return False

public class StackUsingQueue {
    Queue<Integer> queue;

    public StackUsingQueue() {
        this.queue = new LinkedList<>();

    }

    private void print() {
        System.out.print("Printing Queue: ");
        for (int x : this.queue) {
            System.out.print(x + " ");

        }
        System.out.println();
    }

    public void push(int x) {
        this.queue.add(x);
        this.print();
    }

    public int pop() {
        int[] arr = new int[this.queue.size() - 1];
        int i = 0;
        while (queue.size() > 1) {
            arr[i] = queue.remove();
            i++;
        }
        int value = queue.remove();
        for (int j = 0; j < i; j++) {
            queue.add(arr[j]);
        }
        this.print();
        return value;
    }

    public int top() {
        int value = 0;
        for (int x : this.queue) {
            value = x;
        }
        return value;
    }

    public boolean empty() {
        return queue.size() == 0 ? true : false;
    }
}