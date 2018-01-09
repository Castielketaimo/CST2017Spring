package lab7;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Artur Gordiyenko on 2017-07-02.
 */
public class Vertex {
    int edges;
    int inEdges;
    int outEdges;
    boolean isVisited;

    /** Note: ArrayList only needed for PART 2 **/
    ArrayList<Integer> adjacentNodes = new ArrayList<>();
    public Vertex() {
        edges = 0;
        inEdges = 0;
        outEdges = 0;
        isVisited = false;
    }
    public void addEdge(int otherNode, int head) {
        edges++;
        addOtherNode(otherNode, head);
    }
    private void addOtherNode(int otherNode, int head) {
        if (adjacentNodes.isEmpty()) {
            adjacentNodes.add(0, head);
            adjacentNodes.add(otherNode);
        } else {
            adjacentNodes.add(otherNode);
        }
    }
    public ArrayList getAdjacentNodes() {
        Collections.sort(adjacentNodes);
        return adjacentNodes;
    }
    public void addInEdge() {
        inEdges++;
    }
    public void addOutEdge() {
        outEdges++;
    }
    public int getEdges() {
        return edges;
    }
    public int getInEdges() {
        return inEdges;
    }
    public int getOutEdges() {
        return outEdges;
    }
    public void visit(int v) {
        System.out.println("visiting vertex " + v);
        isVisited = true;
    }
    public boolean getIsVisited() {
        return isVisited;
    }
}
