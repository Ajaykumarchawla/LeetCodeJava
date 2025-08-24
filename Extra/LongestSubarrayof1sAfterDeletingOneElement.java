package Extra;

public class LongestSubarrayof1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int max = 0;
        int count = 0;
        boolean hasZero = false;
        while (i < nums.length) {
            if (nums[i] == 0) {
                hasZero = true;
                i++;
                int tempCount = 0;
                while (i < nums.length && nums[i] == 1) {
                    tempCount++;
                    i++;
                }
                if (max < (count + tempCount)) {
                    max = count + tempCount;
                }
                count = tempCount;
                continue;
            }
            count++;
            i++;
        }

        if (hasZero) {
            return max;
        } else {
            return count - 1;
        }
    }
}

// Test Cases:
// [1,1,0,0,1,0,1,1,1,1]
// [1,1,0,0,1,0,0,1,1,1,1]
// [0,0,0,0,1]
// [0]
// [1,1,1,1,1]
// [1,1,1,1,0,0,0,0]
// [1,0,1,0,1,0,1,0]
