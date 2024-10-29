package ATOZ;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int k;

        while (i <= j) {
            k = (i + j) / 2;
            if (nums[k] == target) {
                return k;
            }
            if (nums[k] > target) {
                j = k - 1;
            } else {
                i = k + 1;
            }
        }
        return -1;
    }
}
