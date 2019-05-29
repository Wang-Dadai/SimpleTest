package TestPackage;

import TestModle.BST;

public class BSTTest{
	
	public static void main(String[] args) {
		
		BST<String> tree = new BST<String>();
		
		tree.insert("sfad");
		tree.insert("sfafasd");
		tree.insert("aaaaba");
		tree.insert("aaabbb");
		tree.insert("aaaaaa");
		
		tree.inorder();
		tree.postorder();
		tree.preorder();
		tree.delete("aaaaaa");
		tree.inorder();
		System.out.println("testIterator");
		for(String str : tree){
			System.out.println(str);
		}
	}
	
}
