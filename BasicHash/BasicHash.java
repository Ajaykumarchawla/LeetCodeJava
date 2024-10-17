package BasicHash;

import java.util.HashMap;
import java.util.Map;

public class BasicHash {

    public void printHightLowFrequenceyElement(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map1.get(nums[i]) == null) {
                map1.put(nums[i], 1);
            } else {
                map1.put(nums[i], map1.get(nums[i]) + 1);
            }
        }

        int maxKey = 0, max = 0, minKey = 0, min = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxKey = entry.getKey();
            }

            if (entry.getValue() < min || min == 0) {
                min = entry.getValue();
                minKey = entry.getKey();
            }
        }
        System.out.println(maxKey + " " + minKey);

    }

}
