package Extra;

// 171. Excel Sheet Column Number
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

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

// Input: columnTitle = "A"
// Output: 1
// Example 2:

// Input: columnTitle = "AB"
// Output: 28
// Example 3:

// Input: columnTitle = "ZY"
// Output: 701

// Constraints:

// 1 <= columnTitle.length <= 7
// columnTitle consists only of uppercase English letters.
// columnTitle is in the range ["A", "FXSHRXW"].

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int count = 0;
        int pov = 1;

        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            char c = columnTitle.charAt(i);
            count = count + ((int) c - 64) * pov;
            pov = pov * 26;
        }
        return count;
    }
}
// Test Cases:
// "A"
// "FXSHRXW"
// "ZY"
// "ACADAA"
// "ZAZY"
// "ZY"
// "ZYACZQ"
// "FAANGZ"
