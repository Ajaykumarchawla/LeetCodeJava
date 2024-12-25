package Extra;

import java.util.LinkedList;
import java.util.Queue;

// 542. 01 Matrix
// Solved
// Medium
// Topics
// Companies
// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

// The distance between two adjacent cells is 1.

// Example 1:

// Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
// Output: [[0,0,0],[0,1,0],[0,0,0]]
// Example 2:

// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]

// Constraints:

// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 104
// 1 <= m * n <= 104
// mat[i][j] is either 0 or 1.
// There is at least one 0 in mat.

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j });
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int i = 0, j = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            i = current[0];
            j = current[1];
            int[][] neighbour = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
            for (int k = 0; k < neighbour.length; k++) {
                int newI = i + neighbour[k][0];
                int newJ = j + neighbour[k][1];

                if (newI < 0 || newI >= mat.length || newJ < 0 || newJ >= mat[0].length || mat[newI][newJ] == 0) {
                    continue;
                }
                if ((mat[i][j] + 1) < mat[newI][newJ]) {

                    mat[newI][newJ] = mat[i][j] + 1;
                    queue.add(new int[] { newI, newJ });
                }

            }
        }
        return mat;
    }
}
