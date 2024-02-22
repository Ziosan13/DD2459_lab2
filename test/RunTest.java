package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import membership.membership;
import membership_mutation1.membership_mutation1;
import membership_mutation2.membership_mutation2;
import membership_mutation3.membership_mutation3;
import membership_mutation4.membership_mutation4;
import membership_mutation5.membership_mutation5;
import membership_mutation6.membership_mutation6;

public class RunTest {
    private static int min = -50;
    private static int max = 50;

    public static int[] readInput(Scanner scanner) throws IOException {
		int length = scanner.nextInt();
    	int[] A = new int[length];
    	for(int i = 0; i < length; i++){
    		A[i] = scanner.nextInt();
    	}
    	return A;
    }

    public static ArrayList<PairwiseTest> readSerialized(String filename) {
        ArrayList<PairwiseTest> testSuite = null;
        try (FileInputStream in = new FileInputStream(filename);
            ObjectInputStream s = new ObjectInputStream(in)) {
            testSuite = (ArrayList<PairwiseTest>) s.readObject();
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
        e.printStackTrace();
        }
        return testSuite;
    }
  public static ArrayList<RandomTest> readRandomSerialized(String filename) {
        ArrayList<RandomTest> testSuite = null;
        try (FileInputStream in = new FileInputStream(filename);
            ObjectInputStream s = new ObjectInputStream(in)) {
            testSuite = (ArrayList<RandomTest>) s.readObject();
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
        e.printStackTrace();
        }
        return testSuite;
    }

    public static void runRandomTests() throws IOException {

        ArrayList<RandomTest> testsuit = readRandomSerialized("testFiles/randomTestResult.txt");

        boolean first = true;
        int counter = 1;
        int amount = 0;
        int errorTracker = 1;
        int key;
        for(RandomTest test : testsuit) {
            System.out.println(errorTracker++);
            int[] A = test.arr;
            key = min + (int)(Math.random() * ((max - min) + 1));
            boolean correctRes = membership.is_member(A, key);
            boolean mutationRes = membership_mutation1.membership(A, key);
            // boolean mutationRes = membership_mutation2.membership(A, key);
            // boolean mutationRes = membership_mutation3.membership(A, key);
            // boolean mutationRes = membership_mutation4.membership(A, key);
            // boolean mutationRes = membership_mutation5.membership(A, key);
            // boolean mutationRes = membership_mutation6.membership(A, key);

            if(correctRes != mutationRes) {
                if(first) {
                    System.out.println("the first erro happens: " + counter);
                    first = false;
                }
                amount++;
            }
            counter++;
        }
        System.out.println(amount);                 
    }

    public static void runPairwiseTests() throws IOException {
        ArrayList<PairwiseTest> testsuit = readSerialized("testFiles/pairwiseResult.txt");

        boolean first = true;
        int counter = 1;
        int amount = 0;
        int errorTracker = 1;
        int key =  min + (int)(Math.random() * ((max - min) + 1));
        for(PairwiseTest test : testsuit) {
            System.out.println(errorTracker++);
            int[] A = test.arr;
            
            boolean correctRes = membership.is_member(A, key);
            // boolean mutationRes = membership_mutation1.membership(A, key);
            // boolean mutationRes = membership_mutation2.membership(A, key);
            // boolean mutationRes = membership_mutation3.membership(A, key);
            // boolean mutationRes = membership_mutation4.membership(A, key);
            // boolean mutationRes = membership_mutation5.membership(A, key);
            boolean mutationRes = membership_mutation6.membership(A, key);

            if(correctRes != mutationRes) {
                if(first) {
                    System.out.println("the first erro happens: " + counter);
                    first = false;
                }
                amount++;
            }
            counter++;
        }
        System.out.println(amount);                
}

    public static void main(String[] args) {
        try {
            runRandomTests();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // try {
        //     runPairwiseTests();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
}
