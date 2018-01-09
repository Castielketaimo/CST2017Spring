package lab4;

/**
 * Created by gordiartur on 2017-06-03.
 */

public class lab4part1 {
    public static void main(String[] args) {

        /** index from 0 to n-1 */
        int[] input = {2, 5, 8, 3, 6, 9, 1, 6, 5};

        /** gets the index of the largest value in the array */
        int largest_index = findLargest(input, 0, (input.length) - 1);

        /** prints the results */
        System.out.println("Index of largest number is " + largest_index + "; Largest number is "
                + input[largest_index]);
    }

    /**returns the index of largest array value between 0 and n-1
     *
     * @param a = array of integers
     * @param l = index of left-most value of the array
     * @param r = index of right-most value of the array
     * @return int = index of biggest number in array a
     *
     */
    private static int findLargest(int[] a, int l, int r) {
        if (l == r) {
            return l;
        }
        int biggest_left = findLargest(a, l, (l + r) / 2);
        int biggest_right = findLargest(a, (l + r) / 2 + 1, r);
        if (a[biggest_left] < a[biggest_right]) {
            return biggest_right;
        } else {
            return biggest_left;
        }
    }
}
