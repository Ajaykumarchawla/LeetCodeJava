package Array101;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        int[] max = new int[3];
        int count = 0;
        for (int i = 0; i < nums.length && count < 3; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            System.out.println(nums[i]);

            int newNum = nums[i];
            int trigger = 1;
            for (int k = 0; k < count; k++) {
                if (max[k] == newNum) {
                    trigger = 0;
                    break;
                }
                if (max[k] < newNum) {
                    int temp = max[i];
                    max[i] = newNum;
                    newNum = temp;
                }
            }
            if (trigger == 1 && count < 3) {
                max[count] = newNum;
                count++;
            }
        }

        if (count == 3) {
            return max[2];
        }
        return max[0];
    }
}