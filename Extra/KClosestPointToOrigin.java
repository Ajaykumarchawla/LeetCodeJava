package Extra;
// 973. K Closest Points to Origin

import java.util.PriorityQueue;

// Solved
// Medium
// Topics
// Companies
// Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

// The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

// You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

// Example 1:

// Input: points = [[1,3],[-2,2]], k = 1
// Output: [[-2,2]]
// Explanation:
// The distance between (1, 3) and the origin is sqrt(10).
// The distance between (-2, 2) and the origin is sqrt(8).
// Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
// We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
// Example 2:

// Input: points = [[3,3],[5,-1],[-2,4]], k = 2
// Output: [[3,3],[-2,4]]
// Explanation: The answer [[-2,4],[3,3]] would also be accepted.

// Constraints:

// 1 <= k <= points.length <= 104
// -104 <= xi, yi <= 104
class Struct1 {
    int x;
    int y;
    double d;

    public Struct1(int x, int y, double d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class KClosestPointToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Struct1> minHeap = new PriorityQueue<>(k, (Struct1 a, Struct1 b) -> Double.compare(b.d, a.d));

        for (int i = 0; i < points.length; i++) {
            double d = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            Struct1 point = new Struct1(points[i][0], points[i][1], d);
            if (minHeap.size() < k) {
                minHeap.add(point);

            } else if (point.d < minHeap.peek().d) {
                minHeap.poll();
                minHeap.add(point);
            }
        }
        int[][] returnArray = new int[k][2];
        int size = minHeap.size();
        for (int i = 0; i < size; i++) {
            Struct1 point = minHeap.poll();
            returnArray[i][0] = point.x;
            returnArray[i][1] = point.y;
        }

        return returnArray;

    }
}
