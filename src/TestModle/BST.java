package TestModle;

import java.util.ArrayList;
import java.util.Iterator;

import TestModle.AbstractTree;

public class BST<E extends Comparable<E>> extends AbstractTree<E>{
	
	public static class TreeNode<T extends Comparable<T>>{
		
		T element;
		TreeNode<T> left;
		TreeNode<T> right;
		
		public TreeNode(T t){
			element = t;
		}
		
	}
	
	protected TreeNode<E> root;
	protected int size = 0;
	
	public BST(){
		
	}
	
	public BST(E[] objects){
		for(int i=0;i<objects.length;i++){
			insert(objects[i]);
		}
	}

	@Override
	public boolean search(E e) {
		// TODO Auto-generated method stub
		TreeNode<E> current = root;
		while(current!=null){
			if(e.compareTo(current.element)<0){
				current = current.left;
			}else if(e.compareTo(current.element)>0){
				current = current.right;
			}else{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean insert(E e) {
		// TODO Auto-generated method stub
		if(root==null){
			root = createNewNode(e);
		}else{
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while(current!=null){
				
				if(e.compareTo(current.element)<0){
					parent = current;
					current = current.left;
				}else if(e.compareTo(current.element)>0){
					parent = current;
					current = current.right;
				}else{
					return false;
				}
			}
			
			if(e.compareTo(parent.element)<0){
				parent.left = createNewNode(e);
			}else if(e.compareTo(parent.element)>0){
				parent.right = createNewNode(e);
			}
			
		}
		
		size++;
		return true;
	}
	
	protected TreeNode<E> createNewNode(E e){
		return new TreeNode<E>(e);
	}

	@Override
	public boolean delete(E e) {
		// TODO Auto-generated method stub
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		//得到该节点与其父结点
		while(current!=null){
			
			if(e.compareTo(current.element)<0){
				parent = current;
				current = current.left;
			}else if(e.compareTo(current.element)>0){
				parent = current;
				current = current.right;
			}else{
				break;
			}
		}
		
		if(current==null){
			return false;
		}
		
		if(current.left==null){
			if(parent==null){
				root = current.right;
			}
			
			if(e.compareTo(parent.element)<0){
				parent.left = current.right;
			}else if(e.compareTo(parent.element)>0){
				parent.right = current.right;
			}
		}else{
			//左子节点存在
			//得到左子节点最大结点与其父结点
			TreeNode<E> maxLeft = current.left;
			TreeNode<E> maxLeftParent = current;
			
			while(maxLeft.right!=null){
				maxLeftParent = maxLeft;
				maxLeft = maxLeft.right;
			}
			
			current.element = maxLeft.element;
			
			if(maxLeftParent.right == maxLeft ){
				maxLeftParent.right = maxLeft.left;
			}else{
				maxLeftParent.left = maxLeft.left;//左子树右节点不存在的特殊情况
			}
			
		}
		
		size--;
		return true;
	}
	
	public ArrayList<TreeNode<E>> path(E e){
		
		ArrayList<TreeNode<E>> list = new ArrayList<TreeNode<E>>();
		
		TreeNode<E> current = root;
		while(current != null){
			list.add(current);
			if(e.compareTo(current.element)<0){
				current = current.left;
			}else if(e.compareTo(current.element)>0){
				current = current.right;
			}else{
				break;
			}
		}
		return list;//如果这个数不存在于树中呢 
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void inorder() {
		// TODO Auto-generated method stub
			inorder(root);
	}

	private void inorder(TreeNode<E> root) {
		// TODO Auto-generated method stub
		if(root==null){
			return;
		}else{
			inorder(root.left);
			System.out.println("Element:"+root.element);
			inorder(root.right);
		}
		
	}

	@Override
	public void postorder() {
		// TODO Auto-generated method stub
		postorder(root);
	}

	private void postorder(TreeNode<E> root) {
		// TODO Auto-generated method stub
		if(root==null){
			return;
		}
		else{
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.element+" ");
		}
		
	}

	@Override
	public void preorder() {
		// TODO Auto-generated method stub
		preorder(root);
	}

	private void preorder(TreeNode<E> root) {
		// TODO Auto-generated method stub
		if(root==null){
			return;
		}
		else{
			System.out.println(root.element+" ");
			preorder(root.left);
			preorder(root.right);
		}
		
	}
	
	public TreeNode<E> getRoot(){
		return root;
	}
	
	public void clear(){
		root = null;
		size = 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator();
	}

	protected class MyIterator implements Iterator<E>{

		private ArrayList<E> list = new ArrayList<E>();
		private int current = 0;
		
		public MyIterator() {
			// TODO Auto-generated constructor stub
			inorder();
		}
		
		private void inorder(){
			inorder(root);
		}
		
		private void inorder(TreeNode<E> root){
			if(root==null){
				return;
			}else{
				inorder(root.left);
				list.add(root.element);
				inorder(root.right);
			}
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(current<list.size()){
				return true;
			}
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return list.get(current++);
		}
		
		@Override
		public void remove(){
			
			delete(list.get(current));
			list.clear();
			inorder();
			
		}
	}
	
	
}
