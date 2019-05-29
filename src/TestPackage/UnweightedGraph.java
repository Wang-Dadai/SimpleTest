package TestPackage;

import java.util.List;

import TestModle.AbstractGraph;

public class UnweightedGraph<V> extends AbstractGraph<V> {

	public UnweightedGraph(){
		
	}
	
	public UnweightedGraph(V[] vertices,int[][] edges){
		super(vertices,edges);
	}
	
	public UnweightedGraph(List<V> vertices,List<Edge> edges){
		super(vertices,edges);
	}
	
	public UnweightedGraph(List<Edge> edges,int numberOfVertices){
		super(edges,numberOfVertices);
	}
	
	public UnweightedGraph(int[][] edges,int numberOfVertices){
		super(edges,numberOfVertices);
	}
}