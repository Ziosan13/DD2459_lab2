// error injection: error occur when value of key is not smaller than the largest member in the array

package membership_mutation3;
import sorting.sorting;
import binarysearch_error2.binarysearch_error2;

public class membership_mutation3 {
    public static boolean membership(int[] arr, int key) {
        boolean is_member;
        arr = sorting.bubbleSort((arr));
        int result = binarysearch_error2.search(arr, key);
        if (result == -1) {
            is_member = false;
        } else {
            is_member = true;
        }
        return is_member;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {87, 65, 25, 34, 45, 56, 67};
        int key = 87;
        System.out.println("Array:");
        printArray(arr);
        boolean is_member = membership(arr, key);
        System.out.print("Key: ");
        System.out.println(key);
        System.out.print("Member: ");
        System.out.println(is_member);
    }
}
