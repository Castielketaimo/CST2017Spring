package lab3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Artur Gordiyenko on 2017-05-28.
 */
public class lab3 {

    public static void main(String[] args) {

        BufferedReader br1;
        BufferedReader br2;
        StringBuilder strBuild = new StringBuilder(0);
        String filehold1;
        String filehold2;
        String tempString;
        String[] wordList;
        String[] testData;
        long startTime;
        long endTime;
        int numNotFound;

        try {
            br1 = new BufferedReader(new FileReader("lab3_wordlist.txt"));
            br2 = new BufferedReader(new FileReader("lab3_testdata.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File(s) not found.");
            return;
        }

        try {
            /* Read wordlist data into a string builder.*/
            while ((tempString = br1.readLine()) != null) {
                strBuild.append(tempString + " ");
            }

            filehold1 = strBuild.toString();
            filehold2 = br2.readLine();
            br1.close();
            br2.close();

            wordList = filehold1.split(" ");
            testData = filehold2.split(" ");

            wordList = toLower(wordList);
            testData = toLower(testData);

        } catch(Exception e) {
            System.out.println("Error in data input.");
            return;
        }

        System.out.println("\n");

        try {

            /** Calls sequential search, and counts the time in miliseconds it takes to execute.*/
            numNotFound = 0;
            startTime = System.currentTimeMillis();

            for (int i = 0; i < testData.length; i++) {
                if (seqSearch(testData[i], wordList) == -1) {
                    numNotFound++;
                }
            }

            endTime = System.currentTimeMillis();
            System.out.println("SeqSearch finished. " + numNotFound + " words not found. Took " + (endTime - startTime) + " miliseconds.");

        } catch (Exception e) {
                System.out.println("Error in sequential search.");
            }


        System.out.println("\n\n");


        try {

            /** Calls binary search, and counts the time in miliseconds it takes to execute.*/
            numNotFound = 0;
            startTime = System.currentTimeMillis();

            for (int i = 0; i < testData.length; i++) {
                if (binarySearch(testData[i], wordList, 0, wordList.length) == -1) {
                    numNotFound++;
                }
            }

            endTime = System.currentTimeMillis();
            System.out.println("BinSearch finished. " + numNotFound + " words not found. Took: " + (endTime - startTime) + " miliseconds.");

        } catch (Exception e) {
            System.out.println("Error in binary search.");
        }
    }

    /**
     * Uses sequential search to find and return the index on String searchVal. Returns -1 if not found.
     * @param searchVal as String
     * @param sortedArr as String array
     * @return count as Integer
     */
    private static int seqSearch(String searchVal, String[] sortedArr) {
        for (int i = 0; i < sortedArr.length; i++) {
            if (sortedArr[i].equals(searchVal)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Uses binary search to find and return the index on String searchVal. Returns -1 if not found.
     * @param searchVal as String
     * @param sortedArr as String array
     * @param min as Integer
     * @param max as Integer
     * @return arrayIndex as Integer
     */
    private static int binarySearch( String searchVal, String[] sortedArr, int min, int max ) {
        int half;
        if (min > max)
            return -1;
        } else {
            half = (min + max)/2;
            if ( searchVal.compareTo(sortedArr[half]) == 0) {
                return half;
            } else if ( searchVal.compareTo(sortedArr[half]) < 0 ) {
                return binarySearch( searchVal, sortedArr, min, half -1 );
            } else {
                return binarySearch( searchVal, sortedArr, half+1, max );
            }
        }
    }

    /**
     * Takes an array input of strings and changes every value to lower case.
     * @param input as String array
     * @return String array
     */
    private static String[] toLower(String[] input) {
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].toLowerCase();
        }
        return input;
    }
}
