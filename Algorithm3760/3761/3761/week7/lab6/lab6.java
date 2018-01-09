package lab6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by gordiartur on 2017-06-24.
 */
public class lab6 {
    public static void main(String[] args) {
        System.out.println("Question 1");
        q1();
        System.out.println("\n\nQuestion 2");
        q2();
        System.out.println("\n\nQuestion 3");
        q3();
    }

    private static void q1() {
        String[] strList = buildStrList("src/lab6/love.txt", " ");
        Arrays.sort(strList);
        Map map = new HashMap();
        map = q1_numOfOcc(strList, map);
        q1_printMap(strList, map);
    }

    private static Map q1_numOfOcc(String[] strList, Map map) {
        for (int i = 0; i < strList.length; i++) {
            if (!map.containsKey(strList[i])) {
                 map.put(strList[i], 1);
            }
            else {
                int curr = (int) map.get(strList[i]);
                map.put(strList[i], ++curr);
            }
        }
        return map;
    }
    private static void q1_printMap(String[] strList, Map map) {
        System.out.println(strList[0] + " - " + map.get(strList[0]));
        for (int i = 1; i < strList.length; i++) {
            if (!strList[i].equals(strList[i-1])) {
                System.out.println(strList[i] + " - " + map.get(strList[i]));
            }
        }
    }

    private static void q2() {
        String[] strList = buildStrList("src/lab6/q2input.txt", " ");
        System.out.println(q2_isDistinct(strList) ? "DISTINCT" : "NOT DISTINCT");
    }

    private static boolean q2_isDistinct(String[] strList) {
        HashSet set = new HashSet();
        for (int i = 0; i < strList.length; i++) {
            if (!set.add(strList[i])) {
                return false;
            }
        }
        return true;
    }

    private static void q3() {
        String firstLine;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/lab6/q3test.txt"));
            firstLine = br.readLine();
            String[] firstLineArr = firstLine.split(" ");
            int k = Integer.parseInt(firstLineArr[0]);
            int e = Integer.parseInt(firstLineArr[1]);
            String[] excuseWords = new String[k];
            String[] excuses = new String[e];
            for (int i = 0; i < k; i++) {
                excuseWords[i] = br.readLine();
            }
            for (int i = 0; i < e; i++) {
                excuses[i] = br.readLine();
            }
            Map map;
            map = q3_worstExcuse(excuseWords, excuses);
            int worstExcuseNum = q3_getWorstExcuseNum(excuses, map);
            q3_printWorstExcuses(excuses, map, worstExcuseNum);
        } catch (Exception e) {
            System.out.println("File input error.");
        }
    }

    private static Map q3_worstExcuse(String[] words, String[] excuses) {
        HashSet set = new HashSet();
        Map map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        for (int i = 0; i < excuses.length; i++) {
            String[] excuseSplit = excuses[i].split(" ");
            for (int j = 0; j < excuseSplit.length; j++) {
                if (set.contains(excuseSplit[j])) {
                    if (!map.containsKey(excuses[i])) {
                        map.put(excuses[i], 1);
                    }
                    else {
                        int curr = (int) map.get(excuses[i]);
                        map.put(excuses[i], ++curr);
                    }
                }
            }
        }
        return map;
    }

    private static int q3_getWorstExcuseNum(String[] excuses, Map map) {
        int worstExcuseNum = 0;
        for (int i = 0; i < excuses.length; i++) {
            if ((int)map.get(excuses[i]) > worstExcuseNum) {
                worstExcuseNum = (int)map.get(excuses[i]);
            }
        }
        return worstExcuseNum;
    }

    private static void q3_printWorstExcuses(String[] excuses, Map map, int worstExcuseNum) {
        System.out.println("Worst excuses, with length of " + worstExcuseNum + ":");
        for (int i = 0; i < excuses.length; i++) {
            if ((int)map.get(excuses[i]) == worstExcuseNum) {
                System.out.println(excuses[i]);
            }
        }
    }

    private static String[] buildStrList(String fileName, String regEx) {
        String temp;
        StringBuilder strBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((temp = br.readLine()) != null) {
                if (!temp.equals("")) {
                    strBuilder.append(temp.toLowerCase() + " ");
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Fine not found.");
        }
        catch (Exception e) {
            System.out.println("File input error.");
        }
        String str = strBuilder.toString();
        String[] strList = str.split(regEx);
        return strList;
    }
}
