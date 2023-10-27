package Array101;
// Given an array of integers arr, return true if and only if it is a valid mountain array.

// Recall that arr is a mountain array if and only if:

// arr.length >= 3
// There exists some i with 0 < i < arr.length - 1 such that:
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

// Example 1:

// Input: arr = [2,1]
// Output: false
// Example 2:

// Input: arr = [3,5,5]
// Output: false
// Example 3:

// Input: arr = [0,3,2,1]
// Output: true
public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int i = 0;
        int value = arr[i];
        i++;
        while (i < arr.length && value < arr[i]) {
            value = arr[i];
            i++;
        }
        if (i == 1 || i == arr.length) {
            return false;
        }
        while (i < arr.length && value > arr[i]) {
            value = arr[i];
            i++;
        }
        if (i == arr.length) {
            return true;
        }
        return false;
    }
}
