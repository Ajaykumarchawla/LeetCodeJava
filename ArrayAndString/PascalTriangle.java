package ArrayAndString;

import java.util.ArrayList;
import java.util.List;
// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

// Example 1:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2:

// Input: numRows = 1
// Output: [[1]]

// Constraints:

// 1 <= numRows <= 30
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> l1 = new ArrayList<>();
        List<Integer> tempList;
        tempList = new ArrayList<Integer>();
        tempList.add(1);
        l1.add(tempList);
        for (int i = 1; i < numRows; i++) {
            tempList = new ArrayList<Integer>();
            tempList.add(1);

            for (int j = 1; j < i; j++) {
                List<Integer> newPointer = l1.get(i - 1);
                tempList.add(newPointer.get(j - 1) + newPointer.get(j));
            }
            tempList.add(1);
            l1.add(tempList);
        }
        return l1;
    }
}
