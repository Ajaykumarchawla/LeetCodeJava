package ArrayAndString;
// Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

// Example 1:

// Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,4,7,5,3,6,8,9]
// Example 2:

// Input: mat = [[1,2],[3,4]]
// Output: [1,2,3,4]
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        int[] newArray = new int[m * n];

        int row = 0;
        int column = 0;
        int direction = 0;
        int r = 0;
        int c = 0;
        while (row + column <= (m + n - 2)) {
            if (direction % 2 == 0) {
                while (c < n && r >= 0) {
                    newArray[count] = mat[r][c];
                    r--;
                    c++;
                    count++;
                }
                r++;
                c--;
                if (column < n) {
                    column++;

                }
                if (c < n - 1) {
                    c++;
                } else {
                    r++;
                }

                direction = 1;
            } else {
                while (r < m && c >= 0) {
                    newArray[count] = mat[r][c];
                    r++;
                    c--;
                    count++;
                }
                r--;
                c++;
                if (row < m) {
                    row++;
                }
                if (r < m - 1) {
                    r++;
                } else {
                    c++;
                }
                direction++;
            }
        }
        return newArray;
    }
}
