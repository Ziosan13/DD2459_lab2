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
import java.lang.reflect.Array;
import java.util.ArrayList;

public class RandomTestingGenerator {

  private static int min = -50;
  private static int max = 50;


  public ArrayList<RandomTest> generateRandomTestSuite(int len){
    ArrayList<RandomTest> testSuite = new ArrayList<RandomTest>();
    for (int i = 0; i < 56; i++) {
        int[] RandomArray = new int[len];
        for (int j = 0; j < len; j++) {
            RandomArray[j] = min + (int)(Math.random() * ((max - min) + 1));
        }
        testSuite.add(new RandomTest(RandomArray));
    }
    // int[] RandomArray = new int[len];
    // for (int i = 0; i < len; i++) {
    //     RandomArray[i] = min + (int)(Math.random() * ((max - min) + 1));
    // }
    // testSuite.add(new RandomTest(RandomArray));
    return testSuite;
  }

//   public void writeToFile(ArrayList<RandomTest> testSuite, String filename) {
//     File file = new File(filename);
//     FileWriter fileWriter;
//     try {
//         if(!file.exists()){
//             fileWriter = new FileWriter(file);
//         }
//         else{
//             fileWriter = new FileWriter(file, true);
//         }
//         String testSuiteString = "";
//         for(RandomTest test: testSuite) {
//             testSuiteString += test.getString();
//         }
//         fileWriter.write(testSuiteString);
//         fileWriter.flush();
//         fileWriter.close();
//     } catch (IOException e) {
//         e.printStackTrace();
//     }

    public static void writeToFile(ArrayList<RandomTest> testSuite, String filename) {
            try(FileOutputStream f = new FileOutputStream(filename);
                ObjectOutput s = new ObjectOutputStream(f)) {
            s.writeObject(testSuite);
            } catch (FileNotFoundException e) {
            e.printStackTrace();
            } catch (IOException e) {
            e.printStackTrace();
            }
        }
    }

  // public static void main(String[] args) {
  //   RandomTestingGenerator rtg = new RandomTestingGenerator();
  //   ArrayList<RandomTest> testSuite = rtg.generateRandomTestSuite(10);
  //   rtg.writeToFile(testSuite, "testFiles/randomTestSuite.txt");
  // }

  
  
