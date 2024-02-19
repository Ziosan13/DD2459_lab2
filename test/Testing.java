package test;

import java.util.ArrayList;

public class Testing {
  public static void main(String[] args) {
    // RandomTest
    RandomTestingGenerator rtg = new RandomTestingGenerator();
    ArrayList<RandomTest> RandomSuite = rtg.generateRandomTestSuite(10);
    rtg.writeToFile(RandomSuite, "testFiles/randomTestResult.txt");

    // PairwiseTest
    PairwiseTestingGenerator pGenerator = new PairwiseTestingGenerator();
    ArrayList<PairwiseTest> PairwiseSuite = pGenerator.generatePairwiseTestSuite(10);
    pGenerator.writeToFile(PairwiseSuite, "testFiles/pairwiseResult.txt");
  }
  
}
