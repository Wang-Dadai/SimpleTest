package TestPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import TestModle.AbstractGraph;

public class WeightedGraph<V> extends AbstractGraph<V>{

	public WeightedGraph(){
		
	}
	
	public WeightedGraph(V[] vertices,int[][] edges){
		createWeightedGraph(Arrays.asList(vertices),edges);
	}
	
	public WeightedGraph(int[][] edges,int numberOfVertices){
		List<V> vertices = new ArrayList<V>();
		for(int i=0;i<numberOfVertices;i++){
			vertices.add((V)(new Integer(i)));
		}
		createWeightedGraph(vertices,edges);
	}
	
	public WeightedGraph(List<WeightedEdge> edges,int numberOfVertices){
		List<V> vertices = new ArrayList<V>();
		for(int i=0;i<numberOfVertices;i++){
			vertices.add((V)(new Integer(i)));
		}
		createWeightedGraph(vertices,edges);
	}
	
	public WeightedGraph(List<V> vertices,List<WeightedEdge> edges){
		createWeightedGraph(vertices,edges);
	}
	
	private void createWeightedGraph(List<V> vertices, List<WeightedEdge> edges) {
		// TODO Auto-generated method stub
		this.vertices = vertices;
		for(int i=0;i<vertices.size();i++){
			neighbors.add(new ArrayList<Edge>());
		}
		if(edges!=null && edges.size()>0){
			for(Edge edge : edges){
				neighbors.get(edge.u).add(edge);//因为weightedEdge是edge的子类所有可以匹配add（edge）方法
			}
		}
	}

	private void createWeightedGraph(List<V> vertices, int[][] edges) {
		// TODO Auto-generated method stub
		this.vertices = vertices;
		for(int i=0;i<vertices.size();i++){
			neighbors.add(new ArrayList<Edge>());
		}
		for(int i=0;i<edges.length;i++){
			neighbors.get(edges[i][0]).add(new WeightedEdge(edges[i][0],edges[i][1],edges[i][2]));
		}
		
	}
	
	public double getWeight(int u,int v) throws Exception{
		for(Edge edge : neighbors.get(u)){
			if(edge.v==v){
				return ((WeightedEdge)edge).weight;
			}
		}
		
		throw new Exception("Edge is not exist");
	}
	
	public void printWeightedEdges(){
		for(int i=0;i<getSize();i++){
			System.out.print(getVertex(i)+"("+i+")");
			for(Edge edge : neighbors.get(i)){
				System.out.print("("+edge.u+", "+edge.v+", "+((WeightedEdge)edge).weight+") ");
			}
			System.out.println("");
		}
	}
	
	public boolean addEdge(int u,int v,double weight){
		return addEdge(new WeightedEdge(u,v,weight));
	}
	
	public MST getMinimunSpanningTree(){
		return getMinimumSpanningTree(0);
	}

	private MST getMinimumSpanningTree(int index) {
		// TODO Auto-generated method stub
		double[] cost = new double[getSize()];
		for(int i=0;i<cost.length;i++){
			cost[i] = Double.POSITIVE_INFINITY;
		}
		cost[index] = 0;
		int[] parent = new int[getSize()];
		parent[index] = -1;
		double totalWeight = 0;
		
		List<Integer> T = new ArrayList<Integer>();
		while(T.size()<getSize()){
			
			int u = -1;
			double currentMinCost = Double.POSITIVE_INFINITY;
			for(int i=0;i<getSize();i++){
				if(!T.contains(i) && cost[i]<currentMinCost){
					
					currentMinCost = cost[i];
					u = i;
				}
			}
			
			T.add(u);
			totalWeight += currentMinCost;
			
			for(Edge edge : neighbors.get(u)){
				if(!T.contains(edge.v) && cost[edge.v]>((WeightedEdge)edge).weight){
					cost[edge.v] = ((WeightedEdge)edge).weight;
					parent[edge.v] = u;
				}
			}
		}
		
		return new MST(index,parent,T,totalWeight);
	}

	public class MST extends Tree {
		private double totalWeight;
		
		public MST(int root,int[] parent,List<Integer> searchOrder,double totalWeight){
			super(root,parent,searchOrder);
			this.totalWeight = totalWeight;
		}
		
		public double getTotalWeight(){
			return totalWeight;
		}
	}
	
	public ShortestPathTree getShortestPath(int index){
		
		double[] cost = new double[getSize()];
		for(int i=0;i<cost.length;i++){
			cost[i] = Double.POSITIVE_INFINITY;
		}
		cost[index] = 0;
		
		int[] parent = new int[getSize()];
		parent[index] = -1;
		
		List<Integer> T = new ArrayList<Integer>();
		
		while(T.size()<getSize()){
			int u=-1;
			double currentMinCost = Double.POSITIVE_INFINITY;
			for(int i=0;i<getSize();i++){
				if(!T.contains(i) && cost[i]<currentMinCost){
					currentMinCost = cost[i];
					u = i;
				}
			}
			
			T.add(u);
			
			for(Edge edge : neighbors.get(u)){
				if(!T.contains(edge.v) && cost[edge.v]>cost[u]+((WeightedEdge)edge).weight){
					cost[edge.v] = cost[u]+((WeightedEdge)edge).weight;
					parent[edge.v] = u;	
				}
			}
		}
		
		return new ShortestPathTree(index,parent,T,cost);
		
	}
	
	public class ShortestPathTree extends Tree{
		
		private double[] cost;
		
		public ShortestPathTree(int source,int[] parent,List<Integer> searchOrder,double[] cost){
			super(source,parent,searchOrder);
			this.cost = cost;
		}
		
		public double getCost(int v){
			return cost[v];
		}
		
		public void printAllPaths(){
			System.out.println("All shortest paths from "+vertices.get(getRoot())+"are :");
			for(int i=0;i<cost.length;i++){
				printPath(i);
				System.out.println("(cost: "+cost[i]+")");
			}
		}
	}
	
	public class WeightedEdge extends AbstractGraph.Edge implements Comparable<WeightedEdge>{
		
		public double weight;
		
		public WeightedEdge(int u,int v,double weight){
			super(u,v);
			this.weight = weight;
		}

		@Override
		public int compareTo(WeightedEdge o) {
			// TODO Auto-generated method stub
			if(this.weight>o.weight){
				return 1;
			}else if(weight==o.weight){
				return 0;
			}else{
				return -1;
			}
		}
	}
	
}
