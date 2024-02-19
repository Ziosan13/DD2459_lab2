package sorting;

public class sorting {
    //@requires arr != null;
    //@ensure arr.length == \old(arr.length);
    //@ensure (\forall int i; 0 <= i && i < arr.length - 1; arr[i] <= arr[i + 1]);
    //@ensure (\forall int j; 0 <= j && j < arr.length);
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}