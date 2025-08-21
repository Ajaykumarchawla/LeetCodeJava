package Extra;

// 168. Excel Sheet Column Title
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

// For example:

// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28 
// ...

// Example 1:

// Input: columnNumber = 1
// Output: "A"
// Example 2:

// Input: columnNumber = 28
// Output: "AB"
// Example 3:

// Input: columnNumber = 701
// Output: "ZY"

// Constraints:

// 1 <= columnNumber <= 231 - 1
public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuffer s = new StringBuffer();
        int point = 0;
        while (columnNumber > 0) {
            if (columnNumber % 26 == 0) {
                s.append('Z');
                point = 1;
            } else {
                s.append((char) ('A' + columnNumber % 26 - 1));
                point = 0;
            }
            columnNumber = columnNumber / 26 - point;
        }

        return s.reverse().toString();

    }

    String s = "";

    public String convertToTitleRecursively(int columnNumber) {
        columnNumber--;
        if (columnNumber < 26) {
            s = s + (char) ('A' + columnNumber);
        } else if (columnNumber / 26 == 0 && columnNumber % 26 == 0) {
            s = s + 'Z';
        } else {
            convertToTitle(columnNumber / 26);
            s = s + (char) ('A' + columnNumber % 26);
        }
        return s;
    }
}

// Test Cases:
// 68593729
// 701
// 26
// 1
// 702
// 703
// 27395017
// 2840673
