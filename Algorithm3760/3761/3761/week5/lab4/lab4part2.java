package lab4;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Artur Gordiyenko on 2017-06-03.
 */

/** @README
 *
 *  I attempted to follow the textbook pseudo - code for merge sort algorithm, and implement it using java ArrayLists.
 *  Having encountered multiple errors such as OutOfBoundException and ConcurrentModificationException, I decided to
 *  convert the implementation to use Array instead.
 *
 *  However after multiple attempts, the output of both implementations is still not correct. If possible, please let me
 *  know where my error is. I believe I have a good understanding of Merge Sort algorithm after this lab assignment,
 *  even if the code itself is not properly executing.
 *
 *  - Artur Gordiyenko
 */

public class lab4part2 {

    static int[] input = {2, 5, 8, 3, 6, 9, 1, 6, 5};


    /** Implementation 1, using ArrayList */
    private static void mergeSort_1(ArrayList a) {
        if (a.size() > 1) {
            //because of .subList(int from, int to) nature, n/2 - 1 was changed to n/2 to copy all the arrayList values.
            ArrayList b = new ArrayList();
            ArrayList c = new ArrayList();
            b.addAll(a.subList(0, a.size() / 2));
            c.addAll(a.subList(a.size() / 2, a.size()));
            mergeSort_1(b);
            mergeSort_1(c);
            merge_1(b, c, a);
        }
    }

    private static void merge_1(ArrayList b, ArrayList c, ArrayList a) {
        int i = 0;
        int j = 0;
        int k = 0;
        int p = b.size();
        int q = c.size();
        while (i < p && j < q) {
            if ((int)b.get(i) <= (int)c.get(j)) {
                if (a.size() == k) {
                    a.add(0);
                }
                a.set(k, b.get(i));
                i++;
            } else {
                if (a.size() == k) {
                    a.add(0);
                }
                a.set(k, c.get(j));
                j++;
            }
            k++;
        }
        if (i == p) {
            a.addAll(j, c);

        } else {
            a.addAll(i, b);
        }
    }

    /** Implementation 2 using Array */
    private static void mergeSort_2 (int[] a) {
        if (a.length > 1) {
            int[] b = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] c = Arrays.copyOfRange(a, a.length / 2, a.length);
            mergeSort_2(b);
            mergeSort_2(c);
            merge_2(b, c, a);
        }
    }

    private static void merge_2 (int[] b, int[] c, int[] a) {
        int i = 0;
        int j = 0;
        int k = 0;
        int p = b.length;
        int q = c.length;
        while (i < p && j < q) {
            if (b[i] <= c[j]) {
                a[k] = b[i];
                i++;
            } else {
                a[k] = c[j];
                j++;
            }
            k++;
        }
        if (i == p) {
            for (int ii = k; (k + ii) < a.length && (ii + j) < c.length; ii++) {
                a[k + ii] = c[j + ii];
            }
        } else {
            for (int ii = k; (k + ii) < a.length && (ii + i) < b.length; ii++) {
                a[k + ii] = b[i + ii];
            }
        }
    }

    /** Main method, calls Implementation 1 and Implementation 2. */
    public static void main(String[] args) {

        /** Implementation 1 */
         ArrayList unsortedArray = new ArrayList();
         //add items from "input" array to "unsortedArray" arrayList
        for (int i = 0; i < input.length; i++) {
            unsortedArray.add(input[i]);
        }

        System.out.println("Implementation 1");
        System.out.println(unsortedArray);
        mergeSort_1(unsortedArray);
        System.out.println(unsortedArray);


        /** Implementation 2 */
        System.out.println("\n\nImplementation 2");
        printArr(input);
        mergeSort_2(input);
        printArr(input);

    }

    /** Prints content of int Array in line. */
    static void printArr(int[] a) {
        String prints = "{";
        for (int i = 0; i < a.length; i++) {
            if (i+1 == a.length) {
                prints += a[i];
            } else {
                prints += a[i] + ", ";
            }
        }
        prints += "}";
        System.out.println(prints);
    }
}
