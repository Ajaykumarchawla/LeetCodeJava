package BasicMath;

import java.util.ArrayList;
import java.util.List;

public class BasicMath {
    public int findGCD(int N1, int N2) {
        int min = Math.min(N1, N2);

        for (; min > 1; min--) {
            if (N1 % min == 0 && N2 % min == 0) {
                return min;
            }
        }
        return 1;
    }

    public int findRerusiveGCD(int N1, int N2) {
        if (N1 == 0) {
            return N2;
        }
        if (N2 == 0) {
            return N1;
        }
        if (N1 > N2) {
            return this.findRerusiveGCD(N1 - N2, N2);
        } else {
            return this.findRerusiveGCD(N1, N2 - N1);
        }
    }

    public boolean checkArmstrongNumber(int num) {
        int sum = 0;
        int tempNum = num;
        int k = String.valueOf(num).length();
        while (num > 0) {
            int temp = num % 10;
            int powersum = temp;
            for (int i = 1; i < k; i++) {
                powersum = powersum * temp;
            }
            sum = sum + powersum;
            num = num / 10;
        }
        if (sum == tempNum) {
            return true;
        }
        return false;
    }

    public List<Integer> getAllDivisors(int num) {

        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        int end = num;
        for (int i = 1; i < end; i++) {
            if (num % i == 0) {
                list.add(i);
                if (i != (num / i)) {
                    list2.add(num / i);
                }
                end = num / i;
            }
        }
        while (!list2.isEmpty()) {
            list.add(list2.removeLast());
        }
        return list;
    }

    public boolean checkPrime(int num) {

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;

    }

}
