package membership;

public class membership {
    //@ requires arr != null && \typeof(arr) == \type(int[]) && arr.length > 0;
    //@ requires \type(key) == \type(int);
    //@ ensures arr == \old(arr);
    //@ ensures (\exists int i; i >= 0 && i < arr.length; arr[i] == key) ==> \result == true;
    //@ exsures !(\exists int i; i >= 0 && i < arr.length; arr[i] == key) ==> \result == false;
    public static boolean is_member(int[] arr, int key) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                return true;
            }
        }
        return false;
    }
}
