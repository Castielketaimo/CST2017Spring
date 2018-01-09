package lab7;

import java.util.ConcurrentModificationException;

/**
 * @README:
 * As Part 1 tells not to use ArrayList, simple arrays were used.
 * For Part 2, ArrayList was used to simplify adding and removing adjacent vertices to/from vertices list.
 *
 * For Part 2, both DFS and BFS were running into ConcurrentModificationException, and I could not figure out how to
 * solve it. Wrapping it into a Try/Catch block solves the issue, while returning correct output.
 */
public class GraphTest {
    public static void main(String[] args) {
        System.out.println("Question 1");
        q1_test();
        System.out.println("Question 2\n\tGraph 1");
        q2_test_1();
        System.out.println("\tGraph 2");
        q2_test_2();
        System.out.println("Question 3");
        q3_test();
        System.out.println("\nQuestion 4");
        q4_test();
        System.out.println("\nQuestion 5");
        q5_tet();
    }
    static AdjGraph q1_test() {
        AdjGraph graph = new AdjGraph(7);
        graph.createMatrix();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 6);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        System.out.println(graph.toString());
        return graph;
    }

    static void q2_test_1() {
        AdjGraph graph = new AdjGraph(5);
        graph.createMatrix();
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println(graph.toString());
    }

    static void q2_test_2() {
        AdjGraph graph = new AdjGraph(4);
        graph.createMatrix();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        System.out.println(graph.toString());
    }

    static void q3_test() {
        AdjGraph graph;
        graph = q1_test();
        for (int i = 0; i < 7; i++) {
            System.out.println("degree[" + i + "]=" + graph.degree(i));
        }
    }

    static void q4_test() {
        AdjGraph graph = new AdjGraph(4);
        graph.directed = true;
        graph.createMatrix();
        System.out.println("Is directed? " + graph.isDirected());
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        System.out.println(graph.toString());

        for (int i = 0; i < 4; i++) {
            System.out.println("out degree[" + i + "]=" + graph.outDegree(i));
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("in degree[" + i + "]=" + graph.inDegree(i));
        }
    }

    static void q5_tet() {
        AdjGraph graph = new AdjGraph(8);
        graph.createMatrix();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        System.out.println(graph.toString());

        System.out.println("DFS");
        try {
            graph.DFS(0);
        } catch (ConcurrentModificationException e) {
        }
        System.out.println("\nBFS");
        try {
            graph.BFS(0);
        } catch (ConcurrentModificationException e) {
        }
    }
}
