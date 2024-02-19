package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class PairwiseTestingGenerator {
    int changedValue1;
    int changedValue2;
    private static int min = -50;
    private static int max = 50;

    public PairwiseTestingGenerator(){
        this.changedValue1 = min + (int)(Math.random() * ((max - min) + 1));
        this.changedValue2 = min + (int)(Math.random() * ((max - min) + 1));
    }

    public ArrayList<PairwiseTest> generatePairwiseTestSuite(int len) {
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
            tempArray[i] = changedValue1;
            testSuite.add(new PairwiseTest(tempArray));
        }
        return testSuite;
    }

    public ArrayList<PairwiseTest> twoWise(int length, int[] defaultArray) {
        ArrayList<PairwiseTest> testSuite = new ArrayList<PairwiseTest>();
        for (int i = 0; i < length; i++) {
            int[] tempArray = defaultArray.clone();
            tempArray[i] = changedValue1;
            for (int j = 0; j < length; j++) {
                int[] tempArray2 =tempArray.clone();
                if (j != i) {
                    tempArray2[j] = changedValue2;
                    testSuite.add(new PairwiseTest(tempArray2));
                }
            }
        }
        return testSuite;
    }

    public void writeToFile(ArrayList<PairwiseTest> testSuite, String filename) {
        File file = new File(filename);
        FileWriter fileWriter;
        try {
            if(!file.exists()){
                fileWriter = new FileWriter(file);
            }
            else{
                fileWriter = new FileWriter(file, true);
            }
            String testSuiteString = "";
            for(PairwiseTest test: testSuite) {
                testSuiteString += test.getString();
            }
            fileWriter.write(testSuiteString);
            fileWriter.flush();
            fileWriter.close();
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
