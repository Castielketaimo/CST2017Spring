/**
 * 
 */
package Lab8;

import java.util.ConcurrentModificationException;

/**
 * @author casti
 *
 */
public class GraphTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Question 2a");
        q2a();
        System.out.println("\n\nQuestion 2b");
        q2b();
        System.out.println("\n\nQuestion 3");
        q3();
        System.out.println("\n\nQuestion 4");
        q4();
        System.out.println("\n\nQuestion 5");
        q5();
	}

    static AdjGraph q2a() {
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
        return graph;
    }
    
    static AdjGraph q2b() {
        AdjGraph graph = new AdjGraph(4);
        
        graph.createMatrix();
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(3, 2);

        System.out.println(graph.toString());
        return graph;
    }
    
    static void q3() {
    	AdjGraph graph;
    	graph = q2a();
    	for (int i = 0; i < 5; i++) {
            System.out.println("degree[" + i + "]=" + graph.degree(i));
        }
    }

    static void q4() {
        AdjGraph graph = new AdjGraph(4);
        graph.directed = true;
        graph.createMatrix();
        System.out.println("directed= " + graph.isDirected());
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(3, 2);

        System.out.println(graph.toString());

        for (int i = 0; i < 4; i++) {
            System.out.println("out degree[" + i + "]=" + graph.outDegree(i));
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("in degree[" + i + "]=" + graph.inDegree(i));
        }
    }
        
    static void q5() {
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

            graph.DFS(0);
        
        System.out.println("\n\nBFS");
            graph.BFS(0);
    }
}


