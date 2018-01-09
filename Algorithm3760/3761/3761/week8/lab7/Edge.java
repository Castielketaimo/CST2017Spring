package lab7;

/**
 * Created by Artur Gordiyenko on 2017-07-02.
 */
public class Edge {
    /**
     * if isEdge = 1 then edge exists, and is either undirected, or is the tail.
     * if isEdge = -1 then edge exists, and is the head.
     * if isEdge = 0 then edge does not exist.
     */
    int isEdge;
    public Edge() {
        isEdge = 0;
    }
    public void addEdge() {
        isEdge = 1;
    }
    public void addEdge(boolean directed) {
        isEdge = -1;
    }
    public int getisEdge() {
        return isEdge;
    }
}
