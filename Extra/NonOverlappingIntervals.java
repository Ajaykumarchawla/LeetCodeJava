package Extra;

import java.util.Arrays;
// 435. Non-overlapping Intervals
// Solved
// Medium
// Topics
// Companies
// Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

// Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.

// Example 1:

// Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
// Output: 1
// Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
// Example 2:

// Input: intervals = [[1,2],[1,2],[1,2]]
// Output: 2
// Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
// Example 3:

// Input: intervals = [[1,2],[2,3]]
// Output: 0
// Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

// Constraints:

// 1 <= intervals.length <= 105
// intervals[i].length == 2
// -5 * 104 <= starti < endi <= 5 * 104
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int k = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[k][1] <= intervals[i][0]) {
                k = i;
            } else if (intervals[k][1] < intervals[i][1]) {
                count++;
            } else {
                k = i;
                count++;
            }
        }
        return count;
    }
}
// test cases:

// [[1,2],[2,3],[3,4],[1,3]]
// [[1,2],[1,2],[1,2]]
// [[1,2],[2,3]]
// [[-73,-26],[-65,-11],[-62,-49]]
// [[1,100],[11,22],[1,11],[2,12]]
// [[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]
// [[-100,-87],[-90,-44],[-86,7],[-85,-76],[-70,33]]