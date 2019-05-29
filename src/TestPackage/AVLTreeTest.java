package TestPackage;

import TestModle.AVLTree;

public class AVLTreeTest {

	public static void main(String[] args) {
		
		AVLTree<Integer> tree = new AVLTree<Integer>(); 
		tree.insert(12);
		tree.insert(13);
		tree.insert(15);
		tree.delete(15);
		
		tree.inorder();
		
	}
	
}
 