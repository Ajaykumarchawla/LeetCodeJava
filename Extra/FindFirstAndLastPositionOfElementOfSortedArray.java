package Extra;

public class FindFirstAndLastPositionOfElementOfSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int lower = -1, k = 0, upper = -1;
        while (i <= j) {
            k = (i + j) / 2;
            if (nums[k] == target) {
                while (k >= 0 && nums[k] == target) {
                    k--;
                }
                lower = k + 1;
                k++;
                while (k < nums.length && nums[k] == target) {
                    k++;
                }
                upper = k - 1;
                break;

            } else if (nums[k] > target) {
                j = k - 1;
            } else {
                i = k + 1;
            }
        }
        return new int[] { lower, upper };
    }
}
