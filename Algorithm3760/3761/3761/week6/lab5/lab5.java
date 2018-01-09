package lab5;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by gordiartur on 2017-06-06.
 */

/**
 * Question 2
 */
public class lab5 {

    /**
     * Creates an array of random int values and prints the lowest 4.
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 10, 5, 3, 4, 7, 12, 19, 2, 56, 8};
        System.out.println("4 smallest values left in priority queue are " + smallest_N_values(4, a));
    }

    /**
     * Creates a priority queue of size N, and returns the priority queue
     * containing N lowest values in array A
     * @param n = int n as number of values in priority queue
     * @param a = int [] a as array of unsorted integers
     * @return pq as priority queue containing n lowest values
     */
    private static PriorityQueue<Integer> smallest_N_values(final int n, final int[] a) {
        MaxComparator pqMaxComparator = new MaxComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<>(n, pqMaxComparator);
        for (int i = 0; i < n; i++) {
            pq.offer(a[i]);
        }
        for (int i = n; i < a.length; i++) {
            if (pq.peek() > a[i]) {
                pq.poll();
                pq.offer(a[i]);
            }
        }
        return pq;
    }

    /**
     * Implements 'compare' method from java.util.Comparator interface
     */
    static class MaxComparator implements Comparator<Integer> {
        public int compare(Integer one, Integer two) {
            return two - one;
        }
    }

}
