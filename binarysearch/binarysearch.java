package binarysearch;

public class binarysearch {
    //@ requires arr != null && \typeof(arr) == \type(int[]) && arr.length > 0;
    //@ requires (\forall int i; 0 <= i && i < arr.length - 1; arr[i] <= arr[i + 1]);
    //@ requires \type(key) == \type(int);
    //@ ensures arr == \old(arr);
    //@ ensures (\exists int i; i >= 0 && i < arr.length; arr[i] == key) ==> \result == i;
    //@ exsures !(\exists int i; i >= 0 && i < arr.length; arr[i] == key) ==> \result == -1;
    public static int search(int[] arr, int key) {
        int x;
        int i = 1;
        int n = arr.length;
        while (true) {
            x = (i + n) / 2;
            if (key < arr[x]) {
                n = x - 1;
            } else {
                i = x + 1;
            }
            if (arr[x] == key || i > n) {
                break;
            }
        }
        if (arr[x] == key) {
            return x;
        }
        return -1;
    }
}
