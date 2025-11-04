package Extra;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Subarrays I
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// You are given an array nums of n integers and two integers k and x.

// The x-sum of an array is calculated by the following procedure:

// Count the occurrences of all elements in the array.
// Keep only the occurrences of the top x most frequent elements. If two elements have the same number of occurrences, the element with the bigger value is considered more frequent.
// Calculate the sum of the resulting array.
// Note that if an array has less than x distinct elements, its x-sum is the sum of the array.

// Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the subarray nums[i..i + k - 1].

// Example 1:

// Input: nums = [1,1,2,2,3,4,2,3], k = 6, x = 2

// Output: [6,10,12]

// Explanation:

// For subarray [1, 1, 2, 2, 3, 4], only elements 1 and 2 will be kept in the resulting array. Hence, answer[0] = 1 + 1 + 2 + 2.
// For subarray [1, 2, 2, 3, 4, 2], only elements 2 and 4 will be kept in the resulting array. Hence, answer[1] = 2 + 2 + 2 + 4. Note that 4 is kept in the array since it is bigger than 3 and 1 which occur the same number of times.
// For subarray [2, 2, 3, 4, 2, 3], only elements 2 and 3 are kept in the resulting array. Hence, answer[2] = 2 + 2 + 2 + 3 + 3.
// Example 2:

// Input: nums = [3,8,7,8,7,5], k = 2, x = 2

// Output: [11,15,15,15,12]

// Explanation:

// Since k == x, answer[i] is equal to the sum of the subarray nums[i..i + k - 1].

// Constraints:

// 1 <= n == nums.length <= 50
// 1 <= nums[i] <= 50
// 1 <= x <= k <= nums.length

public class FindXSumofAllKLongSubarraysI {
    class Entry {
        int freq = 0;
        int value = 0;

        public Entry(int freq, int val) {
            this.freq = freq;
            this.value = val;

        }

        public String toString() {
            return freq + " " + value;
        }
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int[] ans = new int[nums.length - k + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int i = 0;
        for (; i < nums.length - k; i++) {
            ans[i] = getSum(map, x);
            map.put(nums[i], map.get(nums[i]) - 1);
            map.put(nums[i + k], map.getOrDefault(nums[i + k], 0) + 1);
        }
        ans[i] = getSum(map, x);
        return ans;
    }

    int getSum(Map<Integer, Integer> map, int x) {

        int sum = 0;

        PriorityQueue<Entry> queue = new PriorityQueue<>((a, b) -> {
            if (a.freq == b.freq) {
                return b.value - a.value;
            } else {
                return b.freq - a.freq;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new Entry(entry.getValue(), entry.getKey()));
        }

        for (int i = 0; i < x; i++) {
            Entry e = queue.poll();
            if (e == null)
                break;
            sum = sum + (e.freq * e.value);
        }
        return sum;
    }
}
// Test Cases:
// [1,1,2,2,3,4,2,3]
// 6
// 2
// [3,8,7,8,7,5]
// 2
// 2
// [1,2,3,4,5]
// 3
// 3
// [1,2,3,4,5,6,7,9,7,7,10,12,45,50,21,45,24,12,36,14,7,6,14,42,49,47,48,46,43,42,41,30,3,5,35,36,39,38,37]
// 21
// 5
// [1]
// 1
// 1
// [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2]
// 10
// 1
// [25,26,27,28,29,30,19,18,17,16,15,10,10,10,10,10,10,10,10,10,10,10,10,25,26,27,28,29,30,19,18,17,16,15,14,13,12,11,10,10,10,10,10,10,10,10,10,10,10,10]
// 25
// 25