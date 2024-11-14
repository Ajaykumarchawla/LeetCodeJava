package Extra;

public class TrappingRainWater {
    // 42. Trapping Rain Water
    // Solved
    // Hard
    // Topics
    // Companies
    // Given n non-negative integers representing an elevation map where the width
    // of each bar is 1, compute how much water it can trap after raining.

    // Example 1:

    // Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    // Output: 6
    // Explanation: The above elevation map (black section) is represented by array
    // [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section)
    // are being trapped.
    // Example 2:

    // Input: height = [4,2,0,3,2,5]
    // Output: 9

    // Constraints:

    // n == height.length
    // 1 <= n <= 2 * 104
    // 0 <= height[i] <= 105
    public int trap(int[] height) {
        int i = 0;
        while (i < height.length && height[i] == 0) {
            i++;
        }

        int count = 0;
        while (i < height.length) {
            int j = i + 1;
            while (j < height.length && height[i] > height[j]) {
                j++;
            }

            if (j < height.length) {
                int k = j - 1;
                while (k > i) {
                    count = count + height[i] - height[k];
                    k--;
                }
                i = j;
            } else {
                if (height[i] == 0)
                    break;
                height[i] = height[i] - 1;
            }
        }
        return count;
    }
}
