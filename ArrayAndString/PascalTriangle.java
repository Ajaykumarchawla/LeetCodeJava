package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

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
