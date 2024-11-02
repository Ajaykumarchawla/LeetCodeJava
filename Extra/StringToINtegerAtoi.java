package Extra;

public class StringToINtegerAtoi {
    public int myAtoi(String s) {

        if (s.length() == 0) {
            return 0;
        }
        int i = 0, negative = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (s.length() == i) {
            return 0;
        }
        if (s.charAt(i) == '-') {
            negative = 1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        int j = i;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                continue;
            } else {
                break;
            }
        }

        while (j < i && s.charAt(j) == '0') {
            j++;
        }
        int num = 0;
        if (i - j > 10) {
            if (negative == 1) {
                return -2147483648;
            } else {
                return 2147483647;
            }
        }
        int count = 0;
        while (j < i && count < 9) {
            int temp = s.charAt(j) - '0';
            num = num * 10 + temp;

            j++;
            count++;
        }
        if (count <= 9 && i - j > 0) {
            if (num > (214748364)) {
                if (negative == 0) {
                    return 2147483647;

                } else {
                    return (-2147483648);
                }
            } else if (num == (214748364)) {
                if (negative == 1) {
                    if (s.charAt(j) < '8') {
                        return (-1) * (num * 10 + (s.charAt(j) - '0'));
                    } else {
                        return (-2147483648);
                    }
                } else {

                    if (s.charAt(j) < '7')
                        return (num * 10 + (s.charAt(j) - '0'));
                    else {
                        return (2147483647);
                    }
                }
            } else {
                if (negative == 1) {
                    return (-1) * (num * 10 + (s.charAt(j) - '0'));
                } else {
                    return (num * 10 + (s.charAt(j) - '0'));
                }
            }
        }
        if (negative == 1) {
            return num * -1;
        }
        return num;

    }
}
