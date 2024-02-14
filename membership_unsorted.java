import sorting.sorting;
import binarysearch.binarysearch;

public class membership_unsorted {
    public static void main(String[] args) {
        boolean is_member;
        int[] arr = {78, 67, 56, 45, 35, 25, 13, 46, 47};
        int key = 25;
        System.out.println("Array:");
        printArray(arr);
        System.out.print("Key: ");
        System.out.println(key);

        sorting.bubbleSort((arr));
        int result = binarysearch.search(arr, key);
        if (result == -1) {
            is_member = false;
        } else {
            is_member = true;
        }
        

        System.out.print("Member: ");
        System.out.println(is_member);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
