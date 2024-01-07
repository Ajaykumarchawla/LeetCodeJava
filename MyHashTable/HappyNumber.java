package MyHashTable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    Set<Integer> set = new HashSet<Integer>();

    public boolean isHappy(int n) {

        int newn;
        while (n != 1) {
            System.out.println(n);
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
            newn = 0;
            while (n != 0) {
                newn = newn + ((n % 10) * (n % 10));
                n = n / 10;
            }
            n = newn;
        }
        return true;
    }
}
