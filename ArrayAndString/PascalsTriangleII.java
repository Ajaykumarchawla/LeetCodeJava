package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

// Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

// Example 1:

// Input: rowIndex = 3
// Output: [1,3,3,1]
// Example 2:

// Input: rowIndex = 0
// Output: [1]
// Example 3:

// Input: rowIndex = 1
// Output: [1,1]

// Constraints:

// 0 <= rowIndex <= 33

// Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> array = new ArrayList<Integer>();

        array.add(1);
        if (rowIndex == 0) {
            return array;
        }
        int i = 1, j = 1;
        while (i <= rowIndex) {
            int previous = 1, current;
            j = 1;
            if (i % 2 == 0) {
                array.add(array.get((i / 2) - 1) * 2);
            }
            while (j < i / 2 + (i % 2)) {
                current = array.get(j);
                array.set(j, current + previous);
                previous = current;
                j++;
            }
            i++;
        }
        j--;
        while (j >= 0) {
            array.add(array.get(j));
            j--;
        }
        return array;
    }
}
