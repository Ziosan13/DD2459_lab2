import java.util.Random;
import membership_mutation1.membership_mutation1;
import membership_unsorted.membership_unsorted;



public class test_example {
    private static final int ARR_LENGTH = 7;
    private static final int TEST_CASES = 10;

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // generate test suite
        Random random = new Random();
        int[][] test_arrs = new int[TEST_CASES][ARR_LENGTH];
        int[] test_keys = new int[TEST_CASES];
        int[] result = new int[TEST_CASES];
        int[] arr = new int[ARR_LENGTH];
        for (int i = 0; i < TEST_CASES; i++) {
            for (int j = 0; j < ARR_LENGTH; j++) {
                arr[j] = random.nextInt(100);
            }
            test_arrs[i] = arr;
            arr = new int[ARR_LENGTH];
        }
        for (int i = 0; i < TEST_CASES; i++) {
            test_keys[i] = test_arrs[i][random.nextInt(10)];
        }

        for (int i = 0; i < TEST_CASES; i++) {
            boolean is_member = membership_mutation1.membership(test_arrs[i], test_keys[i]);
            boolean is_member_correct = membership_unsorted.membership(test_arrs[i], test_keys[i]);
            if (is_member == is_member_correct) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }

        printArray(result);
    }
}
