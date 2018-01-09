package SpellChecker;

import java.io.BufferedReader;
import java.io.FileReader;

public class SpellChecker {
    public static void main(String[] args) {
        String wordlistString = null;
        StringBuilder builder = new StringBuilder(0);
        String[] testData;
        String[] wordlist;
        try {
            //reading the test data
            BufferedReader buffRead1 = new BufferedReader(new FileReader("lab4_testdata.txt"));
            String testDataString = buffRead1.readLine();
            buffRead1.close();
            testData = testDataString.split(" ");
            testData = toLowerCase(testData);

          //since the wordlist is split by new line, we need to build a string
            BufferedReader buffRead2 = new BufferedReader(new FileReader("lab4_wordlist.txt"));
            while ((wordlistString = buffRead2.readLine()) != null) { 
                builder.append(wordlistString + " ");
            }
            buffRead2.close();
            wordlistString = builder.toString();
            wordlist = wordlistString.split(" ");
            wordlist = toLowerCase(wordlist);
        
        } catch (Exception e) {
            System.out.println("reading file error");
            return;
        }
    
        try{
        
            //running for the sequenchSearch
            long startTime = System.currentTimeMillis();
            int voidWords = sequenchSearch(testData, wordlist);
            long endTime = System.currentTimeMillis();
            System.out.println("SequenchSearch: ");
            System.out.println(voidWords + " of words are not in the wordlist");
            System.out.println("Took " + ((endTime - startTime))  * 1000+ " Micro seconds");

        } catch (Exception e) {
            System.out.println("SequenchSearch error");
        }
        
        try{
            
            //running for the BinarySearch
            long startTime = System.currentTimeMillis();
            int VoidWords = getBinarySearchMatchResult(testData, wordlist);
            long endTime = System.currentTimeMillis();
            System.out.println("Binary Search: ");
            System.out.println(VoidWords + " of words are not in the wordlist");
            System.out.println("Took " + ((endTime - startTime)) * 1000 + " Micro seconds");

        } catch (Exception e) {
            System.out.println("Binary error");
        }

    }

    private static int getBinarySearchMatchResult(String[] testData, String[] wordlist){
      int counter = 0;
        for (int i = 0; i < testData.length; i++){
                counter += binarySearch(wordlist, testData[i]);
            }
//        for (int i = 0; i < testData.length; i++){
//            if (!(binarySearch(wordlist, testData[i], 0, testData.length))){
//                counter++;
//            }           
//        }
        return counter;
        

    }

    private static boolean binarySearch(String[] wordlist, String key, int s, int e) {
        int m;
        if (s > e){
            return false;
        } else {
             m = (int) Math.floor((s + e)/2);
            if (key.compareTo(wordlist[m]) > 0){
                return binarySearch(wordlist, key, m+1, e);
            } else if (key.compareTo(wordlist[m]) < 0){
                return binarySearch(wordlist, key, s, m-1);
            } else {
                return true;
            }
        }
    }
    
    
    private static int binarySearch(String[] wordlist, String key){
        int s = 1;
        int e = wordlist.length;
        int m = 0;
        while(e >= s){
            m =  (s+e)/2;
            if(wordlist[m].compareToIgnoreCase(key) == 0){
                return 0;
            } else if (wordlist[m].compareToIgnoreCase(key) < 0){
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return 1;
    }
    
    public static String[] toLowerCase(String[] input){
        String[] output = new String[input.length];
        for(int i = 0; i< input.length; i++){
            output[i] = input[i].toLowerCase();
        }
        return output;
    }
    
    public static int sequenchSearch(String[] testData, String[] wordlist) {
        int counter = 0;
        for (int i = 0; i < testData.length; i++) {
            for (int j = 0; j < wordlist.length; j++) {
                if (testData[i].equalsIgnoreCase(wordlist[j])) {
                    counter++;
                }
            }
        }
        return testData.length - counter;
    }
}