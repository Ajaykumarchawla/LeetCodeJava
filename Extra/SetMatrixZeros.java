package Extra;
// 73. Set Matrix Zeroes

// Solved
// Medium
// Topics
// Companies
// Hint
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.

// Example 1:

// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Example 2:

// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

// Constraints:

// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1

// Follow up:

// A straightforward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        boolean row = false;
        boolean column = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                row = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                column = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row == true) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (column == true) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;

            }

        }

    }
}
// test cases
// [[1,1,1],[1,0,1],[1,1,1]]
// [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// [[1],[0]]
// [[0,1,1],[1,1,1],[1,0,0]]
// [[-4,-2147483648,6,-7,0],[-8,6,-8,-6,0],[2147483647,2,-9,-6,-10]]
// [[2147483647],[2],[3]]
// [[1,2,3,4],[5,0,7,8],[0,10,11,12],[13,14,15,0]]