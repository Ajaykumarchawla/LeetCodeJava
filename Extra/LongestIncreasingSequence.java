package Extra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSequence {
    public int lengthOfLIS(int[] nums) {
        int maxcount = 1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 1));
            for (int key : map.keySet()) {
                if (key < nums[i]) {
                    int count = map.get(key);
                    if ((count + 1) > map.get(nums[i])) {
                        map.put(nums[i], count + 1);
                        if (maxcount < (count + 1)) {
                            maxcount = count + 1;
                        }
                    }
                }
            }
        }
        return maxcount;
    }

    public int lengthOfLISWithArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
