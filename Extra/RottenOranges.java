package Extra;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// 994. Rotting Oranges
// Solved
// Medium
// Topics
// Companies
// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

// Example 1:

// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:

// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:

// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.
public class RottenOranges {
    class Pair {
        int i = 0;
        int j = 0;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public boolean equals(int i, int j) {
            if (this.i == i && this.j == j) {
                return true;
            } else {
                return false;
            }
        }
    }

    public int orangesRotting(int[][] grid) {
        int count = 0;

        Queue<Pair> queue1 = new LinkedList<>();
        List<Pair> queue2 = new LinkedList<>();
        Queue<Pair> queue3 = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    Pair pair = new Pair(i, j);
                    queue2.add(pair);
                } else if (grid[i][j] == 2) {
                    Pair pair = new Pair(i, j);
                    queue1.add(pair);
                }
            }
        }

        while (!queue1.isEmpty()) {
            int flag = 0;
            while (!queue1.isEmpty()) {
                Pair rotten = queue1.remove();
                for (int i = 0; i < queue2.size(); i++) {
                    flag = 1;
                    Pair p = queue2.get(i);
                    if (p.equals(rotten.i - 1, rotten.j)) {
                        queue3.add(p);
                        queue2.remove(p);
                        i--;
                        // System.out.println("this worked 1");
                    }
                    if (p.equals(rotten.i + 1, rotten.j)) {
                        queue3.add(p);
                        queue2.remove(p);
                        i--;

                        // System.out.println("this worked 1");
                    }
                    if (p.equals(rotten.i, rotten.j + 1)) {
                        queue3.add(p);
                        queue2.remove(p);
                        // System.out.println("this worked 2");
                        i--;

                    }
                    if (p.equals(rotten.i, rotten.j - 1)) {
                        queue3.add(p);
                        queue2.remove(p);
                        // System.out.println("this worked 2");
                        i--;

                    }
                    // System.out.println(queue1 +" "+queue2+" "+queue3);

                }
            }
            if (flag == 1) {
                count++;
            }
            if (queue2.isEmpty()) {
                break;
            }
            queue1 = queue3;
            queue3 = new LinkedList<>();
        }
        if (queue2.isEmpty()) {
            return count;
        }

        return -1;

    }
}
