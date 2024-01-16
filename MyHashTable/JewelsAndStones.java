package MyHashTable;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<Character>();

        for (Character i : jewels.toCharArray()) {
            set.add(i);
        }
        int count = 0;
        for (Character i : stones.toCharArray()) {
            if (set.contains(i)) {
                count++;
            }
        }
        return count;

    }
}
