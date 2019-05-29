package TestModle;

import java.util.ArrayList;

import TestModle.BST.TreeNode;
import myInterface.Tree;

public class AVLTree<E extends Comparable<E>> extends BST<E> {
	
	public AVLTree(){
		
	}
	
	public AVLTree(E[] objects){
		super(objects);
	}

	@Override
	public boolean insert(E e) {
		// TODO Auto-generated method stub
		boolean successful = super.insert(e);
		
		if(!successful){
			return false;
		}else{
			
			balancePath(e);
		}
		
		return super.insert(e);
	}

	@Override
	protected AVLTreeNode<E> createNewNode(E e){
		return new AVLTreeNode<E>(e);
	}
	
	private void balancePath(E e) {
		// TODO Auto-generated method stub
		
		ArrayList<TreeNode<E>> path = path(e);
		for(int i=path.size()-1;i>=0;i--){
			
			AVLTreeNode<E> A = (AVLTreeNode<E>)(path.get(i));
			updateHeight(A);
			AVLTreeNode<E> parentOfA = (A==root)?null:(AVLTreeNode<E>)(path.get(i-1));
			
			switch(balanceFactor(A)){
			case -2:
				if(balanceFactor((AVLTreeNode<E>)A.left)<0){
					balanceLL(A,parentOfA);
				}else{
					balanceLR(A,parentOfA);
				}
			case +2:
				if(balanceFactor((AVLTreeNode<E>)A.right)>0){
					balanceRR(A,parentOfA);
				}else{
					balanceRL(A,parentOfA);
				}
			
			}
		}
		
	}

	private void balanceRL(AVLTreeNode<E> a, AVLTreeNode<E> parentOfA) {
		// TODO Auto-generated method stub
		TreeNode<E> b = a.right;
		TreeNode<E> c = b.left;
		
		if(a == root){
			root = c;
		}else{
			
			if(parentOfA.left == a){
				parentOfA.left = c;
			}else{
				parentOfA.right = c;
			}
		}
		
		b.left = c.right;
		c.right = b;
		a.right = c.left;
		c.left = a;
		
		updateHeight(a);
		updateHeight((AVLTreeNode<E>)b);
		updateHeight((AVLTreeNode<E>)c);
	}

	private void balanceRR(AVLTreeNode<E> a, AVLTreeNode<E> parentOfA) {
		// TODO Auto-generated method stub
		TreeNode<E> b = a.right;
		
		if(a == root){
			root = b;
		}else{
			
			if(parentOfA.left == a){
				parentOfA.left =b; 
			}else{
				parentOfA.right =b;
			}
		}
		
		a.right = b.left;
		b.left = a;
		updateHeight(a);
		updateHeight((AVLTreeNode<E>)b);
		
	}

	private void balanceLR(AVLTreeNode<E> a, AVLTreeNode<E> parentOfA) {
		// TODO Auto-generated method stub
		TreeNode<E> b = a.left;
		TreeNode<E> c = b.right;
		
		if(root == a){
			root =c;
		}else{
			if(parentOfA.left == a){
				parentOfA.left = c;
			}else{
				parentOfA.right = c;
			}
		}
		
		b.right = c.left;
		c.left = b;
		a.left = c.right;
		c.right = a;
		
		updateHeight(a);
		updateHeight((AVLTreeNode<E>)b);
		updateHeight((AVLTreeNode<E>)c);
		
	}

	private void balanceLL(AVLTreeNode<E> a, AVLTreeNode<E> parentOfA) {
		// TODO Auto-generated method stub
		TreeNode<E> b = a.left;
		
		if(a == root){
			root = b;
		}else{
			
			if(parentOfA.left == a){
				parentOfA.left = b;
			}else if(parentOfA.right ==a){
				parentOfA.right =b;
			}
		}
		a.left = b.right;
		b.right = a;
		updateHeight(a);
		updateHeight((AVLTreeNode<E>)b);
		
	}

	private int balanceFactor(AVLTreeNode<E> a) {
		// TODO Auto-generated method stub
		if(a.left == null){
			return a.height;
		}else if(a.right == null){
			return -a.height;
		}else{
			return ((AVLTreeNode<E>)(a.right)).height - ((AVLTreeNode<E>)(a.left)).height;
		}
		
	}

	private void updateHeight(AVLTreeNode<E> a) {
		// TODO Auto-generated method stub
		
		if(a.left == null && a.right == null){
			a.height = 0;
		}else if(a.left == null){
			a.height = 1 + ((AVLTreeNode<E>)(a.right)).height;
		}else if(a.right == null){
			a.height = 1 + ((AVLTreeNode<E>)(a.left)).height;
		}else{
			a.height = 1 + Math.max(((AVLTreeNode<E>)(a.right)).height, ((AVLTreeNode<E>)(a.left)).height);
		}
		
	}

	@Override
	public boolean delete(E e) {
		// TODO Auto-generated method stub
		if(root == null){
			return false;
		}
		
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
			else{
				if(e.compareTo(parent.element)<0){
					parent.left = current.right;
				}else if(e.compareTo(parent.element)>0){
					parent.right = current.right;
				}
				balancePath(parent.element);
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
			balancePath(maxLeftParent.element);
			
		}
		
		size--;
		return true;
	}

	public static class AVLTreeNode<T extends Comparable<T>> extends BST.TreeNode<T>{

		public int height = 0;
		
		public AVLTreeNode(T t) {
			super(t);
			// TODO Auto-generated constructor stub
		}
		
		
	}
	
}
