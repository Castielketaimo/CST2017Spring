package Lab9;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Question1 {
	private static int numOfTestCases;
	private static int numOfLineForCurrentTestCase;
	private static ArrayList<String> unsortList;
	private static ArrayList<String> sortedList;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		readFile();
	}
	
    private static void readFile(){
            Scanner scan = null;
            File input = new File("input1.txt");
            try {
                scan = new Scanner(input);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            numOfTestCases = Integer.valueOf(scan.nextLine());
            
            for (int i = 0; i < numOfTestCases; ++i) {
            	numOfLineForCurrentTestCase = Integer.valueOf(scan.nextLine()); 
                unsortList = new ArrayList<>();
                sortedList = new ArrayList<>();
                for (int j = 0; j < numOfLineForCurrentTestCase; j++) {
                	unsortList.add(scan.nextLine());
                }
                for (int j = 0; j < numOfLineForCurrentTestCase; j++) {
                	sortedList.add(scan.nextLine());
                }
                sortIt(unsortList,sortedList);
                System.out.println("\n");
            }
            scan.close();       
    }

	private static void sortIt(ArrayList<String> unsort, ArrayList<String> sorted) {
		int i = unsortList.size() - 1;
		int j = sortedList.size() - 1;
		
		while(!unsort.isEmpty()) {
			String inCorrect = unsortList.get(i);
			String correct = sortedList.get(j);
			
			if(inCorrect.equalsIgnoreCase(correct)) {
				unsort.remove(i);
				sorted.remove(j);
				i--;
				j--;
			} else if(!inCorrect.equalsIgnoreCase(correct)) {
				unsort.remove(i);
				i--;
			}
		}
		
		while(!sorted.isEmpty()) {
			System.out.println(sorted.get(j));
			sorted.remove(j);
			j--;
		}
	}
}
