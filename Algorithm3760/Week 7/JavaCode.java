package Lab;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Lab6 {

    public static void main(String[] args) {
        int[] a = {10, 5, 3, 1, 9};
       

        System.out.print("pq: " + heap(a, 3));

    }

    private static PriorityQueue<Integer> heap(int[] a, int k){ 
        MaxComparator pqMaxComparetor = new MaxComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, pqMaxComparetor);
        for (int x : a) { 
            if (pq.size() < k) pq.add(x);
            else if (pq.peek() > x) {
                pq.poll();
                pq.add(x);
            }
        }
        return pq;   
    }
    static class MaxComparator implements Comparator<Integer> {
        public int compare(Integer one, Integer two) {
            return two - one;
        }
    }
}


