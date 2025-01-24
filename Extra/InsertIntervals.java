package Extra;
// 57. Insert Interval

// Solved
// Medium
// Topics
// Companies
// Hint
// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

// Return intervals after the insertion.

// Note that you don't need to modify intervals in-place. You can make a new array and return it.

// Example 1:

// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]
// Example 2:

// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

// Constraints:

// 0 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 105
// intervals is sorted by starti in ascending order.
// newInterval.length == 2
// 0 <= start <= end <= 105
public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }
        int start = newInterval[0];
        int end = newInterval[1];
        int i = 0;
        int j = intervals.length - 1;
        int left = 0, right = intervals.length;

        for (i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > start) {
                i--;
                left = i;
                break;
            }
        }
        if (i == intervals.length) {
            left = i - 1;
        }

        if (left >= 0 && intervals[left][1] >= start) {
            start = Math.min(intervals[left][0], newInterval[0]);
            left--;
        }

        for (i = left + 1; i < intervals.length; i++) {
            if (end < intervals[i][0]) {
                right = i;
                break;
            }
            if (end <= intervals[i][1]) {
                right = i + 1;
                end = Math.max(intervals[right - 1][1], end);
                break;
            }
        }
        System.out.println(left + " " + start + " " + right);

        int n = 1;
        if (left >= 0) {
            n = left + 1 + n;
        }
        if (intervals.length > right) {
            n = n + (intervals.length - right);
        }

        int[][] newIntervals = new int[n][2];
        for (i = 0; i <= left; i++) {
            newIntervals[i][0] = intervals[i][0];
            newIntervals[i][1] = intervals[i][1];

        }
        newIntervals[i][0] = start;
        newIntervals[i][1] = end;
        i++;

        for (int k = right; k < intervals.length; k++) {
            newIntervals[i][0] = intervals[k][0];
            newIntervals[i][1] = intervals[k][1];
            i++;
        }
        return newIntervals;
    }

}

// [[1,3],[6,9]]
// [2,5]
// [[1,3],[6,9]]
// [4,5]
// [[1,3],[6,9]]
// [4,6]
// [[1,2],[3,5],[6,7],[8,10],[12,16]]
// [4,8]
// [[3,5],[6,7],[8,10],[12,16]]
// [1,2]
// [[3,5],[6,7],[8,10],[12,16]]
// [1,3]
// [[3,5],[6,7],[8,10],[12,16]]
// [16,20]
// [[3,5],[6,7],[8,10],[12,16]]
// [17,20]