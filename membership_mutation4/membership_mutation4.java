// error injection: error occur when the value of key equals the last element in the array 

package membership_mutation4;
import sorting.sorting;
import binarysearch.binarysearch;

public class membership_mutation4 {
    public static boolean membership(int[] arr, int key) {
        boolean is_member;
        arr[arr.length - 1] = 0;
        sorting.bubbleSort((arr));
        int result = binarysearch.search(arr, key);
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
        int[] arr = {87, 65, 23, 25, 34, 45, 56, 67};
        int key = 67;
        System.out.println("Array:");
        printArray(arr);
        boolean is_member = membership(arr, key);
        System.out.print("Key: ");
        System.out.println(key);
        System.out.print("Member: ");
        System.out.println(is_member);
    }
}
