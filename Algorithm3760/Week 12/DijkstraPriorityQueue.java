package Lab10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
 
 
public class DijkstraPriorityQueue
{

	public static void main(String[] args) {
		//create new graph
		Graph G = new Graph();
		//init all the nodes(cities)
		Node SanLuisObispo = new Node("San Luis Obispo");
		Node Bakerfield = new Node("Bakerfield");
		Node Mojave = new Node("Mojave");
		Node WheelerRidge = new Node("Wheeler Ridge");
		Node SantaBarbara = new Node("Santa Barbara");
		Node LosAngeles = new Node("Los Angeles");
		Node SanDiego = new Node("San Diego");
		Node SanBernardino = new Node("San Bernardino");
		Node Barstow = new Node("Barstow");
		Node Baker = new Node("Baker");
		Node LasVegas = new Node("Las Vegas");
		
		//add all the rouths for each cities
		SanLuisObispo.addDestination(Bakerfield, 117);
		SanLuisObispo.addDestination(SantaBarbara, 106);
		
		Bakerfield.addDestination(Mojave, 65);
		Bakerfield.addDestination(WheelerRidge, 24);
		
		Mojave.addDestination(LosAngeles, 94);
		Mojave.addDestination(Barstow, 70);
		
		WheelerRidge.addDestination(Bakerfield, 24);
		WheelerRidge.addDestination(LosAngeles, 88);
		
		SantaBarbara.addDestination(SanLuisObispo, 106);
		SantaBarbara.addDestination(LosAngeles, 95);
		
		LosAngeles.addDestination(SantaBarbara, 95);
		LosAngeles.addDestination(WheelerRidge, 88);
		LosAngeles.addDestination(Mojave, 94);
		LosAngeles.addDestination(SanBernardino, 65);
		LosAngeles.addDestination(SanDiego, 121);
		
		SanDiego.addDestination(LosAngeles, 121);
		SanDiego.addDestination(SanBernardino, 103);
		
		SanBernardino.addDestination(SanDiego, 103);
		SanBernardino.addDestination(LosAngeles, 65);
		SanBernardino.addDestination(Barstow, 73);
		
		Barstow.addDestination(Baker, 62);
		Barstow.addDestination(Mojave, 70);
		Barstow.addDestination(SanBernardino, 73);
		
		Baker.addDestination(Barstow, 62);
		Baker.addDestination(LasVegas, 92);
		
		LasVegas.addDestination(Baker, 92);
		
		//add all the nodes(cities) in Graph
		G.addNode(SanLuisObispo);
		G.addNode(Bakerfield);
		G.addNode(Mojave);
		G.addNode(WheelerRidge);
		G.addNode(SantaBarbara);
		G.addNode(LosAngeles);
		G.addNode(SanDiego);
		G.addNode(SanBernardino);
		G.addNode(Barstow);
		G.addNode(Baker);
		G.addNode(LasVegas);
		
		//create a test class
		DijkstraPriorityQueue test = new DijkstraPriorityQueue();
		
		//Decide source and dest for the test case
		Node source = SantaBarbara;
		Node dest = LasVegas;
		//store the the grapgh after we ran dijkstra algo and set the source point to Sata Barara
		Graph output = test.dijkstra(G, SantaBarbara);
		
		//create arraylist to store the city backwards
		ArrayList<String> temp = new ArrayList<>();
		
		//find the dest we looking for and start from there call add its parent to the temp arraylist
		for(Node n :output.getNodes()) {
			if(n.getName().equals(dest.getName())){
				while(n.getParent()!=null) {
					temp.add(n.getName());
					n = n.getParent();
				}
			}
		}
		
		//add the source point to temp 
		temp.add(SantaBarbara.getName());
		
		//print out the route it take from source to dest
		Collections.reverse(temp);
		System.out.println(temp);
		System.out.println("The shortest distance between " +source.getName() + " and " + dest.getName() + " is " + dest.getDistance() + " miles");
	}
	static int[] dist;
	static String[] pred;
	static PriorityQueue<Node> pq;
	static Map<Node, Integer> adjWithDist;
	static Set<Node> adjNode;
	static Node u;
   public Graph dijkstra(Graph G, Node source) {
	   //the distance between source to source is 0
	   source.setDistance(0);
	   
	   //Add all vertices to a PQ with distance from sources as the key
	   MinComparator pqMaxComparetor = new MinComparator();
       pq = new PriorityQueue<Node>(G.getNodes().size(),pqMaxComparetor );
       for(Node vertex  : G.getNodes()) {
    	   pq.add(vertex);
       }
       
       //while there are still vertices in pq
       while(!pq.isEmpty()) {
    	   //get next vertex u from the pq
    	   u = pq.poll();
    	   //for each vertex v adjacent to u
    	   adjWithDist = u.getAdjacentNodes();
    	   adjNode = adjWithDist.keySet();
    	   for(Node v : adjNode) {
    		   //if v is still in pq, relax v
    		   if(pq.contains(v)) {
    			   relax(v);
    		   }
    	   }
       } 
	return G;
	   
   }
   private void relax(Node v) {
	   //if d[u] + w(u,v) < d[v]
		  if(u.getDistance() + adjWithDist.get(v)< v.getDistance()) {
			//d[v] <- d[u] + w(u,v)
			  v.setDistance(u.getDistance() + adjWithDist.get(v));
			  //prev[v] <- u
			  v.setParent(u);
		  }
	
}
	static class MinComparator implements Comparator<Node> {
			@Override
			public int compare(Node arg0, Node arg1) {
				
				return arg0.getDistance() - arg1.getDistance();
			}
	    }
}