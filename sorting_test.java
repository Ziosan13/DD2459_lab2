import sorting.sorting;

public class sorting_test {

    public static void main(String[] args) {
        int[] arr = {14, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(arr);

        sorting.bubbleSort(arr);

        System.out.println("\nSorted array:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}