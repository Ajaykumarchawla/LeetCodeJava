package ArrayAndString;
// Given two binary strings a and b, return their sum as a binary string.

// Example 1:

// Input: a = "11", b = "1"
// Output: "100"
// Example 2:

// Input: a = "1010", b = "1011"
// Output: "10101"

// Constraints:

// 1 <= a.length, b.length <= 104
// a and b consist only of '0' or '1' characters.
// Each string does not contain leading zeros except for the zero itself.
public class AddBinary {
    public String addBinary(String a, String b) {
        char carryOut = '0';
        String sum = "";
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 && j >= 0) {
            String total = "";
            total = total + carryOut + aChar[i] + bChar[j];
            System.out.println(i + " " + total);

            if (total.equals("011") || total.equals("101") || total.equals("110")) {
                sum = "0" + sum;
                carryOut = '1';
            } else if (total.equals("001") || total.equals("010") || total.equals("100")) {
                sum = "1" + sum;
                carryOut = '0';
            } else if (total.equals("000")) {
                sum = "0" + sum;
                carryOut = '0';
            } else {
                sum = "1" + sum;
                carryOut = '1';
            }
            i--;
            j--;
        }
        if (i >= 0) {
            while (i >= 0) {
                if (carryOut == '1' && aChar[i] == '1') {
                    sum = "0" + sum;
                } else if (carryOut == '1' && aChar[i] == '0') {
                    sum = "1" + sum;
                    carryOut = '0';
                } else {
                    sum = aChar[i] + sum;
                }
                i--;
            }
        }
        if (j >= 0) {
            while (j >= 0) {
                if (carryOut == '1' && bChar[j] == '1') {
                    sum = "0" + sum;
                } else if (carryOut == '1' && bChar[j] == '0') {
                    sum = "1" + sum;
                    carryOut = '0';
                } else {
                    sum = bChar[j] + sum;
                }
                j--;
            }
        }
        if (carryOut == '1') {
            sum = "1" + sum;
        }

        return sum;
    }
}