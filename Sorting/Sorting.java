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
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.err.println();
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

    private void mergeArray(int[] arr, int low, int med, int high) {
        int[] tempArr = new int[high - low + 1];
        int tempLow = low, tempMed = med + 1;

        int i = 0;
        while (tempLow <= med && tempMed <= high) {
            if (arr[tempLow] < arr[tempMed]) {
                tempArr[i] = arr[tempLow];
                tempLow++;
            } else {
                tempArr[i] = arr[tempMed];
                tempMed++;
            }
            i++;
        }
        while (tempLow <= med) {
            tempArr[i] = arr[tempLow];
            tempLow++;

            i++;
        }
        while (tempMed <= high) {
            tempArr[i] = arr[tempMed];
            tempMed++;

            i++;
        }
        tempLow = low;
        for (i = 0; i < (high - low + 1); i++) {
            arr[tempLow] = tempArr[i];
            tempLow++;
        }
    }

    public void useMergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        } else {
            int med = ((high - low) / 2) + low;
            useMergeSort(arr, low, med);
            useMergeSort(arr, med + 1, high);
            mergeArray(arr, low, med, high);
        }

    }

    public void useRecursiveBubbleSort(int[] arr, int n) {
        if (n == 1) {
            return;
        } else {
            int didSwap = 0;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    didSwap = 1;
                }
            }
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.err.println();
            if (didSwap == 0)
                return;
            useRecursiveBubbleSort(arr, n - 1);
        }
    }

    public void useRecursiveInsertionSort(int[] arr, int i, int n) {
        if (i == n) {
            return;
        } else {

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
            useRecursiveInsertionSort(arr, i + 1, n);
        }
    }

    public void useQuickSort(int[] arr, int i, int n) {
        if (i >= n) {
            return;
        } else {
            int pivot = arr[n], low = i, high = n - 1;
            while (low <= high) {
                if (arr[low] > pivot) {
                    int temp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = temp;
                    high--;

                } else
                    low++;
            }
            if (arr[low] > pivot) {
                arr[n] = arr[low];
                arr[low] = pivot;
            }

            useQuickSort(arr, i, low - 1);
            useQuickSort(arr, high + 1, n);

        }
    }
}
