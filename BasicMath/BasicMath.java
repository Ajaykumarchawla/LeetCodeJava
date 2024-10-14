package BasicMath;

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

}
