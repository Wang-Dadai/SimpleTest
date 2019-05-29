package myInterface;

import java.util.List;

import TestModle.AbstractGraph;

public interface MyGraph<V> {

	public int getSize();
	
	public List<V> getVertices();
	
	public V getVertex(int index);
	
	public int getIndex(V v);
	
	public List<Integer> getNeighbors(int index);
	
	public int getDegree(int v);
	
	public void printEdges();
	
	public void clear();
	
	public boolean addVertex(V vertex);
	
	public boolean addEdge(int u,int v);
	
	public AbstractGraph<V>.Tree dfs(int v);//depth-first search
	
	public AbstractGraph<V>.Tree bfs(int v);//breadth-first search
	
}
