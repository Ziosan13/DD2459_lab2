import binarysearch.binarysearch;

public class binarysearch_test {
    public static void main(String[] args) {
        int[] arr = {12, 23, 25, 34, 45, 56, 67};
        int key = 25;
        System.out.println("Array:");
        printArray(arr);
        System.out.print("Key: ");
        System.out.println(key);

        int result = binarysearch.search(arr, key);

        System.out.print("Result: ");
        System.out.println(result);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
