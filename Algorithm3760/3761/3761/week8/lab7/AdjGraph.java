package lab7;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Artur Gordiyenko on 2017-07-01.
 */
public class AdjGraph {
    Edge[][] matrix;
    Vertex[] vertices;
    boolean directed;
    int v;

    public AdjGraph(int v) {
        this.v = v;
        matrix = new Edge[this.v][this.v];
        vertices = new Vertex[this.v];
        directed = false;
    }

    public void createMatrix() {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                matrix[i][j] = new Edge();
            }
        }
        for (int i = 0; i < v; i++) {
            vertices[i] = new Vertex();
        }
    }

    /**
     * If directed:
     * @param u direction from
     * @param v direction to
     */
    public void addEdge(int u, int v) {
        if (!directed) {
            matrix[u][v].addEdge();
            matrix[v][u].addEdge();
            vertices[u].addEdge(v, u);
            vertices[v].addEdge(u, v);
        } else {
            matrix[u][v].addEdge();
            matrix[v][u].addEdge(directed);
            vertices[u].addOutEdge();
            vertices[v].addInEdge();
        }
    }

    public int degree(int v) {
        return vertices[v].getEdges();
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

    /**
     * @param v = Starting Vertex
     */
    public void DFS(int v) {
        for (Vertex vertex : vertices) {
            vertex.isVisited = false;
        }
        ArrayList adjNodes = vertices[v].getAdjacentNodes();
        for (Object node : adjNodes) {
            if (!vertices[(int)node].isVisited) {
                dfs((int)node);
            }
        }
    }
    private void dfs(int v) {
        vertices[v].visit(v);
        ArrayList adjNodes = vertices[v].getAdjacentNodes();
        for (Object node : adjNodes) {
            if (!vertices[(int)node].isVisited) {
                dfs((int)node);
            }
        }
    }

    /**
     * @param v = Starting Vertex
     */
    public void BFS(int v) {
        for (Vertex vertex : vertices) {
            vertex.isVisited = false;
        }
        ArrayList adjNodes = vertices[v].getAdjacentNodes();
        for (Object node : adjNodes) {
            if (!vertices[(int)node].isVisited) {
                bfs((int)node);
            }
        }
    }
    private void bfs(int v) {
        vertices[v].visit(v);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(v);
        while (q.peek() != null) {
            ArrayList adjNodes = vertices[q.peek()].getAdjacentNodes();
            for (Object node : adjNodes) {
                if (!vertices[(int)node].isVisited) {
                    vertices[(int)node].visit((int)node);
                    q.offer((int)node);
                }
            }
            q.remove();
        }
    }

    public String toString() {
        String matrixString = "";
        if (!directed) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j].getisEdge() != 0) {
                        matrixString += "1 ";
                    } else {
                        matrixString += "0 ";
                    }
                }
                matrixString += "\n";
            }
            return matrixString;
        } else {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j].getisEdge() == 1) {
                        matrixString += " 1 ";
                    } else if(matrix[i][j].getisEdge() == -1) {
                        matrixString += "-1 ";
                    } else {
                        matrixString += " 0 ";
                    }
                }
                matrixString += "\n";
            }
            return matrixString;
        }
    }
}
