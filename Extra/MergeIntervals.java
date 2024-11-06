package Extra;
// 56. Merge Intervals

import java.util.Arrays;

// Solved
// Medium
// Topics
// Companies
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.

// Constraints:

// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        int count = 0;

        for (int i = 0; i < intervals.length;) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            i++;
            while (i < intervals.length && end >= intervals[i][0]) {
                if (end < intervals[i][1])
                    end = intervals[i][1];
                i++;
            }
            intervals[count][0] = start;
            intervals[count][1] = end;
            count++;
        }
        int[][] mergedIntervals = new int[count][2];
        for (int i = 0; i < count; i++) {
            mergedIntervals[i] = intervals[i];
        }
        return mergedIntervals;
    }
}
