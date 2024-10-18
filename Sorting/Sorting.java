package Sorting;

public class Sorting {
    public int[] useSelectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tempIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[tempIndex] > arr[j]) {
                    tempIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[tempIndex];
            arr[tempIndex] = temp;
        }
        return arr;
    }

    public int[] useBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public int[] useInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] >= arr[i]) {
                j--;
            }

            for (; j <= i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

}
