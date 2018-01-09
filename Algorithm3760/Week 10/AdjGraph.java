package Lab8;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 */

/**
 * @author castiel
 *
 */
public class AdjGraph {
	Edge[][] matrix;
	Vertex[] vertices;
	boolean directed;
	int numOfVertices;
	
	// the constructor allocates space for a graph with V vertices
	//(ie: it creates (minimally) a VxV matrix).
	AdjGraph(int v){
		numOfVertices = v;
		matrix = new Edge[numOfVertices][numOfVertices];
		vertices = new Vertex[numOfVertices];
		directed = false;
	}
	
	public void createMatrix() {
		for(int i = 0; i < numOfVertices; i++) {
			for(int j = 0; j < numOfVertices; j++) {
				matrix[i][j] = new Edge();
			}
		}
		for(int i = 0; i< numOfVertices; i++) {
			vertices[i] = new Vertex();
		}
	}
	
	// the addEdge method allows you to define an edge from vertex u to vertex v
	// where the vertices are identified by integers 0..V-1
	public void addEdge(int u, int v) {
		if(!directed) {
			matrix[u][v].AddEdge();
			matrix[v][u].AddEdge();
			vertices[u].addEdges(v);
			vertices[v].addEdges(u);
		}else if(directed) {
			matrix[u][v].AddEdge();
			matrix[v][u].AddEdge(directed);
			vertices[u].addOutEdge();
			vertices[v].addInEdge();
		}
		
	}
	public int inDegree(int v) {
		return vertices[v].getInEdges();
	}
	public int outDegree(int v) {
		return vertices[v].getOutEdges();
	}
	public boolean isDirected() {
		return directed;
	}
	public int degree(int v) {
		return vertices[v].getEdges();
	}
	
	public void DFS(int v) {
		for(Vertex ver : vertices) {
			ver.visited = false;
		}
		for(Vertex ver : vertices) {
			if(!ver.visited) {
				dfs(ver);
			}
		}
	}
	
	public void dfs(Vertex v) {
		v.visited = true;
		System.out.println("visiting vertices" + Arrays.asList(vertices).indexOf(v));
		ArrayList<Integer> adg= v.adjVers;
		for(Integer ver : adg) {
			if(!vertices[ver].visited) {
				dfs(vertices[ver]);
			}
		}
	}
	
	public void BFS(int v) {
		for(Vertex ver : vertices) {
			ver.visited = false;
		}
		for(Vertex ver : vertices) {
			if(!ver.visited) {
				bfs(ver);
			}
		}
	}
	
	public void bfs(Vertex v) {
		v.visited = true;
		System.out.println("visiting vertices" + Arrays.asList(vertices).indexOf(v));
		Queue<Vertex> Q = new LinkedList<Vertex>();
		Q.add(v);
		while(!Q.isEmpty()) {
			Vertex head= Q.peek();
			ArrayList<Integer> adg = head.adjVers;
			for(Integer ver : adg) {
				if(!vertices[ver].visited) {
					vertices[ver].visited = true;
					System.out.println("visiting vertices" + ver);
					Q.add(vertices[ver]);
				}
			}
			Q.remove(Q.peek());
		}
	}
	
	// the toString method returns the adjacency matrix as a string with one line of
	// output for each vertex, for example:
	// 0 1 1
	// 1 0 0
	// 1 0 0
	// your method should print the graph exactly as shown, ie, with spaces and
	// new lines after each row
	public String toString() {
		String matrixStr = "  | ";
		for(int x = 0; x <matrix.length; x++) {
			matrixStr += " " + x + " "; 
		}
		matrixStr += "\n";
		for(int x = 0; x <matrix.length; x++) {
			matrixStr +="----"; 
		}
		matrixStr += "\n";
        for (int i = 0; i < matrix.length; i++) {
        	matrixStr += i + " | ";
        	for (int j = 0; j < matrix.length; j++) {
                	matrixStr += " " + matrix[i][j].getValue() + " ";
            }
            matrixStr += "\n";
        }
		return matrixStr;
	}

}
