package BasicRecursion;

public class BasicRecursion {
    public void printNumnber(int num) {
        if (num == 1) {
            System.out.print(num + " ");
        } else {
            this.printNumnber(num - 1);
            System.out.print(num + " ");
        }
    }

    public void printReverseNumnber(int num) {
        if (num == 1) {
            System.out.print(num + " ");
        } else {
            System.out.print(num + " ");
            this.printReverseNumnber(num - 1);
        }
    }

    public int sumFirstNumbers(int num) {
        if (num == 1)
            return 1;
        else
            return num + sumFirstNumbers(num - 1);
    }

    public int getFactorial(int num) {
        if (num == 1)
            return 1;
        else
            return num * getFactorial(num - 1);
    }

    public int[] reverseArray(int[] l1, int start, int end) {
        if (start > end) {
            return l1;
        }
        int temp = l1[start];
        l1[start] = l1[end];
        l1[end] = temp;
        return this.reverseArray(l1, start + 1, end - 1);
    }

    public boolean checkPalindrome(int i, String s) {
        if (i > s.length() / 2) {
            return true;
        }
        if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
            return checkPalindrome(i + 1, s);
        } else {
            return false;
        }
    }

    public void printFibonacci(int n) {

        for (int i = 0; i <= n; i++) {
            System.out.print(getFibonacci(i) + " ");
        }

    }

    private int getFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            int value = getFibonacci(n - 1) + getFibonacci(n - 2);
            return value;
        }
    }

}
