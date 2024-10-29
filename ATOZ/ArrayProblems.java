
package ATOZ;

import java.util.Map;
import java.util.HashMap;

public class ArrayProblems {
    public void reverseArray(int[] arr, int start, int end) {
        int temp = 0;

        while (start <= end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void RotateToLeft(int[] arr, int k) {
        k = k % arr.length;
        reverseArray(arr, 0, k - 1);

        reverseArray(arr, k, arr.length - 1);

        reverseArray(arr, 0, arr.length - 1);
    }

    public int longestSubarraywithSumK(int[] nums, int k) {
        int maxLen = 0, sum = 0;
        int rem = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        // preSum.put(rem, 0);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            rem = sum - k;
            if (preSum.containsKey(rem)) {
                int len = preSum.get(rem);
                maxLen = Math.max(len, maxLen);

            }
            if (!preSum.containsKey(rem)) {
                preSum.put(sum, i);
            }
        }
        return maxLen;
    }
}