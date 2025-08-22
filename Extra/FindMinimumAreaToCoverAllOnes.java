package Extra;
// 3195. Find the Minimum Area to Cover All Ones I

// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given a 2D binary array grid. Find a rectangle with horizontal and vertical sides with the smallest area, such that all the 1's in grid lie inside this rectangle.

// Return the minimum possible area of the rectangle.

// Example 1:

// Input: grid = [[0,1,0],[1,0,1]]

// Output: 6

// Explanation:

// The smallest rectangle has a height of 2 and a width of 3, so it has an area of 2 * 3 = 6.

// Example 2:

// Input: grid = [[1,0],[0,0]]

// Output: 1

// Explanation:

// The smallest rectangle has both height and width 1, so its area is 1 * 1 = 1.

// Constraints:

// 1 <= grid.length, grid[i].length <= 1000
// grid[i][j] is either 0 or 1.
// The input is generated such that there is at least one 1 in grid.
public class FindMinimumAreaToCoverAllOnes {
    public int minimumArea(int[][] grid) {
        int top = 0, bottom = grid[0].length;
        int left = 0, right = grid.length;
        boolean found = false;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    top = i;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        found = false;
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    left = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        found = false;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    bottom = i + 1;
                    found = true;
                    break;
                }

            }
            if (found) {
                break;
            }
        }

        found = false;
        for (int j = grid[0].length - 1; j >= 0; j--) {
            for (int i = grid.length - 1; i >= 0; i--) {
                if (grid[i][j] == 1) {
                    right = j + 1;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        return (bottom - top) * (right - left);

    }
}

// Test Cases:
// [[0,1,0,0],[1,0,1,0],[0,0,0,0],[1,0,0,1]]
// [[1,1,1,1],[1,0,0,1],[1,0,0,1],[1,1,1,1]]
// [[0,0,0,0,0],[0,0,1,0,0],[0,0,0,0,0],[0,1,0,1,0],[0,0,0,0,0]]
// [[1,0,0],[0,0,0],[0,0,1]]
// [[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,1,0]]
// [[1,0,1,0,1],[0,1,0,1,0],[1,0,1,0,1],[0,1,0,1,0],[1,0,1,0,1]]
// [[0,0,0,1],[0,0,0,0],[0,1,0,0],[0,0,0,1]]
// [[1,1,0,0,1],[0,0,1,0,0],[1,0,0,1,0],[0,1,0,0,1],[1,0,1,0,1]]
