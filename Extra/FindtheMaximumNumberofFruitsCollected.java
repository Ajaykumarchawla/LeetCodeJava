package Extra;
// 3363. Find the Maximum Number of Fruits Collected

// Solved
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// There is a game dungeon comprised of n x n rooms arranged in a grid.

// You are given a 2D array fruits of size n x n, where fruits[i][j] represents the number of fruits in the room (i, j). Three children will play in the game dungeon, with initial positions at the corner rooms (0, 0), (0, n - 1), and (n - 1, 0).

// The children will make exactly n - 1 moves according to the following rules to reach the room (n - 1, n - 1):

// The child starting from (0, 0) must move from their current room (i, j) to one of the rooms (i + 1, j + 1), (i + 1, j), and (i, j + 1) if the target room exists.
// The child starting from (0, n - 1) must move from their current room (i, j) to one of the rooms (i + 1, j - 1), (i + 1, j), and (i + 1, j + 1) if the target room exists.
// The child starting from (n - 1, 0) must move from their current room (i, j) to one of the rooms (i - 1, j + 1), (i, j + 1), and (i + 1, j + 1) if the target room exists.
// When a child enters a room, they will collect all the fruits there. If two or more children enter the same room, only one child will collect the fruits, and the room will be emptied after they leave.

// Return the maximum number of fruits the children can collect from the dungeon.

// Example 1:

// Input: fruits = [[1,2,3,4],[5,6,8,7],[9,10,11,12],[13,14,15,16]]

// Output: 100

// Explanation:

// In this example:

// The 1st child (green) moves on the path (0,0) -> (1,1) -> (2,2) -> (3, 3).
// The 2nd child (red) moves on the path (0,3) -> (1,2) -> (2,3) -> (3, 3).
// The 3rd child (blue) moves on the path (3,0) -> (3,1) -> (3,2) -> (3, 3).
// In total they collect 1 + 6 + 11 + 16 + 4 + 8 + 12 + 13 + 14 + 15 = 100 fruits.

// Example 2:

// Input: fruits = [[1,1],[1,1]]

// Output: 4

// Explanation:

// In this example:

// The 1st child moves on the path (0,0) -> (1,1).
// The 2nd child moves on the path (0,1) -> (1,1).
// The 3rd child moves on the path (1,0) -> (1,1).
// In total they collect 1 + 1 + 1 + 1 = 4 fruits.

// Constraints:

// 2 <= n == fruits.length == fruits[i].length <= 1000
// 0 <= fruits[i][j] <= 1000
public class FindtheMaximumNumberofFruitsCollected {
    public int maxCollectedFruits(int[][] fruits) {
        int total = 0;
        int n = fruits.length;
        for (int i = 0; i < n; i++) {
            total = total + fruits[i][i];
            fruits[i][i] = -1;
        }

        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (i < (n / 2) && j < (n - i - 1)) {
                    continue;
                }
                int max = 0;
                int newi = i + 1;
                if (newi < j) {
                    max = Math.max(max, fruits[newi][j]);
                }
                if (newi < j - 1) {
                    max = Math.max(max, fruits[newi][j - 1]);
                }
                if (newi < j + 1 & j < n - 1) {
                    max = Math.max(max, fruits[newi][j + 1]);
                }
                fruits[i][j] = max + fruits[i][j];
            }
        }

        for (int j = n - 3; j >= 0; j--) {
            for (int i = j + 1; i < n; i++) {
                if (j < (n / 2) && i < (n - j - 1)) {

                    continue;
                }
                int newj = j + 1;
                int max = 0;
                if (newj < i) {
                    max = Math.max(max, fruits[i][newj]);
                }
                if (newj < i - 1) {
                    max = Math.max(max, fruits[i - 1][newj]);
                }
                if (newj < i + 1 & i < n - 1) {
                    max = Math.max(max, fruits[i + 1][newj]);
                }
                fruits[i][j] = max + fruits[i][j];
            }
        }

        return total + fruits[0][n - 1] + fruits[n - 1][0];
    }
}

// Test cases:
// [[694, 656, 348, 135, 542, 39, 84], [863, 700, 818, 988, 540, 815, 925],
// [590, 426, 489, 732, 666, 303, 424], [492, 439, 362, 888, 459, 790, 574],
// [140, 473, 47, 737, 811, 655, 103], [846, 84, 121, 880, 176, 597, 783], [811,
// 173, 671, 477, 99, 794, 131]]
// [[417, 383, 532, 502, 77, 169, 669, 689], [568, 208, 559, 126, 570, 974, 242,
// 553], [203, 92, 79, 672, 667, 931, 507, 785], [38, 553, 766, 549, 508, 898,
// 940, 585], [35, 757, 967, 175, 610, 832, 284, 662], [401, 892, 287, 401, 954,
// 78, 426, 289], [513, 917, 95, 898, 469, 135, 249, 185], [749, 511, 573, 22,
// 29, 734, 424, 552]]
// [[138, 354], [588, 727]]
// [[1,2,3],[4,5,6],[7,8,9]]
// [[558, 406, 694, 897, 561, 758], [555, 927, 809, 99, 312, 605], [772, 981,
// 235, 865, 319, 310], [353, 951, 550, 762, 695, 11], [377, 910, 960, 407, 996,
// 890], [411, 477, 903, 821, 505, 661]]
// [[362, 707, 316, 679], [845, 798, 990, 197], [597, 356, 976, 30], [203, 135,
// 879, 331]]
// [[861, 182, 847], [730, 822, 85], [616, 306, 471]]
// [[314, 936], [318, 447]]