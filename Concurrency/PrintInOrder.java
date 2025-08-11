package Concurrency;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// 1114. Print in Order
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Suppose we have a class:

// public class Foo {
//   public void first() { print("first"); }
//   public void second() { print("second"); }
//   public void third() { print("third"); }
// }
// The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().

// Note:

// We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seem to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.

// Example 1:

// Input: nums = [1,2,3]
// Output: "firstsecondthird"
// Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
// Example 2:

// Input: nums = [1,3,2]
// Output: "firstsecondthird"
// Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.

// Constraints:

// nums is a permutation of [1, 2, 3].
public class PrintInOrder {
    public static void main(String[] args) {
        Foo foo = new Foo();

        Thread t1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.print("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.print("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    static class Foo {
        ReentrantLock lock = new ReentrantLock();
        Condition firstPrinted = lock.newCondition();
        Condition secondPrinted = lock.newCondition();
        AtomicBoolean firstIsDone = new AtomicBoolean(false);
        AtomicBoolean secondIsDone = new AtomicBoolean(false);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstIsDone.set(true);
            firstPrinted.signal();
            lock.unlock();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            while (!firstIsDone.get())
                firstPrinted.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondIsDone.set(true);
            secondPrinted.signal();
            lock.unlock();

        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            while (!secondIsDone.get())
                secondPrinted.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            lock.unlock();
        }
    }
}

// Test cases:
// [1,2,3]
// [1,3,2]
// [2,1,3]