package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PairwiseTestingGenerator {
    int[] typicalArray;
    int len;
    private static int min = -50;
    private static int max = 50;

    public PairwiseTestingGenerator(int len){
        this.len = len;
        this.typicalArray = new int[len];
        for(int i = 0; i < len; i++) {
            this.typicalArray[i] = min + (int)(Math.random() * ((max - min) + 1));
        }
    }

    public ArrayList<PairwiseTest> generatePairwiseTestSuite() {
        ArrayList<PairwiseTest> testSuite = new ArrayList<PairwiseTest>();
        // 0-wise
        int[] defaultArray = zeroWiseGenerator(len);
        testSuite.add(new PairwiseTest(defaultArray));
        // 1-wise
        testSuite.addAll(oneWiseGenerator(len, defaultArray));
        // 2-wise
        testSuite.addAll(twoWise(len, defaultArray));
        return testSuite;
    }

    public int[] zeroWiseGenerator(int len){
        int[] zeroWiseArray = new int[len];
        for (int i = 0; i < len; i++) {
            zeroWiseArray[i] = min + (int)(Math.random() * ((max - min) + 1));
        }
        return zeroWiseArray;
    }

    public ArrayList<PairwiseTest> oneWiseGenerator(int len, int[] defaultArray) {
        ArrayList<PairwiseTest> testSuite = new ArrayList<PairwiseTest>();
        for (int i = 0; i < len; i++) {           
            int[] tempArray = defaultArray.clone();
            tempArray[i] = typicalArray[i];
            testSuite.add(new PairwiseTest(tempArray));
        }
        return testSuite;
    }

    public ArrayList<PairwiseTest> twoWise(int length, int[] defaultArray) {
        ArrayList<PairwiseTest> testSuite = new ArrayList<PairwiseTest>();
        for (int i = 0; i < length; i++) {
            int[] tempArray = defaultArray.clone();
            tempArray[i] = typicalArray[i];
            for (int j = i + 1; j < length; j++) {
                int[] tempArray2 =tempArray.clone();
                if (j != i) {
                    tempArray2[j] = typicalArray[j];
                    testSuite.add(new PairwiseTest(tempArray2));
                }
            }
        }
        return testSuite;
    }

    // public void writeToFile(ArrayList<PairwiseTest> testSuite, String filename) {
    //     File file = new File(filename);
    //     FileWriter fileWriter;
    //     try {
    //         fileWriter = new FileWriter(file);
    //         String testSuiteString = "";
    //         for(PairwiseTest test: testSuite) {
    //             testSuiteString += test.getString();
    //         }
    //         fileWriter.write(testSuiteString);
    //         fileWriter.flush();
    //         fileWriter.close();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    public static void writeToFile(ArrayList<PairwiseTest> testSuite, String filename) {
        try(FileOutputStream f = new FileOutputStream(filename);
            ObjectOutput s = new ObjectOutputStream(f)) {
        s.writeObject(testSuite);
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
    }

    // public static void main(String[] args) {
    //     PairwiseTestingGenerator pGenerator = new PairwiseTestingGenerator();
    //     ArrayList<PairwiseTest> testSuite = pGenerator.generatePairwiseTestSuite(10);
    //     pGenerator.writeToFile(testSuite, "testFiles/pairwiseResult.txt");
    // }
}
