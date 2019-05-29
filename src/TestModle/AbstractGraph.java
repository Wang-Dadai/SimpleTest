package TestModle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import myInterface.MyGraph;

public class AbstractGraph<V> implements MyGraph<V> {

	public static class Edge {
		public int v;
		public int u;
		
		public Edge(int v,int u){
			this.v = v;
			this.u = u;
		}
		
		public boolean equals(Object o){
			return u == ((Edge)o).u && v == ((Edge)o).v;
		}
		
	}

	protected List<V> vertices = new ArrayList<V>();
	protected List<List<Edge>> neighbors = new ArrayList<List<Edge>>();
	
	protected AbstractGraph(){
		
	}
	
	protected AbstractGraph(V[] vertices,int[][] edges){
		for(int i=0;i<vertices.length;i++){
			addVertex(vertices[i]);
		}
		
		createAdjacencyLists(edges,vertices.length);
	}
	
	protected AbstractGraph(List<V> vertices,List<Edge> edges){
		for(int i=0;i<vertices.size() ; i++){
			
			addVertex(vertices.get(i));
		}
		
		createAdjacencyLists(edges, vertices.size());
	}
	
	protected AbstractGraph(List<Edge> edges,int numberOfVertices){
		
		for(int i = 0; i<numberOfVertices ; i++){
			addVertex((V)(new Integer(i)));
		}
		
		createAdjacencyLists(edges, numberOfVertices);
	}
	
	protected AbstractGraph(int[][] edges,int numberOfVertices){
		for(int i = 0; i < numberOfVertices; i++){
			addVertex((V)(new Integer(i)));
		}
		
		createAdjacencyLists(edges, numberOfVertices);
		
	}
	
	private void createAdjacencyLists(List<Edge> edges, int size) {
		// TODO Auto-generated method stub
		if(edges!=null && edges.size()>0){
			for (Edge edge : edges ){
				addEdge(edge.u,edge.v);
			}
		}
		
	}

	private void createAdjacencyLists(int[][] edges, int length) {
		// TODO Auto-generated method stub
		for(int i=0;i<edges.length;i++){
			addEdge(edges[i][0], edges[i][1]);
		}
		
	}

	public class Tree{
		
		private int root;
		private int[] parent;
		private List<Integer> searchOrder;
		
		public Tree(int root,int[] parent,List<Integer> searchOrder){
			this.parent = parent;
			this.root = root;
			this.searchOrder = searchOrder;
		}
		
		public int getRoot(){
			return root;
		}
		
		public int getParent(int v){
			return parent[v];
		}
		
		public List<Integer> getSearchOrder(){
			return searchOrder;
		}
		
		public int getNumberOfVerticesFound(){
			return searchOrder.size();
		}
		
		public List<V> getPath(int index){
			ArrayList<V> path = new ArrayList<V>();
			
			do{
				path.add(vertices.get(index));
				index = parent[index];
			}while(index != -1);
			
			return path;
		}
		
		public void printPath(int index){
			List<V> path = getPath(index);
			System.out.print("A path from "+vertices.get(root) + "to "+vertices.get(index)+":");
			for(int i=0;i<path.size();i++){
				System.out.print(path.get(i)+"");
			}
		}
		
		public void printTree(){
			System.out.println("root is :"+vertices.get(root));
			System.out.print("Edges: ");
			for(int i=0;i<parent.length;i++){
				if(parent[i] != -1){
					System.out.print("("+vertices.get(parent[i])+", "+vertices.get(i)+")");
				}
			}
			System.out.println("");
		}
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return vertices.size();
	}

	@Override
	public List<V> getVertices() {
		// TODO Auto-generated method stub
		return vertices;
	}

	@Override
	public V getVertex(int index) {
		// TODO Auto-generated method stub
		return vertices.get(index);
	}

	@Override
	public int getIndex(V v) {
		// TODO Auto-generated method stub
		return vertices.indexOf(v);
	}

	@Override
	public List<Integer> getNeighbors(int index) {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<Integer>();
		
		for(Edge edge : neighbors.get(index)){
			result.add(edge.v);
		}
		
		return result;
	}

	@Override
	public int getDegree(int v) {
		// TODO Auto-generated method stub
		return neighbors.get(v).size();
	}

	@Override
	public void printEdges() {
		// TODO Auto-generated method stub
		for(int i=0;i<vertices.size();i++){
			System.out.print(getVertex(i)+":("+i+")");
			for(Edge edge : neighbors.get(i)){
				System.out.print("("+getVertex(edge.u)+","+getVertex(edge.v)+")");
			}
			System.out.println("");
		}
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		vertices.clear();
		neighbors.clear();
		
	}

	@Override
	public boolean addVertex(V vertex) {
		// TODO Auto-generated method stub
		if(!vertices.contains(vertex)){
			vertices.add(vertex);
			neighbors.add(new ArrayList<Edge>());//邻接线性表存储每个顶点的邻接边
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean addEdge(int u, int v) {
		// TODO Auto-generated method stub
		return addEdge(new Edge(u,v));
	}

	protected boolean addEdge(Edge edge) {
		// TODO Auto-generated method stub
		if(edge.u < 0 || edge.u > getSize()-1){
			throw new IllegalArgumentException("No such index: "+edge.u);
		}
		if(edge.v < 0 || edge.v > getSize()-1){
			throw new IllegalArgumentException("No such index: "+edge.v);
		}
		if(!neighbors.get(edge.u).contains(edge)){
			neighbors.get(edge.u).add(edge);
			return true;
		}
		
		return false;
	}

	@Override
	public Tree dfs(int v) {
		// TODO Auto-generated method stub
		List<Integer> searchOrder = new ArrayList<Integer>();
		int [] parent = new int[vertices.size()];
		for(int i=0;i<parent.length;i++){
			parent[i] = -1;
		}
		boolean[] isVisited = new boolean[vertices.size()];
		dfs(v,parent,searchOrder,isVisited);
		
		return new Tree(v,parent,searchOrder);
	}

	private void dfs(int u, int[] parent, List<Integer> searchOrder, boolean[] isVisited) {
		// TODO Auto-generated method stub
		
		searchOrder.add(u);
		isVisited[u] = true;
		
		for(Edge edge : neighbors.get(u)){
			if(!isVisited[edge.v]){
				parent[edge.v] = u;
				dfs(edge.v,parent,searchOrder,isVisited);
			}
		}
		
	}

	@Override
	public Tree bfs(int v) {
		// TODO Auto-generated method stub
		List<Integer> searchOrder = new ArrayList<Integer>();
		int[] parent = new int[vertices.size()];
		for(int i=0;i<parent.length;i++){
			parent[i] = -1;
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] isVisited = new boolean[vertices.size()];
		queue.offer(v);
		isVisited[v] = true;
		
		while(!queue.isEmpty()){
			int u = queue.poll();
			searchOrder.add(u);
			for(Edge edge : neighbors.get(u)){
				if(!isVisited[edge.v]){
					queue.offer(edge.v);
					parent[edge.v] = u;
					isVisited[edge.v] =true;
				}
			}
		}
		
		return new Tree(v,parent,searchOrder);
	}
	
	
}
