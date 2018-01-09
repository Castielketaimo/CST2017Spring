package Lab8;

import java.util.ArrayList;

public class Vertex {
	int deges;
	int inEdges;
	int outEdges;
	boolean visited;

	ArrayList<Integer> adjVers = new ArrayList<>();
	public void addEdges(int vers) {
		adjVers.add(vers);
	}
	public Vertex() {
		deges = 0;
	}
	public void addEdges() {
		deges++;
	}
	public void addInEdge() {
		inEdges++;
	}
	public void addOutEdge() {
		outEdges++;
	}
	public int getEdges() {
		return deges;
	}
	public int getInEdges() {
		return inEdges;
	}
	public int getOutEdges() {
		return outEdges;
	}
}
