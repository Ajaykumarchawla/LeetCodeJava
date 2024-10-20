
package ATOZ;

public class ArrayProblems {
    public void reverseArray(int[] arr, int start, int end) {
        int temp = 0;

        while (start <= end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void RotateToLeft(int[] arr, int k) {
        k = k % arr.length;
        reverseArray(arr, 0, k - 1);

        reverseArray(arr, k, arr.length - 1);

        reverseArray(arr, 0, arr.length - 1);
    }
}