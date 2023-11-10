package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> l1 = new ArrayList<Integer>();

        int initial = 1, jinitial = 0, count = 0;
        int i = 0, j = 0, direction = 0;

        int length = m * n;
        n--;
        m--;
        while (count < length) {
            l1.add(matrix[i][j]);
            switch (direction % 4) {
                case 0: // left to right;
                    j++;
                    if (j > n) {
                        direction++;
                        System.out.println();
                        j = n;
                        n--;
                        i++;
                    }
                    break;
                case 1: // up to down;
                    i++;
                    if (i > m) {
                        direction++;
                        System.out.println();
                        i = m;
                        m--;
                        j--;
                    }
                    break;
                case 2: // right to left;
                    j--;
                    if (j < jinitial) {
                        direction++;
                        System.out.println();
                        j = jinitial;
                        jinitial++;
                        i--;
                    }
                    break;
                case 3: // down to up;
                    i--;
                    if (i < initial) {
                        direction++;
                        i = initial;
                        initial++;
                        j++;
                    }
                    break;
            }

            count++;

        }
        return l1;
    }
}
