package Lab8;

public class Edge {
	int value;
	public Edge(){
		value = 0;
	}
	public void AddEdge(){
		value = 1;
	}
	public void AddEdge(boolean directed){
		value = 2;
	}
	public void DeleteEdge() {
		value = 0;
	}
	public int getValue() {
		return value;
	}
}
