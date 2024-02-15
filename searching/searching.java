package searching;

public class searching {
    //@ requires arr != null;
    //@ ensures arr == \old(arr);
    //@ ensures (\result >= 0) ==> (\exists int i; i >= 0 && i < arr.length; arr[i] == \result);
    //@ ensures (\result == -1) ==> !(\exists int i; i >= 0 && i < arr.length; arr[i] == key);
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
