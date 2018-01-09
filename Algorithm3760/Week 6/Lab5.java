
import java.util.Arrays;

/**
 * 
 */

/**
 * @author castiel
 *
 */
public class Lab5 {
    static int inputs[] = { 2, 5, 8, 3, 8, 9, 1, 6, 5 };

    /**
     * @param args
     */
    public static void main(String[] args) {
        runFindMax();
        runMergSort1();
    }

    private static void runFindMax() {
        System.out.println("The max number index in the array is: " + (findMax(inputs, 0, inputs.length - 1)));
    }

    private static int findMax(int a[], int left, int right) {
        if (left == right) { // when there's only one elements in the array
            return left;
        }
        int left_max = findMax(a, left, (left + right) / 2);
        int right_max = findMax(a, (left + right) / 2 + 1, right);
        if (a[left_max] > a[right_max]) {
            return left_max;
        } else {
            return right_max;
        }
    }

    private static void runMergSort1() {
        mergeSort1(inputs);
        int i;
        for (i = 0; i < inputs.length - 1; i++) {
            System.out.print(inputs[i] + ",");
        }
        System.out.print(inputs[i] + ".");
    }

    private static int[] mergeSort1(int[] a) {
        if (a.length > 1) {
            int[] b = Arrays.copyOfRange(a, 0, (a.length / 2));
            int[] c = Arrays.copyOfRange(a, (a.length / 2), a.length);
            mergeSort1(b);
            mergeSort1(c);
            merge1(b, c, a);
        }
        return a;
    }

    private static void merge1(int[] b, int[] c, int[] a) {
        int i = 0;
        int j = 0;
        int k = 0;
        int q = c.length;
        int p = b.length;
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
        int[] tmp;
        int tmpIndex = 0;
        if (i == p) {
            tmp = c;
            tmpIndex = j;
        } else {
            tmp = b;
            tmpIndex = i;
        }
        for (int x = tmpIndex; x < tmp.length; x++) {
            a[k] = tmp[x];
            k++;
        }
    }
}
