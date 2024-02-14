import searching.searching;

public class searching_test {
    public static void main(String[] args) {
        int[] arr = {14, 34, 25, 12, 22, 11, 90};
        int key = 25;
        System.out.println("Array:");
        printArray(arr);
        System.out.print("Key: ");
        System.out.println(key);

        int result = searching.search(arr, key);

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
