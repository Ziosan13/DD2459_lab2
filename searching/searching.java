package searching;

public class searching {
    //@ requires arr != null && \typeof(arr) == \type(int[]) && arr.length > 0;
    //@ requires \type(key) == \type(int);
    //@ ensures arr == \old(arr);
    //@ ensures (\exists int i; i >= 0 && i < arr.length; arr[i] == key) ==> \result == i;
    //@ exsures !(\exists int i; i >= 0 && i < arr.length; arr[i] == key) ==> \result == -1;
    public static int search(int[] arr, int key) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
