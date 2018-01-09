
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/*This programs purpose is to take the inputed word, and check if it has
 * an anagram.  Loop through the dictionary and check how many words it can make up.
 * Then record that value.  Also, time how long it takes to run.  Display the original word
 * as well as the amount of times it displays, and the time that it took.*/

/*Nathan Miles in our class, helped me understand how to do the loop to compare the
 * dictionary files.  https://pastebin.com/FWJYUNG0 Is the code that he provided me.
 * */

public class Dict {

  public static void main(String[] args) {

    // TODO Auto-generated method stub
    long startTime = System.currentTimeMillis();
    try {
      BufferedReader buffRead = new BufferedReader(new FileReader("Dict.txt"));
      String storeFile = buffRead.readLine();
      buffRead.close();
      String[] fileArray = storeFile.split(" ");
      int[] numberArray = new int[fileArray.length];

      for (int i = 0; i < fileArray.length; i++) {
        for (int j = i + 1; j < fileArray.length; j++) {
          if (techniqueOne(fileArray[i], fileArray[j])) {
            //This was to help me debug. -> System.out.println("match");
            numberArray[i] = numberArray[i] + 1;
            numberArray[j] = numberArray[j] + 1;

          }
        }
      }
      int maximum = 0;
      int highestIndex = 0;
      for (int i = 0; i < numberArray.length; i++) {
        if (maximum < numberArray[i]) {
          highestIndex = i;
          maximum = numberArray[i];

        }

      }

      long endTime = System.currentTimeMillis();

      System.out.println(
          fileArray[highestIndex] + " with " + maximum + " appearances ");
      System.out.println("Took " + ((endTime - startTime) / 1000) + " seconds");

    } catch (Exception e) {
      System.out.println("error.");
    }
  }

  /*
   * take para's of the inputed word, and the dictionary. loop through the
   * dictionary and run the method to determine if the two words are anagrams
   */
  public static boolean techniqueOne(String word, String dict) {
    StringBuilder sb = new StringBuilder(dict);
    for (int i = 0; i < word.length(); i++) {
      for (int j = 0; j < sb.length(); j++) {
        if (sb.charAt(j) == word.charAt(i)) {
          sb.deleteCharAt(j);
          break;
        }
       }
    }
    if (sb.length() == 0) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean techniqueTwo(String word, String dict) {
    word.toLowerCase();
    dict.toLowerCase();
    char[] wordArray = word.toCharArray();
    char[] dictArray = dict.toCharArray();
    Arrays.sort(wordArray);
    Arrays.sort(dictArray);
    if (wordArray.length != dictArray.length) {
      return false;
    }
    for (int i = 0; i < wordArray.length; i++) {
      if (wordArray[i] != dictArray[i]) {
        return false;
      }
    }
    return true;
  }

  public static boolean techniqueThree(String word, String dict) {
    boolean correct = false;
    int[] oneTwenty = new int[128];
    if (word.length() == dict.length()) {
      correct = true;
      for (int i = 0; i < word.length(); i++) {
        oneTwenty[(int) word.charAt(i)]++;
        oneTwenty[(int) dict.charAt(i)]--;
      }
      for (int i = 0; i < oneTwenty.length; i++) {
        if (oneTwenty[i] != 0) {
          correct = false;
          break;
        }
      }
    }
    return correct;
  }

}
