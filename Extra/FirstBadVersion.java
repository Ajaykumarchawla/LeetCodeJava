package Extra;

// 278. First Bad Version
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

// You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

// Example 1:

// Input: n = 5, bad = 4
// Output: 4
// Explanation:
// call isBadVersion(3) -> false
// call isBadVersion(5) -> true
// call isBadVersion(4) -> true
// Then 4 is the first bad version.
// Example 2:

// Input: n = 1, bad = 1
// Output: 1

// Constraints:

// 1 <= bad <= n <= 231 - 1

public class FirstBadVersion {
    public int firstBadVersion(int m) {
        long i = 0;
        long n = m;
        while (i < n) {

            long current = (i + n) / 2 + (i + n) % 2;
            if (isBadVersion((int) current)) {
                n = current - 1;
            } else {
                i = current;
            }
        }
        return (int) i + 1;
    }

    private boolean isBadVersion(int version) {
        // This is a placeholder for the actual implementation.
        // In a real scenario, this method would be provided.
        return false;
    }
}

// Test Cases:
// 1
// 1
// 7
// 4
// 7
// 5
// 7
// 6
// 7
// 1
// 7
// 7
// 7
// 2
// 2126753390
// 1702766719