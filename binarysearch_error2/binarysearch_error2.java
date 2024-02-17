package binarysearch_error2;

public class binarysearch_error2 {
    public static int search(int[] arr, int key) {
        int x;
        int i = 0;
        int n = arr.length;
        while (true) {
            // x = (i + n) / 2;
            x = (i + n) / 2 - 1;
            if (key < arr[x]) {
                n = x - 1;
            } else {
                i = x + 1;
            }
            if (arr[x] == key || i >= n) {
                break;
            }
        }
        if (arr[x] == key) {
            return x;
        }
        return -1;
    }
}
