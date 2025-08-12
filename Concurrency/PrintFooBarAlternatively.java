package Concurrency;

import java.util.concurrent.atomic.AtomicBoolean;

// 1115. Print FooBar Alternately
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Suppose you are given the following code:

// class FooBar {
//   public void foo() {
//     for (int i = 0; i < n; i++) {
//       print("foo");
//     }
//   }

//   public void bar() {
//     for (int i = 0; i < n; i++) {
//       print("bar");
//     }
//   }
// }
// The same instance of FooBar will be passed to two different threads:

// thread A will call foo(), while
// thread B will call bar().
// Modify the given program to output "foobar" n times.

// Example 1:

// Input: n = 1
// Output: "foobar"
// Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar().
// "foobar" is being output 1 time.
// Example 2:

// Input: n = 2
// Output: "foobarfoobar"
// Explanation: "foobar" is being output 2 times.

// Constraints:

// 1 <= n <= 1000

public class PrintFooBarAlternatively {
    private int n;

    public AtomicBoolean flag = new AtomicBoolean(false);

    public PrintFooBarAlternatively(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (this) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                while (flag.get())
                    wait();
                printFoo.run();
                flag.set(true);
                notify();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (this) {
                while (!flag.get())
                    wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag.set(false);
                notify();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintFooBarAlternatively fooBar = new PrintFooBarAlternatively(10);
        new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(100);
        System.out.println("--------------------------");

        new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

// Test Cases:
// 1
// 2
// 1000
// 999
// 80
// 678
// 569