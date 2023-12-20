package RecursionI;
// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// Example 2:

// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step

// Constraints:

// 1 <= n <= 45
//    Hide Hint #1  
// To reach nth step, what could have been your previous steps? (Think about the step sizes)
import java.util.HashMap;

public class ClimbingStairs {
    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else {
            if (cache.containsKey(n)) {
                return cache.get(n);
            }
            int value = climbStairs(n - 2) + climbStairs(n - 1);
            cache.put(n, value);
            return value;
        }
    }
}
