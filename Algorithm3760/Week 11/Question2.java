package Lab9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Question2 {
	static int numOfTestCases;
	static ArrayList<String> dictionary = new ArrayList<>();
	static ArrayList<String> pairsOfWords = new ArrayList<>();
	public static void main(String[] args) {
		readFile();
	}
	
	static class WordNode{
	    String word;
	    int numSteps;
	 
	    public WordNode(String word, int numSteps){
	        this.word = word;
	        this.numSteps = numSteps;
	    }
	}
	
	private static void readFile(){
        Scanner scan = null;
        File input = new File("input2.txt");
        try {
            scan = new Scanner(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //get the num of test case we will be testing
        numOfTestCases = Integer.valueOf(scan.nextLine());
        //for each test case we get all the information we need;
        for (int i = 0; i < numOfTestCases; ++i) {
        	dictionary = new ArrayList<>();
        	pairsOfWords = new ArrayList<>();
        	String line = scan.nextLine();
        	while(!line.equals("*")) {
        		dictionary.add(line);
        		line = scan.nextLine();
        	}
        	
        	while(scan.hasNextLine()) {
        		line = scan.nextLine();
        		if (line.isEmpty()) {
        			break;
        		}
            	pairsOfWords.add(line);
            }
        	printIt(dictionary, pairsOfWords);
        }
        scan.close();       
     }

	private static void printIt(ArrayList<String> dictionary, ArrayList<String> pairsOfWords) {
		for(int i = 0; i < pairsOfWords.size(); i++) {
			//get the current pair
			String singlePair = pairsOfWords.get(i);
			//get the orgin and target
			String[] pair = singlePair.split(" ");
			String orgin = pair[0];
			String target = pair[1];
			//get the possible words in dictionary (words mathct he length with target)
			Set<String> possibleDictionary = new TreeSet<String>();
			for(String d : dictionary) {
				if(d.length() == target.length()) {
					possibleDictionary.add(d);
				}
			}
			System.out.println(orgin + " " + target + " " + findShortest(orgin, target, possibleDictionary));
		}
	}
	
	public static int findShortest(String orgin, String target, Set<String> possibleDictionary) {
		//create a new set path that will connect all the words between orgin and target
        LinkedList<WordNode> path = new LinkedList<WordNode>();
        path.add(new WordNode(orgin, 0)); //init the path with starting point
 
        while(!path.isEmpty()){ 
            WordNode top = path.remove(); //get the first node
            String currentWord = top.word; 
 
            if(currentWord.equals(target)){
                return top.numSteps; //if the word matches the target return the numSteps took to get to the word
            }
 
            char[] arr = currentWord.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i]; 
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
 
                    String newWord = new String(arr); // keep trying all the different word that is one char off from the current word
                    if(possibleDictionary.contains(newWord)){ // if the new word is in the dictionary it means that its contained in the path
                        path.add(new WordNode(newWord, top.numSteps+1));
                        possibleDictionary.remove(newWord);// remove the word so we don't go backwards
                    }
                    arr[i]=temp;
                }
            }
        }
        return 0;
    }
	

}
	
	


